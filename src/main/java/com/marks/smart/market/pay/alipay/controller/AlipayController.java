package com.marks.smart.market.pay.alipay.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.number.NumberUtil;
import com.marks.smart.market.pay.alipay.alipay.Alipay_Wap;
import com.marks.smart.market.pay.alipay.alipay.config.AlipayConfig;
import com.marks.smart.market.pay.alipay.alipay.util.AlipayNotify;
import com.marks.smart.market.pay.alipay.pojo.AlipayLog;
import com.marks.smart.market.pay.alipay.service.AlipayService;
import com.marks.smart.system.user.login.helper.LoginUtil;
@Controller
public class AlipayController {
	private static Logger logger = Logger.getLogger(AlipayController.class);
	
	@Autowired
	private AlipayService alipayService;
	
	private String accountId="wxfwhao";
	

	/**
	 * 支付宝手机网站在线支付
	 * @param request
	 * @param response
	 */
	@RequestMapping("/web/alipay/payHtml")
	public void pay(HttpServletRequest request,HttpServletResponse response) {
		String orderId = request.getParameter("orderId");
		Result result = new Result();
		String html = null;
		try {
			accountId = LoginUtil.getInstance().getCurrentAccountid(request);
			String txnAmt = String.valueOf("2342");
			Double txnAmtd=Double.parseDouble(txnAmt);
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("out_trade_no", "awerwerwer");//商户网站唯一订单号
			paramMap.put("subject", "奶粉");
			paramMap.put("total_fee", NumberUtil.formatNumber(txnAmtd,"0.00"));
			html = Alipay_Wap.wap_consume(paramMap,0,accountId);
			result.getData().put("payHtml", html);
			result.setCode("0");
			result.setMessage("success");
		} catch (Exception e) {
			logger.error("Exception", e);
			result.setCode("-1");
			result.setMessage("error");
		}
		JsonUtil.output(response, result);
	}
	
	
	/**
	 * 支付宝手机网站在线支付 微信内置浏览器
	 * @param request
	 * @param response
	 */
	@RequestMapping("/web/alipay/payUrl")
	public void pay2(HttpServletRequest request,HttpServletResponse response) {
		String orderId = request.getParameter("orderId");
		Result result = new Result();
		String html = null;
		try {
			accountId = LoginUtil.getInstance().getCurrentAccountid(request);
			String txnAmt = String.valueOf("");
			Double txnAmtd=Double.parseDouble(txnAmt);
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("out_trade_no", "");//商户网站唯一订单号
			paramMap.put("subject", "奶粉");
			paramMap.put("total_fee", NumberUtil.formatNumber(txnAmtd,"0.00"));
			html = Alipay_Wap.wap_consume(paramMap,1,accountId);
			result.getData().put("payUrl", html);
			result.setCode("0");
			result.setMessage("success");
		} catch (Exception e) {
			logger.error("Exception", e);
			result.setCode("-1");
			result.setMessage("error");
		}
		JsonUtil.output(response, result);
	}
	/**
	 * 前端通知
	 * @param request
	 * @param response
	 */
	@RequestMapping("/web/alipay/frontNotice")
	public void frontNotice(HttpServletRequest request,HttpServletResponse response) {
		try {
			Map<String,String> paramMap = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				paramMap.put(name, valueStr);
				logger.info("frontNotice>>"+name+":"+valueStr);
			}
			String is_success=request.getParameter("is_success");
			
			String orderId=request.getParameter("out_trade_no");//商户网站唯一订单号
			String trade_status=request.getParameter("trade_status");//交易状态
			String total_feeStr=request.getParameter("total_fee");//交易金额
			double total_fee=Double.parseDouble(total_feeStr)*100;
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
			accountId=request.getParameter("accountId");
			//验证合法性
			if(AlipayNotify.verify(paramMap,accountId)){
				logger.info("frontNotice验证通过，进行业务处理");
				if("T".equals(is_success) && ("TRADE_FINISHED".equals(trade_status) ||"TRADE_SUCCESS".equals(trade_status))){
					String paramsUrl = AlipayConfig.getInstance().getPay_success_page_url(accountId);
					String params = "orderId="+orderId+"&orderprice="+total_fee;
					String orderPageUrl =paramsUrl+"?"+params;
					response.sendRedirect(orderPageUrl);
				}else{
					logger.info("交易失败");
					String paramsUrl =AlipayConfig.getInstance().getPay_fail_page_url(accountId);
					String params = "orderId="+orderId+"&orderprice="+total_fee;
					String orderPageUrl =paramsUrl+"?"+params;
					response.sendRedirect(orderPageUrl);
				}
			}else{
				logger.info("frontNotice验证不通过");
				//验证失败
				String paramsUrl =AlipayConfig.getInstance().getPay_fail_page_url(accountId);
				String params = "orderId="+orderId+"&orderprice="+total_fee;
				String orderPageUrl =paramsUrl+"?"+params;
				response.sendRedirect(orderPageUrl);
			}
		} catch (Exception e) {
			logger.error("Exception", e);
		}
	}
	
	/**
	 * 后台通知
	 * @param request
	 * @param response
	 */
	@RequestMapping("/web/alipay/backNotice")
	public void backNotice(HttpServletRequest request,HttpServletResponse response) {
		try {
			String sign_type=request.getParameter("sign_type");
			String sign=request.getParameter("sign");
			String notify_id=request.getParameter("notify_id");
			String notify_time=request.getParameter("notify_time");
			String notify_type=request.getParameter("notify_type");
			String orderId=request.getParameter("out_trade_no");//商户网站唯一订单号
			String trade_no=request.getParameter("trade_no");//支付宝交易号
			String trade_status=request.getParameter("trade_status");//交易状态
			String total_feeStr=request.getParameter("total_fee");//交易金额
			
			String gmt_payment=request.getParameter("gmt_payment");//交易付款时间
			String buyer_email=request.getParameter("buyer_email");//交易金额
			String buyer_id=request.getParameter("buyer_id");//交易金额
			String refund_status=request.getParameter("refund_status");//交易金额
			String gmt_refund=request.getParameter("gmt_refund");//交易金额
			String subject=request.getParameter("subject");//交易金额
			Map<String,String> paramMap = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				paramMap.put(name, valueStr);
				logger.info("backNotice>>"+name+":"+valueStr);
			}
			
			
			double total_fee=Double.parseDouble(total_feeStr)*100;
			logger.info("通知参数："
					+"-sign_type="+sign_type
					+"-sign="+sign
					+"-notify_id="+notify_id
					+"-notify_time="+notify_time
					+"-notify_type="+notify_type
					+"-orderId="+orderId
					+"-trade_no="+trade_no
					+"-trade_status="+trade_status
					+"-total_fee="+total_fee
					+"-gmt_payment="+gmt_payment
					+"-buyer_email="+buyer_email
					+"-buyer_id="+buyer_id
					+"-refund_status="+refund_status
					+"-gmt_refund="+gmt_refund
					+"-subject="+subject
					);
			//验证合法性
			/*if(AlipayNotify.verify(paramMap)){*/
				logger.info("backNotice验证通过，进行业务处理");
				AlipayLog log=new AlipayLog();
				log.setBuyer_email(buyer_email);
				log.setBuyer_id(buyer_id);
				log.setGmt_payment(gmt_payment);
				log.setNotify_id(notify_id);
				log.setNotify_time(notify_time);
				log.setNotify_type(notify_type);
				log.setOrderid(orderId);
				log.setTotal_fee(total_fee+"");
				log.setTrade_no(trade_no);
				log.setTrade_status(trade_status);
				alipayService.saveAlipayLog(log);
				//业务执行
				if("TRADE_FINISHED".equals(trade_status) ||"TRADE_SUCCESS".equals(trade_status)){
					
				}
				response.getWriter().print("success");
				response.getWriter().close();
			/*}else{
				logger.info("backNotice验证不通过");
				
				//修改订单状态为：待确认收款（13）
				//orderInfoService.confirmReceipt(13, orderId);
			}*/
		} catch (Exception e) {
			logger.error("Exception", e);
		}
	}
}
