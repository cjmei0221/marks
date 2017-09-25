package com.marks.module.wx.api.wxfwhao.common.wxservice;

import java.net.URLEncoder;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.wx.api.wxfwhao.common.entity.UserGet;
import com.marks.module.wx.api.wxfwhao.common.entity.WxUser;
import com.marks.module.wx.api.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wx.api.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.wx.api.wxfwhao.common.utils.WxfwConfig;
/**
 * 用户管理
 * @author cjmei
 *
 */
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

	public JsonResult getWXUserInfo(String accountid, String openid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:"+access_token);
        String url =WxfwConfig.weixin_server_prefix+"/user/info?access_token="+access_token+"&openid="+openid;
        logger.info("url:"+url);
		JsonResult returnJson = WxHttpUtils.doGet(accountid,url,null,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                 if(jsonObj.optInt("subscribe")==1){
                	 WxUser user=new WxUser();
         			user.setIssubscribe(jsonObj.optInt("subscribe"));
         			user.setOpenid(jsonObj.optString("openid"));
         			user.setNickname(URLEncoder.encode(jsonObj.optString("nickname"), "UTF-8"));
         			user.setSex(jsonObj.optInt("sex"));
         			user.setLanguage(jsonObj.optString("language"));
         			user.setCity(jsonObj.optString("city"));
         			user.setProvince(jsonObj.optString("province"));
         			user.setCountry(jsonObj.optString("country"));
         			user.setImageUrl(jsonObj.optString("headimgurl"));
         			user.setSubscribetime(new Timestamp(jsonObj.optLong("subscribe_time")*1000));
         			user.setGroupid(jsonObj.optInt("groupid"));
         			user.setRemark(jsonObj.optString("remark"));
         			user.setUnionid(jsonObj.optString("unionid"));
         			user.setTagid_list(jsonObj.getJSONArray("tagid_list").toString());
         			jsonResult.setResult(user);
         		}else{
         			jsonResult.setErrorCode("1001");
         			jsonResult.setErrorMsg("未关注");
         		}
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 getWXUserInfo(accountid, openid);
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

	public JsonResult getWXUserList(String accountid, String next_openid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:"+access_token);
        String url =WxfwConfig.weixin_server_prefix+"/user/get?access_token="+access_token+"&next_openid="+next_openid;
        logger.info("url:"+url);
		JsonResult returnJson = WxHttpUtils.doGet(accountid,url,null,null);
		 if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
            	UserGet userGet=new UserGet();
         		next_openid=jsonObj.optString("next_openid");
         		userGet.setNext_openid(next_openid);
         		jsonObj=jsonObj.optJSONObject("data");
         		if(jsonObj!=null){
         			JSONArray array=jsonObj.optJSONArray("openid");
         			for(int i=0;i<array.length();i++){
         				userGet.addOpenid(array.getString(i));
         			}
         		}
         		jsonResult.setResult(userGet);
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 getWXUserList(accountid, next_openid);
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
