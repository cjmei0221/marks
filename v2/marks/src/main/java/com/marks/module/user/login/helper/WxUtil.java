package com.marks.module.user.login.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.core.runModel.RunModel;

public class WxUtil {
	public static WxUtil util = null;

	private WxUtil() {
	}

	public static WxUtil getInstance() {
		if(util==null){
			util = new WxUtil();
		}
		return util;
	}
	public static String LOGINUSER_OPENID="LOGINUSER_OPENID";
	public static String LOGINUSER_ACCOUNTID="LOGINUSER_ACCOUNTID";
	private static Logger logger = Logger.getLogger(WxUtil.class);
	
	public String getCurrentOpenid(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(LOGINUSER_OPENID);
		String openid = null;
		if (null != obj && !"".equals(String.valueOf(obj)) && !"null".equals(String.valueOf(obj))) {
			openid = String.valueOf(obj);
		}
		if (RunModel.getInstance().getWeixinMode().equals("N")) {
			openid = "omDODtyudBQonntkn5MBMzNnTcVI";
		}
		return openid;
	}

	public void setCurrentOpenid(HttpServletRequest request, String openid) {
		request.getSession().setAttribute(LOGINUSER_OPENID, openid);
	}

	public void setCurrentAccountid(HttpServletRequest request, String accountid) {
		request.getSession().setAttribute(LOGINUSER_ACCOUNTID, accountid);
	}
	public String getCurrentAccountid(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(LOGINUSER_ACCOUNTID);
		String accountid = null;
		if (null != obj && !"".equals(String.valueOf(obj)) && !"null".equals(String.valueOf(obj))) {
			accountid = String.valueOf(obj);
		}
		if (RunModel.getInstance().getWeixinMode().equals("N")) {
			accountid = "wxbank";
		}
		return accountid;
	}

	

}
