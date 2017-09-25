package com.marks.module.wx.api.wxfwhao.common.wxservice;

import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.module.wx.api.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wx.api.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.wx.api.wxfwhao.common.utils.WxfwConfig;

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
		JsonResult result =WxHttpUtils.doPostJson(accountId,url,jsonObject,null);
		return result;
	}
	
}
