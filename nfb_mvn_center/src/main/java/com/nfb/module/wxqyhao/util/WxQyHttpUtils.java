package com.nfb.module.wxqyhao.util;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.nfb.common.util.HttpUtils;
import com.nfb.common.util.JsonResult;
import com.nfb.common.util.SSLNetProvider;
import com.nfb.common.util.SysCode;

public class WxQyHttpUtils {
	private static Logger logger = Logger.getLogger(WxQyHttpUtils.class);
	/**
	 * doPostJson 使用SSLNetProvider访问腾讯，即使用HttpsURLConnectionOldImpl访问腾讯
	 * @param accountid
	 * @param url
	 * @param jsonparam
	 * @param header
	 * @return
	 * @throws Exception
	 */
	 public static JsonResult doPostJson2(String accountid,String url,JSONObject jsonparam,Map<String,String> header) throws Exception{
		 JsonResult jsonResult = new JsonResult();
		 SSLNetProvider provider=new SSLNetProvider();
         String result = provider.doPost(url,jsonparam.toString());
         JSONObject jsonObj = new JSONObject(result);
     	 jsonResult.setResult(jsonObj);
    	 if(result.indexOf("errcode") != -1 && !checkSuccess(jsonObj)){
    		 jsonResult.setSuccess(Boolean.FALSE);
             jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
             jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
             if(checkAccess_token(jsonObj)){
            	 QyAccessTokenUtil.getInstance().sendQyAccessTokenRequest(accountid);
            	 jsonResult.setErrorCode(SysCode.C9980);
            	 jsonResult.setErrorMsg("需要重复调用，原因access_token过期");
             }  
    	 } 
         logger.info(jsonResult.tolog());
		 return jsonResult;
	 }
	 
	 /**
		 * doPostJson 使用httpclient
		 * @param accountid
		 * @param url
		 * @param jsonparam
		 * @param header
		 * @return
		 * @throws Exception
		 */
		 public static JsonResult doPostJson(String accountid,String url,JSONObject jsonparam,Map<String,String> header) throws Exception{
			 JsonResult jsonResult = new JsonResult();
			
				JsonResult returnJson = HttpUtils.getInstance().doPostJson(url,jsonparam,header,"utf-8");
				logger.info("reponse code>>"+returnJson.getErrorCode());
				 if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
				     JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
				     	jsonResult.setResult(returnJson.getResult());
				    	 if(returnJson.getResult().toString().indexOf("errcode") != -1 && !checkSuccess(jsonObj)){
				    		 jsonResult.setSuccess(Boolean.FALSE);
					         jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
					         jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
					         if(checkAccess_token(jsonObj)){
					        	 QyAccessTokenUtil.getInstance().sendQyAccessTokenRequest(accountid);
					        	 jsonResult.setErrorCode(SysCode.C9980);
					        	 jsonResult.setErrorMsg("需要重复调用，原因access_token过期");
					         }
				    	 }
				    
				 } else {
				     jsonResult.setSuccess(Boolean.FALSE);
				     jsonResult.setErrorCode("9999");
				     jsonResult.setErrorMsg("return data null");
				 }
				 logger.info(jsonResult.tolog());
			return jsonResult;
		 }
	 
	 public static JsonResult doGet2(String accountid,String url,Map<String,String> params,Map<String,String> header) throws Exception {
		 JsonResult jsonResult = new JsonResult();
		 SSLNetProvider provider=new SSLNetProvider();
         String result = provider.doGet(url);
         JSONObject jsonObj = new JSONObject(result);
     	 jsonResult.setResult(jsonObj);
    	 if(result.indexOf("errcode") != -1 && !checkSuccess(jsonObj)){
    		 jsonResult.setSuccess(Boolean.FALSE);
             jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
             jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
             if(checkAccess_token(jsonObj)){
            	 QyAccessTokenUtil.getInstance().sendQyAccessTokenRequest(accountid);
            	 jsonResult.setErrorCode(SysCode.C9980);
            	 jsonResult.setErrorMsg("需要重复调用，原因access_token过期");
             }  
    	 } 
         logger.info(jsonResult.tolog());
		 return jsonResult;
	 }
	 
	 public static JsonResult doGet(String accountid,String url,Map<String,String> params,Map<String,String> header) throws Exception {
		 JsonResult jsonResult = new JsonResult();
		 JsonResult returnJson = HttpUtils.getInstance().doGet(url,params,header,"utf-8");
		 logger.info("reponse code>>"+returnJson.getErrorCode());
         if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             	jsonResult.setResult(jsonObj);
            	 if(returnJson.getResult().toString().indexOf("errcode") != -1 && !checkSuccess(jsonObj)){
            		 jsonResult.setSuccess(Boolean.FALSE);
                     jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
                     jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
                     if(checkAccess_token(jsonObj)){
                    	 QyAccessTokenUtil.getInstance().sendQyAccessTokenRequest(accountid);;
                    	 jsonResult.setErrorCode(SysCode.C9980);
                    	 jsonResult.setErrorMsg("需要重复调用，原因access_token过期");
                     } 
            	 }
         } else {
             jsonResult.setSuccess(Boolean.FALSE);
             jsonResult.setErrorCode("9999");
             jsonResult.setErrorMsg("return data null");
         }
         logger.info(jsonResult.tolog());
		 return jsonResult;
	 }
	 public static JsonResult doPost(String accountid,String url,Map<String,String> params,Map<String,String> header) throws Exception {
		 JsonResult jsonResult = new JsonResult();
		 JsonResult returnJson = HttpUtils.getInstance().doPost(url,params,header,"utf-8");
		 logger.info("reponse code>>"+returnJson.getErrorCode());
         if(returnJson != null && returnJson.getSuccess() && returnJson.getResult() != null){
             	 JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             	 jsonResult.setResult(jsonObj);
            	 if(returnJson.getResult().toString().indexOf("errcode") != -1 && !checkSuccess(jsonObj)){
            		 jsonResult.setSuccess(Boolean.FALSE);
                     jsonResult.setErrorCode(String.valueOf(jsonObj.get("errcode")));
                     jsonResult.setErrorMsg(String.valueOf(jsonObj.get("errmsg")));
                     if(checkAccess_token(jsonObj)){
                    	 QyAccessTokenUtil.getInstance().sendQyAccessTokenRequest(accountid);
                    	 jsonResult.setErrorCode(SysCode.C9980);
                    	 jsonResult.setErrorMsg("需要重复调用，原因access_token过期");
                     }  
            	 } 
           
         } else {
             jsonResult.setSuccess(Boolean.FALSE);
             jsonResult.setErrorCode("9999");
             jsonResult.setErrorMsg("return data null");
         }
         logger.info(jsonResult.tolog());
		 return jsonResult;
	 }
	 
	 //判断access_token是否超时
	  	private static boolean checkAccess_token(JSONObject json){
	  		int ret_code=json.optInt("errcode",-1);
	  		if(ret_code==42001||ret_code==40001)
	  			return true;
	  		return false;
	  	}
	  	public static boolean checkSuccess(JSONObject json){
			if(json.optInt("errcode", 0)==0)
				return true;
			return false;
		}
}
