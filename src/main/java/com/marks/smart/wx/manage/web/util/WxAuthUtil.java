package com.marks.smart.wx.manage.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.http.HttpUtils;
import com.marks.smart.system.cache.CacheData;
import com.marks.smart.wx.manage.mp.entity.WxAccount;
import com.marks.smart.wx.manage.web.config.WxFwConfig;

public class WxAuthUtil {
	public static WxAuthUtil util = null;

	private WxAuthUtil() {
	}

	public static WxAuthUtil getInstance() {
		if(util==null){
			util = new WxAuthUtil();
		}
		return util;
	}
	private static Logger logger = Logger.getLogger(WxAuthUtil.class);
	
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

}
