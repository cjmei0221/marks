package com.marks.module.wx.api.wxInterface.mp.base.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.http.HttpUtils;
import com.marks.module.cache.CacheData;
import com.marks.module.wx.api.util.WxCacheData;
import com.marks.module.wx.api.wxInterface.mp.base.entity.AccessTokenVo;
import com.marks.module.wx.manage.entity.base.WxAccount;

public class AccessTokenUtil {
	private static Logger logger = Logger.getLogger(AccessTokenUtil.class);

	private static AccessTokenUtil util = null;

	private AccessTokenUtil() {
	};

	public static AccessTokenUtil getInstance() {
		if (util == null) {
			util = new AccessTokenUtil();
		}
		return util;
	}

	public String getAccessToken(String accountid) {
		AccessTokenVo vo = WxCacheData.getInstance().getAccessToken(accountid);
		// 首次
		if (vo == null) {
			vo = sendAccessTokenRequest(accountid);
		}
		if (vo == null) {
			return null;
		}
		return vo.getAccesstoken();
	}

	/***
	 * 获取当前公众号Token
	 * 
	 * @param appId
	 *            微信号id
	 * @param secret
	 *            密码
	 * @return jsonResult
	 */
	public synchronized AccessTokenVo sendAccessTokenRequest(String accountid) {
		AccessTokenVo vo = null;
		JsonResult jsonResult = new JsonResult();
		String url = WxfwConfig.weixin_server_prefix + "/token?grant_type=client_credential";
		try {
			WxAccount wx = CacheData.getWxAccount(accountid);
			Map<String, String> params = new HashMap<String, String>();
			params.put("appid", wx.getAppid());
			params.put("secret", wx.getAppsecret());
			JsonResult returnJson = HttpUtils.getInstance().doGet(url, params, null, "utf-8");
			if (returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null) {
				JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
				if (returnJson.getResult().toString().indexOf("access_token") != -1) {
					logger.info("access_token:" + jsonObj.get("access_token").toString());
					vo = new AccessTokenVo();
					vo.setAccesstoken(jsonObj.get("access_token").toString());
					vo.setAccountid(accountid);
					vo.setExpires_in(jsonObj.getLong("expires_in") + "");
					vo.setPuttime(System.currentTimeMillis() + "");
					// 放入缓存
					WxCacheData.getInstance().putAccessToken(vo);
				} else {
					jsonResult.setSuccess(Boolean.FALSE);
					jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
					jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
				}
			} else {
				jsonResult.setSuccess(Boolean.FALSE);
				jsonResult.setErrorCode("9999");
				jsonResult.setErrorMsg("return data null");
			}
		} catch (Exception ex) {
			logger.info("获取access_token失败");
			jsonResult.setSuccess(Boolean.FALSE);
			jsonResult.setErrorCode("9999");
			jsonResult.setErrorMsg(ex.getMessage());
		}
		logger.info("sendAccessTokenRequest>>" + jsonResult.getErrorCode() + "-" + jsonResult.getErrorCode());
		return vo;
	}

}
