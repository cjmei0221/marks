package com.marks.smart.wx.api.mp.wxInteface.material.wxservice;

import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.AccessTokenUtil;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.WxHttpUtils;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.WxfwConfig;

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
