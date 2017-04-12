/**
 * 文件名：UnionPayNoticeController.java
 * 创建日期： 2015-04-14
 * Copyright (c) 2015 运通信息
 * All rights reserved.
 * 修改记录：
 * 
 */
package com.marks.module.web.pay.unionpay.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.number.NumberUtil;
import com.marks.common.util.properties.PropsUtil;
import com.marks.module.sys.system.core.data.StaticData;
import com.marks.module.web.pay.unionpay.sdk.AcpService;
import com.marks.module.web.pay.unionpay.sdk.SDKConstants;
import com.marks.module.web.pay.unionpay.thread.pool.PayThreadPool;
import com.marks.module.web.pay.unionpay.util.UnionPay_Wap;

/**
 * 银联交易通知控制器<br>
 * 
 * @author zqsheng
 * 
 */
@Controller
public class UnionPayController {

	private static Logger logger = Logger.getLogger(UnionPayController.class);

	

	@RequestMapping("/unionpay/pay")
	public void pay(HttpServletRequest request, HttpServletResponse response) {
		logger.info("在线支付方式:银联支付");
		Result result = new Result();
		String orderId = request.getParameter("orderId");
		//银联支付
		
		String html = null;
		String txnAmt = NumberUtil.formatNum(34534, "0");
		html = UnionPay_Wap.wan_consume_new(orderId, txnAmt);
		result.getData().put("unionpayHtml", html);
		result.setCode("0");
		result.setMessage("success");
		JsonUtil.output(response, result);
	}

	/**
	 * 产品：跳转网关支付产品<br>
	 * 功能：商户后台通知类<br>
	 * 日期：2015-04-14 作者：zqsheng
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/unionpay/notice/back")
	public void notice_back(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("--------银联交易后台通知开始--------");
		request.setCharacterEncoding("ISO-8859-1");
		String encoding = request.getParameter(SDKConstants.param_encoding);
		Map<String, String> reqParam = getAllRequestParam(request);// 获取请求参数中所有的信息
		Map<String, String> valideData = null;
		if (null != reqParam && !reqParam.isEmpty()) {
			Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
			valideData = new HashMap<String, String>(reqParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes("ISO-8859-1"), encoding);
				valideData.put(key, value);
			}
		}
		
		
		
		logger.info("打印银联返回的通知报文:" + valideData);
		if (!AcpService.validate(valideData, encoding)) { // 验证签名
			logger.info("通知报文验证签名结果[失败]...");
			logger.info("交易报文未及时返回成功，订单：" + valideData.get("orderId") + "状态修改为待确认收款：13");

			/*// 修改订单状态为：待确认收款（13）
			CustomerInfo loginUser = LoginUtil.getCurrentUserInfo(request);
			String userId = loginUser.getUserid();
			String userName = loginUser.getUsername();
			String userType = Enums.UserType.SP.getValue();//用户类型：店长
			try {
				orderService.changeOrderStatus(valideData.get("orderId"), Enums.OrderStatus.COMFIRMPAY.getValue(), userId, userName, userType);
			} catch (Exception e) {
				logger.error("修改订单状态异常");
			}*/
			
			//保存银联日志
			PayThreadPool.saveUnionPayLog(valideData, "1");
			logger.info("交易报文，订单：" + valideData.get("orderId") + "返回码：" + valideData.get("respCode"));
			
			if ("00".equals(valideData.get("respCode"))) { // 交易成功
				
				
				
			}
			
		} else {
			logger.info("通知报文验证签名结果[成功]...");
			PayThreadPool.saveUnionPayLog(valideData, "1");
			logger.info("交易报文，订单：" + valideData.get("orderId") + "返回码：" + valideData.get("respCode"));
			if ("00".equals(valideData.get("respCode"))) { // 交易成功
				/** ---------以下进行业务处理-------- **/
				if ("01".equals(valideData.get("txnType"))) { // 交易类型 01-消费(支付)
					// String orderId = valideData.get("orderId");
					if ("wap".equals(valideData.get("reqReserved"))) { // 手机端wap支付
						logger.info("手机端-wap支付成功后-业务处理");

					}
				}
				
				
				logger.info("交易报文及时返回成功，" +"返回码：" + valideData.get("respCode"));
			} else {// 交易报文返回交易失败，
				logger.info("交易报文未及时返回成功，" +"返回码：" + valideData.get("respCode"));
			}
			
		}
		logger.info("--------银联交易后台通知结束--------");
	}

	/**
	 * 产品：跳转网关支付产品<br>
	 * 功能：消费交易前台通知<br>
	 * 日期：2015-04-15 作者：zqsheng
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/unionpay/notice/front")
	public void notice_front(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("--------交易前台通知开始--------");
		request.setCharacterEncoding("ISO-8859-1");
		String encoding = request.getParameter(SDKConstants.param_encoding);
		Map<String, String> reqParam = getAllRequestParam(request);// 获取请求参数中所有的信息
		Map<String, String> valideData = null;
		if (null != reqParam && !reqParam.isEmpty()) {
			Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
			valideData = new HashMap<String, String>(reqParam.size());
			while (it.hasNext()) {
				Entry<String, String> e = it.next();
				String key = (String) e.getKey();
				String value = (String) e.getValue();
				value = new String(value.getBytes("ISO-8859-1"), encoding);
				valideData.put(key, value);
			}
		}
		boolean success = false;
		String paramsUrl = "";
		logger.info("打印银联返回的通知报文:" + valideData);
		if (AcpService.validate(valideData, encoding)) { // 验证签名
			logger.info("通知报文验证签名结果[成功]...");
			success = true;
			paramsUrl = PropsUtil.getValue("acp_sdk.properties").get("pay_success_page_url").toString();
			if ("wap".equals(valideData.get("reqReserved"))) { // 手机端wap支付
				logger.info("手机端-wap支付成功后-返回商户");
			}
		} else {
			logger.info("通知报文验证签名结果[失败]...");
			paramsUrl = PropsUtil.getValue("acp_sdk.properties").get("pay_fail_page_url").toString();
		}
		if (success) {
			try {
				String orderId = valideData.get("orderId");
				logger.info("通知报文验证签名结果[成功]...");
				String http = StaticData.getSysConf("appUrl");
				String params = "orderId=" + orderId + "&orderprice=" + valideData.get("txnAmt");
				String orderPageUrl = paramsUrl+ "?" + params;
				response.sendRedirect(orderPageUrl);
			} catch (Exception e) {
				logger.error("Exception", e);
			}
		}else{
			
			logger.info("---false---通知报文验证签名结果[失败]...");
			
			logger.info("---paramsUrl----" + paramsUrl);
			
			response.sendRedirect(paramsUrl);
		}
		logger.info("交易前台通知结束...");
	}

	/**
	 * 获取请求参数中所有的信息
	 * 
	 * @param request
	 */
	public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				// 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}
}
