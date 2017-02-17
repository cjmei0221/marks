package com.cjmei.module.weixin.wfhao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.weixin.mp.SHAUtil;
import com.cjmei.module.weixin.util.WxFwUtil;
import com.cjmei.module.weixin.wfhao.util.WxUtil;

@Controller
public class WeixinJSSDKController {
	private static Logger logger = Logger.getLogger(WeixinJSSDKController.class);

	/**
	 * 
	 * lhyan3 2015年6月1日下午4:43:10 TODO
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/js/config")
	public void getJsConfig(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(0);
		try {
			String accountId = WxUtil.getInstance().getCurrentAccountid(request);
			String location = request.getParameter("location");

			String newTicket = WxFwUtil.getInstance().getJsSDKTicket(accountId);

			String url = location;
			String nonceStr = IDUtil.getUUID();
			String timestamp = (System.currentTimeMillis() / 1000) + "";

			String params = "jsapi_ticket=" + newTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
					+ url;
			logger.info("params:" + params);
			String signature = SHAUtil.digestSHA(params);
			logger.info("signature:" + signature);
			result.getData().put("appId", StaticData.getWxAccount(accountId).getAppid());
			result.getData().put("timestamp", timestamp);
			result.getData().put("nonceStr", nonceStr);
			result.getData().put("signature", signature);
		} catch (Exception e) {
			logger.info("获取jsSDK权限签名失败:", e);
			result.setCode(-1);
			result.setMessage("系统繁忙");
		}
		request.setAttribute("result_msg", result.getCode() + "|" + result.getMessage());
		JsonUtil.output(response, result);
	}

	public static void main(String[] args) throws Exception {
		String newTicket = WxFwUtil.getInstance().getJsSDKTicket("wxbank");
		String url = "https://wxcs.hebbank.com/wechat/test/jssdkTest.html";
		String nonceStr = IDUtil.getUUID();
		String timestamp = (System.currentTimeMillis() / 1000) + "";
		System.out.println("jsapi_ticket:" + newTicket);
		System.out.println("noncestr:" + nonceStr);
		System.out.println("timestamp:" + timestamp);
		System.out.println("url:" + url);
		String params = "jsapi_ticket=" + newTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
				+ url;
		String signature = SHAUtil.digestSHA(params);
		System.out.println("signature:" + signature);
	}
}
