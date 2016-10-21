package com.grgbanking.module.wxfwhao.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.grgbanking.common.util.HttpUtils;
import com.grgbanking.common.util.JsonResult;
import com.grgbanking.module.system.data.WeChatAccountHelper;
import com.grgbanking.module.system.listener.DatabaseHelper;
import com.grgbanking.module.wxfwhao.entity.AccessTokenVo;
import com.grgbanking.module.wxfwhao.entity.WeChatAccount;
import com.grgbanking.module.wxfwhao.service.WeixinAccountService;

public class AccessTokenUtil {
	private static final long expires_in = 6900 * 1000;
	private static Logger logger = Logger.getLogger(AccessTokenUtil.class);
	private static Map<String, AccessTokenVo> accesstoken_map = new HashMap<String, AccessTokenVo>();
	WeixinAccountService weixinAccountService = (WeixinAccountService) DatabaseHelper
			.getBean(WeixinAccountService.class);
	private boolean updateflag = false;
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
		AccessTokenVo vo = null;
		if (updateflag) {
			try {
				if (null == weixinAccountService) {
					weixinAccountService = (WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
				}
				vo = weixinAccountService.getAccessTokenVoByAccountid(accountid);
				// vo=MemcachedUtil.getInstance().getACCESS_TOKEN(accountid);
			} catch (Exception e) {
				vo = accesstoken_map.get(accountid);
			}
		} else {
			vo = accesstoken_map.get(accountid);
		}
		//updateflag = true;
		if (vo == null) {
			vo = accesstoken_map.get(accountid);
		}
		// 首次
		if (vo == null) {
			vo = sendAccessTokenRequest(accountid);
			if (vo == null) {
				vo = sendAccessTokenRequest(accountid);
			}
		}
		if (null != vo) {
			long nowtime = System.currentTimeMillis();
			long time = Long.parseLong(vo.getPuttime());
			if ((nowtime - time) > expires_in) {
				vo = sendAccessTokenRequest(accountid);
			}
		}
		if (vo == null) {
			return null;
		}
		return vo.getAccesstoken();
	}

	public void putAccessToken(AccessTokenVo vo) {
		updateflag = false;
		accesstoken_map.put(vo.getAccountid(), vo);
		try {
			if (null == weixinAccountService) {
				weixinAccountService = (WeixinAccountService) DatabaseHelper.getBean(WeixinAccountService.class);
			}
			weixinAccountService.saveOrUpdateAccessTokenVo(vo);
			// MemcachedUtil.getInstance().putACCESS_TOKEN(vo.getAccesstoken(),
			// vo,Long.parseLong(vo.getExpires_in()));
		} catch (Exception e) {

		}
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
			WeChatAccount wx = WeChatAccountHelper.getWeChatAccount(accountid);
			Map<String, String> params = new HashMap<String, String>();
			params.put("appid", wx.getAppId());
			params.put("secret", wx.getAppSecret());
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
					putAccessToken(vo);
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
