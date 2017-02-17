package com.marks.module.wxqyhao.common.wxservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.wxqyhao.common.entity.Department;
import com.marks.module.wxqyhao.common.utils.QyAccessTokenUtil;
import com.marks.module.wxqyhao.common.utils.QyGetUrlUtils;
import com.marks.module.wxqyhao.common.utils.WxQyHttpUtils;
import com.marks.module.wxqyhao.common.utils.WxqyConfig;

public class DepartmentUtil {
	private static Logger logger = Logger.getLogger(DepartmentUtil.class);
	private static DepartmentUtil util=null;
	private DepartmentUtil(){};
	
	public static DepartmentUtil getInstance(){
		if(util == null){
			util = new DepartmentUtil();
		}
		return util;
	}
	//创建部门
	public JsonResult createDepartment(String accountid, Department po) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("name",po.getName());
		json.put("parentid",po.getParentid());
		json.put("order",po.getOrder());
		json.put("id",po.getId());
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_CREATE_DEPARTMENT;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		logger.info("url:"+url);
		url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                 jsonResult.setResult(jsonObj.get("id"));
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 createDepartment(accountid, po);
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
	
	//更新部门
	public JsonResult updateDepartment(String accountid, Department po) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("name",po.getName());
		json.put("parentid",po.getParentid());
		json.put("order",po.getOrder());
		json.put("id",po.getId());
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_UPDATE_DEPARTMENT;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
        logger.info("url:"+url);
        url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
  
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 updateDepartment(accountid,po);
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
	
	//删除部门
	public JsonResult deleteDepartment(String accountid, String id) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_DELETE_DEPARTMENT;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
        logger.info("url:"+url);
        url=String.format(url,access_token,id);
		JsonResult returnJson = WxQyHttpUtils.doGet(accountid,url,null,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
  
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 deleteDepartment(accountid,id);
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

	//获取部门列表
	public JsonResult listDepartment(String accountid, String id) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_LIST_DEPARTMENT;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url=String.format(url,access_token,id);
        logger.info("url:"+url);
		JsonResult returnJson = WxQyHttpUtils.doGet(accountid,url,null,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
             JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
             if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
            	 List<Department>  list = new ArrayList<Department>();
         		JSONArray array=jsonObj.optJSONArray("department");
         		for(int i=0;i<array.length();i++){
         			JSONObject object=array.optJSONObject(i);
         			Department group=new Department(object.optString("name"),object.optString("parentid"),object.optString("order"),object.optString("id"));
         			list.add(group);
         		}
         		jsonResult.setResult(list);
             }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	 listDepartment( accountid, id);
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
