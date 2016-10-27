package com.nfb.module.wxfwhao.wxservice;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nfb.common.util.JsonResult;
import com.nfb.common.util.SysCode;
import com.nfb.module.wxfwhao.entity.WxMenu;
import com.nfb.module.wxfwhao.utils.AccessTokenUtil;
import com.nfb.module.wxfwhao.utils.WxHttpUtils;
import com.nfb.module.wxfwhao.utils.WxfwConfig;

public class WxMenuUtil {
	private static Logger logger = Logger.getLogger(WxMenuUtil.class);
	private static WxMenuUtil util=null;
	private WxMenuUtil(){};
	
	public static WxMenuUtil getInstance(){
		if(util == null){
			util = new WxMenuUtil();
		}
		return util;
	}

	public JsonResult createWXMenu(String accountid,List<WxMenu> menu_list) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json=new JSONObject();
		JSONArray button_array=new JSONArray();
		for(WxMenu first_menu:menu_list){ 
			JSONObject first_json=createWXMenuJson(first_menu);
			if(first_menu.getSub_button().size()!=0){//只有一级菜单
				JSONArray array=new JSONArray();
				for(WxMenu second_menu:first_menu.getSub_button()){
					JSONObject second_json=createWXMenuJson(second_menu);
					array.put(second_json);
				}
				first_json.put("sub_button", array);
			}
			button_array.put(first_json);
		}
		json.put("button", button_array);
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:"+access_token);
        String url =WxfwConfig.weixin_server_prefix+"/menu/create?access_token="+access_token;
        logger.info("url:"+url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                 
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 createWXMenu(accountid,menu_list);
             }else {
                 jsonResult.setSuccess(Boolean.FALSE);
                 jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
                 jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
             }
         } else {
             jsonResult.setSuccess(Boolean.FALSE);
             jsonResult.setErrorCode(returnJson.getErrorCode());
             jsonResult.setErrorMsg(returnJson.getErrorMsg());
         }
		return jsonResult;
	}
	private JSONObject createWXMenuJson(WxMenu menu) throws JSONException{
		JSONObject json=new JSONObject();
		json.put("name", menu.getName());
		json.put("type", menu.getType());
		json.put("url", menu.getContent());
		json.put("key", menu.getId());
		return json;
	}
}
