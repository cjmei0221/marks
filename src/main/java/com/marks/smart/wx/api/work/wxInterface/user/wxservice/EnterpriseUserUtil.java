package com.marks.smart.wx.api.work.wxInterface.user.wxservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.smart.wx.api.work.wxInterface.base.QyAccessTokenUtil;
import com.marks.smart.wx.api.work.wxInterface.base.utils.QyGetUrlUtils;
import com.marks.smart.wx.api.work.wxInterface.base.utils.WxQyHttpUtils;
import com.marks.smart.wx.api.work.wxInterface.base.utils.WxqyConfig;
import com.marks.smart.wx.api.work.wxInterface.user.entity.EnterpriseUser;



public class EnterpriseUserUtil {
	private static Logger logger = Logger.getLogger(EnterpriseUserUtil.class);
	private static EnterpriseUserUtil util=null;
	private EnterpriseUserUtil(){};
	
	public static EnterpriseUserUtil getInstance(){
		if(util == null){
			util = new EnterpriseUserUtil();
		}
		return util;
	}
	
	
	//邀请成员关注
	@SuppressWarnings("unchecked")
	public JsonResult sendInvite(String accountid,String userid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		@SuppressWarnings("rawtypes")
		Map mp = new HashMap<String, String>();
		json.put("userid", userid);
		String access_token = QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:" + access_token);
		String suffix = WxqyConfig.WEIXIN_SEND_INVITE;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url = String.format(url, access_token, json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid, url, json,
				null);
		if (returnJson.getSuccess()
				&& returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult()
					.toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				mp.put("errcode", jsonObj.optString("errcode"));
				mp.put("errmsg", jsonObj.optString("errmsg"));
				mp.put("type", jsonObj.optString("type"));
				jsonResult.setResult(mp);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				sendInvite(accountid, userid);
			} else {
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
	//获取部门成员详情
	public JsonResult getDepartmentMemberDetail(String accountid,
			String department_id, String fetch_child, String status)
			throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		List<EnterpriseUser> list = new ArrayList<EnterpriseUser>();
		json.put("department_id", department_id);
		json.put("fetch_child", fetch_child);
		json.put("status", status);
		String access_token = QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:" + access_token);
		String suffix = WxqyConfig.WEIXIN_GETDEPARTMENT_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url = String.format(url, access_token, json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid, url, json,
				null);
		if (returnJson.getSuccess()
				&& returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult()
					.toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				JSONArray array = jsonObj.optJSONArray("userlist");
				for (int i = 0; i < array.length(); i++) {
					JSONObject object = array.optJSONObject(i);
					EnterpriseUser po = new EnterpriseUser();
					po.setUserid(object.optString("userid"));
					po.setName(object.optString("name"));
					po.setDepartment(object.optString("department"));
					po.setPosition(object.optString("position"));
					po.setMobile(object.optString("mobile"));
					po.setGender(object.optString("gender"));
					po.setEmail(object.optString("email"));
					po.setWeixinid(object.optString("weixinid"));
					po.setAvatar(object.optString("avatar"));
					po.setStatus(object.optString("status"));
					po.setExtattr(object.optString("extattr"));
					list.add(po);
				}
				jsonResult.setResult(list);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getDepartmentMember(accountid, department_id, fetch_child,
						status);
			} else {
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
	//获取部门成员
	public JsonResult getDepartmentMember(String accountid,String department_id,
			String fetch_child, String status) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		List<EnterpriseUser> list = new ArrayList<EnterpriseUser>();
		json.put("department_id", department_id);
		json.put("fetch_child", fetch_child);
		json.put("status", status);
		String access_token = QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:" + access_token);
		String suffix = WxqyConfig.WEIXIN_GETDEPARTMENT_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		if(!url.contains("&department_id=%s&fetch_child=%s&status=%s")){
			url=String.format(url,access_token,json.optString("id"));
		}else{
			url = String.format(url, access_token,json.optString("department_id"),json.optString("fetch_child"),json.optString("status"));
		}
//		url = String.format(url, access_token, json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid, url, json,
				null);
		if (returnJson.getSuccess()
				&& returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult()
					.toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				JSONArray array = jsonObj.optJSONArray("userlist");
				for (int i = 0; i < array.length(); i++) {
					JSONObject object = array.optJSONObject(i);
					EnterpriseUser po = new EnterpriseUser();
					po.setUserid(object.optString("userid"));
					po.setName(object.optString("name"));
					po.setDepartment(object.optString("department"));
					list.add(po);
				}
				jsonResult.setResult(list);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getDepartmentMember(accountid, department_id, fetch_child, status);
			} else {
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
	//获取成员
	public JsonResult getEnterpriseUser(String accountid, String userid)
			throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("id", userid);
		String access_token = QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:" + access_token);
		String suffix = WxqyConfig.WEIXIN_GET_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url = String.format(url, access_token, json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid, url, json,
				null);
		if (returnJson.getSuccess()
				&& returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult()
					.toString());
			EnterpriseUser po = new EnterpriseUser();
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				po.setUserid(jsonObj.optString("userid"));
				po.setName(jsonObj.optString("name"));
				po.setDepartment(jsonObj.optString("department"));
				po.setPosition(jsonObj.optString("position"));
				po.setMobile(jsonObj.optString("mobile"));
				po.setGender(jsonObj.optString("gender"));
				po.setEmail(jsonObj.optString("email"));
				po.setWeixinid(jsonObj.optString("weixinid"));
				po.setAvatar(jsonObj.optString("avatar"));
				po.setStatus(jsonObj.optString("status"));
				po.setExtattr(jsonObj.optString("extattr"));
				jsonResult.setResult(po);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getEnterpriseUser(accountid, userid);
			} else {
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
	//批量删除企业成员
	public JsonResult deleteEnterpriseUserList(String accountid,List<String> userid)
			throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("useridlist", net.sf.json.JSONArray.fromObject(userid).toString());
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_DELETE_ENTERPRISEUSER_LIST;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
           JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
           if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
               jsonResult.setResult("delete many success");
           }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
        	   deleteEnterpriseUserList(accountid, userid);
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
	//删除企业成员
	public JsonResult deleteEnterpriseUser(String accountid,String userid) throws Exception{
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("id",userid);
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_DELETE_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
            JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
            if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                jsonResult.setResult("delete success");
            }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	deleteEnterpriseUser(accountid, userid);
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
	//修改企业成员
	public JsonResult updateEnterpriseUser(String accountid,EnterpriseUser po) throws Exception{
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("userid",po.getUserid());
		json.put("name",po.getName());
		json.put("department",po.getDepartment());
		json.put("position",po.getPosition());
		json.put("mobile",po.getMobile());
		json.put("gender",po.getGender());
		json.put("email",po.getEmail());
		json.put("weixinid",po.getWeixinid());
		json.put("avatar_mediaid",po.getAvatar_mediaid());
		json.put("extattr",po.getExtattr());
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_UPDATE_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
            JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
            if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                jsonResult.setResult("update success");
            }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	updateEnterpriseUser(accountid, po);
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
	//创建企业成员
	public JsonResult createEnterpriseUser(String accountid,EnterpriseUser po) throws Exception{
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("userid",po.getUserid());
		json.put("name",po.getName());
		json.put("department",po.getDepartment());
		json.put("position",po.getPosition());
		json.put("mobile",po.getMobile());
		json.put("gender",po.getGender());
		json.put("email",po.getEmail());
		json.put("weixinid",po.getWeixinid());
		json.put("avatar_mediaid",po.getAvatar_mediaid());
		json.put("extattr",po.getExtattr());
		String access_token=QyAccessTokenUtil.getInstance().getQyAccessToken(accountid);
		logger.info("access_token:"+access_token);
		String suffix = WxqyConfig.WEIXIN_CREATE_ENTERPRISEUSER;
		QyGetUrlUtils qu = new QyGetUrlUtils();
		String url = qu.type2uriCorper(suffix);
		url=String.format(url,access_token,json.optString("id"));
		JsonResult returnJson = WxQyHttpUtils.doPostJson(accountid,url,json,null);
		 if(returnJson.getSuccess() && returnJson.getResult() != null){
            JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
            if(SysCode.SUCCESS.equals(returnJson.getErrorCode())){
                jsonResult.setResult("create success");
            }else if(SysCode.C9980.equals(returnJson.getErrorCode())){
            	createEnterpriseUser(accountid, po);
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
