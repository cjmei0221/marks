package com.nfb.module.wxfwhao.wxservice;

import org.json.JSONObject;

import com.nfb.common.util.JsonResult;
import com.nfb.module.wxfwhao.utils.AccessTokenUtil;
import com.nfb.module.wxfwhao.utils.WxHttpUtils;
import com.nfb.module.wxfwhao.utils.WxfwConfig;

public class WxMaterialUtil {


	public static JsonResult getCount(String accountId) throws Exception {
		String accessToken =AccessTokenUtil.getInstance().getAccessToken(accountId);
		String url = WxfwConfig.materialCount+accessToken;
		JsonResult result =WxHttpUtils.doPostJson(accountId,url,new JSONObject(),null);
		return result;
	}

	public static JsonResult getMaterialList(String accountId, String type,
			String start) throws Exception {
		String accessToken =AccessTokenUtil.getInstance().getAccessToken(accountId);
		String url = WxfwConfig.materialList+accessToken;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", 20);
		jsonObject.put("type", type);
		jsonObject.put("offset", start);
		JsonResult result =WxHttpUtils.doPostJson2(accountId,url,jsonObject,null);
		return result;
	}
	
}
