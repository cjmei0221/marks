package com.marks.module.center.wxqyhao.common.wxservice;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxqyhao.common.entity.QyUser;
import com.marks.module.center.wxqyhao.common.entity.UidToOpenid;
import com.marks.module.center.wxqyhao.common.utils.QyAccessTokenUtil;
import com.marks.module.center.wxqyhao.common.utils.QyGetUrlUtils;
import com.marks.module.center.wxqyhao.common.utils.WxQyHttpUtils;
import com.marks.module.center.wxqyhao.common.utils.WxqyConfig;

public class UserUtil {

	private static Logger logger = Logger.getLogger(UserUtil.class);
	private static UserUtil util=null;
	private UserUtil(){};
	
	public static UserUtil getInstance(){
		if(util == null){
			util = new UserUtil();
		}
		return util;
	}
	//创建部门
	public JsonResult getUserid(String accountid,String code) throws Exception {
		JsonResult jsonResult = new JsonResult();	
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		String url=WxqyConfig.weixin_qy_server_prefix+"/user/getuserinfo?access_token="+access_token+"&code="+code;
		logger.info("access_token:"+access_token);
		logger.info("url:"+url);
		JsonResult returnJson = WxQyHttpUtils.doGet(accountid, url, null, null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
            	 QyUser u=new QyUser();
            	 u.setUserid(jsonObj.getString("UserId"));
            	 u.setDeviceid(jsonObj.getString("DeviceId"));
                 jsonResult.setResult(u);
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 getUserid(accountid,code);
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
	//userid转换成openid
		public JsonResult change(String accountid, String userId,String agentid) throws Exception {
			JsonResult jsonResult = new JsonResult();
			JSONObject json = new JSONObject();
			json.put("userid",userId);
			if(null !=agentid && !"".equals(agentid)){
				json.put("agentid", agentid);
			}
			String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
			logger.info("access_token:"+access_token);
			String suffix = WxqyConfig.WEIXIN_CONVERT_TO_OPENID;
			QyGetUrlUtils qu = new QyGetUrlUtils();
			String url = qu.type2uriCorper(suffix);
	        logger.info("url:"+url);
	        url=String.format(url,access_token);
	        JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
			 if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
	             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
	             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
	            	 UidToOpenid ut=new UidToOpenid();
	            	 ut.setOpenid(jsonObj.getString("openid"));
	            	 ut.setAppid(jsonObj.getString("appid"));
	            	 jsonResult.setResult(ut);
	             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
	            	 change(accountid,userId,agentid);
	             }else {
	                 jsonResult.setSuccess(Boolean.FALSE);
	                 jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
	                 jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
	             }
	         } else {
	             jsonResult.setSuccess(Boolean.FALSE);
	             jsonResult.setErrorCode("9999");
	             jsonResult.setErrorMsg("return data null");
	         }
			return jsonResult;
		}
}
