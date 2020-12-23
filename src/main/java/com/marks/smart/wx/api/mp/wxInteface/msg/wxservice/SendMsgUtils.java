/**
 * 文件名：GoodInfo.java
 * 创建日期： 2015-02-10
 * Copyright (c) 2015 运通信息
 * All rights reserved.
 * 修改记录：
 * 
 */
package com.marks.smart.wx.api.mp.wxInteface.msg.wxservice;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.AccessTokenUtil;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.WxHttpUtils;
import com.marks.smart.wx.api.mp.wxInteface.base.utils.WxfwConfig;


/**
 *  处理服务号发送消息接口
 * @author cjmei
 * 
 */
public class SendMsgUtils implements Serializable{

	private static Logger logger = Logger.getLogger(SendMsgUtils.class);
	private static SendMsgUtils util=null;
	private SendMsgUtils(){};
	
	public static SendMsgUtils getInstance(){
		if(util == null){
			util = new SendMsgUtils();
		}
		return util;
	}
    /***
     * 发送微信模板消息
     * @param accessToken 公众号Token
     * @param openId  微信用户id
     * @param templateId  模板id
     * @param applyUrl  点击消息跳转链接
     * @param templateData  模板消息内容
     * @return jsonResult 返回结果
     */
    public JsonResult sendTemplateMsg(String accountid,String openId,String templateId,String applyUrl,String templateData){
    	JsonResult jsonResult = new JsonResult();
    	try{
    		String access_token=AccessTokenUtil.getInstance().getAccessToken(accountid);
	        String url =WxfwConfig.weixin_server_prefix+"/message/template/send?access_token="+access_token;
    	
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("touser",openId);
            jsonParam.put("template_id",templateId);
            jsonParam.put("url",applyUrl);
            jsonParam.put("data",new JSONObject(templateData));
            logger.info("params>>"+jsonParam.toString());
            JsonResult returnJson = WxHttpUtils.doPostJson(accountid,url,jsonParam,null);

            if(returnJson.getSuccess() && returnJson.getResult() != null){
                JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
                if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                    jsonResult.setResult(jsonObj.get("msgid"));
                }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
                	sendTemplateMsg(accountid,openId,templateId, applyUrl,templateData);
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

        }catch (Exception ex){
        	logger.error("exception",ex);
            jsonResult.setSuccess(Boolean.FALSE);
            jsonResult.setErrorCode("9999");
            jsonResult.setErrorMsg(ex.getMessage());
        }

        return jsonResult;
    }

    /**
     * 发送客服文本消息
     * @param accountid
     * @param openid
     * @param content
     * @throws WxException 
     * @throws JSONException 
     */
	public JsonResult sendCustomTextMsg(String accountid, String openid, String content) throws Exception {
		JsonResult jsonResult = new JsonResult();	
			JSONObject json=new JSONObject();
			json.put("touser", openid);
			json.put("msgtype", "text");
			content=content.replaceAll("&amp;", "&");
			json.put("text",new JSONObject().put("content", content));
			String url=WxfwConfig.weixin_server_prefix+"/message/custom/send?access_token="+AccessTokenUtil.getInstance().getAccessToken(accountid);
			JsonResult returnJson = WxHttpUtils.doPostJson(accountid,url,json,null);
            if(returnJson.getSuccess() && returnJson.getResult() != null){
                JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
                if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                	jsonResult.setSuccess(Boolean.TRUE);
                	jsonResult.setErrorCode(SysCode.SUCCESS);
                }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
                	sendCustomTextMsg(accountid,openid,content);
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
