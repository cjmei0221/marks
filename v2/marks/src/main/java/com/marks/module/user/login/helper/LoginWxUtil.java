package com.marks.module.user.login.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.http.HttpUtils;
import com.marks.module.cache.CacheData;
import com.marks.module.core.runModel.RunModel;
import com.marks.module.wx.manage.base.pojo.WxAccount;
import com.marks.module.wx.web.config.WxFwConfig;
import com.marks.module.wx.web.util.WxUtil;

public class LoginWxUtil {
	public static LoginWxUtil util = null;

	private LoginWxUtil() {
	}

	public static LoginWxUtil getInstance() {
		if(util==null){
			util = new LoginWxUtil();
		}
		return util;
	}
	public static String LOGINUSER_OPENID="LOGINUSER_OPENID";
	public static String LOGINUSER_ACCOUNTID="LOGINUSER_ACCOUNTID";
	private static Logger logger = Logger.getLogger(WxUtil.class);
	
	public String getWeixinUrl(String accountid,String url) throws UnsupportedEncodingException{
		logger.info("组装授权url>>start");
		WxAccount acc = CacheData.getWxAccount(accountid);
		String reurnurl="";
		url=acc.getAuthdomain()+url;
		url=URLEncoder.encode(url,"UTF-8");
		String wx_auth_url = WxFwConfig.weixin_connect_oauth2_authorize_base;
		reurnurl=String.format(wx_auth_url, acc.getAppid(),url);
		logger.info("返回>>"+reurnurl);
		return reurnurl;
	}
	public String getOpenIdByCode(String code, String accountid) {
		try {
			WxAccount wx = CacheData.getWxAccount(accountid);
			String appid = wx.getAppid();
			String appSercet = wx.getAppsecret();
			String url = String.format(WxFwConfig.weixin_connect_oauth2_access_token, appid,
					appSercet, code);
			JsonResult result= HttpUtils.getInstance().doGet(url, null, null, "UTF-8");
			JSONObject json = new JSONObject(result.getResult().toString());
			String openid = json.optString("openid", null);
			return openid;
		
		} catch (Exception e) {
			logger.error("JSONException error", e);
		}
		return null;
	}
	public String getCompleteUrl(String accountid,String url) throws UnsupportedEncodingException{
		WxAccount acc = CacheData.getWxAccount(accountid);
		url=acc.getAuthdomain()+url;
		logger.info("返回>>"+url);
		return url;
	}
	
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
