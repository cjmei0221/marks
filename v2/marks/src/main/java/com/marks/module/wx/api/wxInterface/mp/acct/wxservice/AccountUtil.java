package com.marks.module.wx.api.wxInterface.mp.acct.wxservice;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.wx.api.wxInterface.mp.base.utils.AccessTokenUtil;
import com.marks.module.wx.api.wxInterface.mp.base.utils.WxHttpUtils;
import com.marks.module.wx.api.wxInterface.mp.base.utils.WxfwConfig;

public class AccountUtil {
	private static Logger logger = Logger.getLogger(AccountUtil.class);
	private static AccountUtil util=null;
	private AccountUtil(){};
	
	public static AccountUtil getInstance(){
		if(util == null){
			util = new AccountUtil();
		}
		return util;
	}

	public JsonResult createQrcode(String accountid, int action_type, int expire_seconds, int scene_id) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json=new JSONObject();
		if(action_type==0){//临时二维码
			json.put("expire_seconds", expire_seconds);
			json.put("action_name", "QR_SCENE");
		}else{//永久二维码
			json.put("action_name", "QR_LIMIT_SCENE");
		}
		json.put("action_info", new JSONObject().put("scene", new JSONObject().put("scene_id", scene_id)));
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:"+access_token);
        String url =WxfwConfig.weixin_server_prefix+"/qrcode/create?access_token="+access_token;
        logger.info("url:"+url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                 jsonResult.setResult(jsonObj.get("ticket"));
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 createQrcode(accountid,action_type,expire_seconds, scene_id);
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
}
