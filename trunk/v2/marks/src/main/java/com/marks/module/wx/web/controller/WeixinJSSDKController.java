package com.marks.module.wx.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.common.util.IDUtil;
import com.marks.common.util.JsonUtil;
import com.marks.module.cache.CacheData;
import com.marks.module.system.myimage.pojo.MyImage;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.wx.manage.util.WxMpUtil;
import com.marks.module.wx.web.mp.SHAUtil;

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
	@RequestMapping("/web/jssdkConfig")
	public void getJsConfig(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		result.setCode(Code.CODE_SUCCESS);
		try {
			String accountId = LoginUtil.getInstance().getCurrentAccountid(request);
			String location = request.getParameter("location");

			String newTicket = WxMpUtil.getInstance().getJsSDKTicket(accountId);

			String url = location;
			String nonceStr = IDUtil.getUUID();
			String timestamp = (System.currentTimeMillis() / 1000) + "";

			String params = "jsapi_ticket=" + newTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
					+ url;
			logger.info("params:" + params);
			String signature = SHAUtil.digestSHA(params);
			logger.info("signature:" + signature);
			result.getData().put("appId", CacheData.getWxAccount(accountId).getAppid());
			result.getData().put("timestamp", timestamp);
			result.getData().put("nonceStr", nonceStr);
			result.getData().put("signature", signature);
		} catch (Exception e) {
			logger.info("获取jsSDK权限签名失败:", e);
			result.setCode(Code.CODE_FAIL);
			result.setMessage("系统繁忙");
		}
		request.setAttribute("result_msg", result.getCode() + "|" + result.getMessage());
		JsonUtil.output(response, result);
	}

	@RequestMapping("/web/js/media")
	public void getMediaId(HttpServletRequest request,
			HttpServletResponse response) {
		Result result = new Result();
		String accountId = LoginUtil.getInstance().getCurrentAccountid(request);
		try {
			String[] mediaIds = request.getParameterValues("mediaIds");
			logger.info("mediaIds:" + mediaIds);
			List<MyImage> list = new ArrayList<MyImage>();
			MyImage image =null;
			
			if(mediaIds!=null && mediaIds.length>0){
				for(String mediaId:mediaIds){
					logger.info("mediaId:" + mediaId);
					String fileName="Wx"+IDUtil.getUUID()+".jpg";
					result=WxMpUtil.getInstance().download(accountId,"image",fileName,mediaId);
					if(Code.CODE_SUCCESS.equals(result.getCode())){
						image = new MyImage();
						image.setPicUrl(fileName);
						list.add(image);
					}
				}
			}
			result.getData().put("path", list);
		} catch (Exception e) {
			logger.info("下载图片异常:"+e+",accountId="+accountId);
		}
		JsonUtil.output(response, result);
	}
	

	
	public static void main(String[] args) throws Exception {
		String newTicket = WxMpUtil.getInstance().getJsSDKTicket("wxbank");
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
