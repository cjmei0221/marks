package com.marks.module.wxfwhao.common.wxservice;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.wxfwhao.common.utils.WxfwConfig;

public class GroupUtil {
	private static Logger logger = Logger.getLogger(GroupUtil.class);
	private static GroupUtil util=null;
	private GroupUtil(){};
	
	public static GroupUtil getInstance(){
		if(util == null){
			util = new GroupUtil();
		}
		return util;
	}

	public JsonResult toGroup(String accountid, String openid, String to_groupid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json=new JSONObject();
			json.put("openid", openid);
			json.put("to_groupid", to_groupid);
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:"+access_token);
        String url =WxfwConfig.weixin_server_prefix+"/groups/members/update?access_token="+access_token;
        logger.info("url:"+url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 toGroup(accountid,openid,to_groupid);
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
