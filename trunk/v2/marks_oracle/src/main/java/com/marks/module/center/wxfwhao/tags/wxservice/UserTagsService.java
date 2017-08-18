package com.marks.module.center.wxfwhao.tags.wxservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.center.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.center.wxfwhao.common.utils.WxfwConfig;
import com.marks.module.sys.system.core.helper.LoadDataHelper;

public class UserTagsService {
	private static Logger logger = Logger.getLogger(UserTagsService.class);
	private static UserTagsService util = null;

	private UserTagsService() {
	};

	public static UserTagsService getInstance() {
		if (util == null) {
			util = new UserTagsService();
		}
		return util;
	}

	/**
	 * 批量为用户打标签
	 * @param accountid
	 * @param tagid
	 * @param openidList
	 * @return
	 * @throws Exception
	 */
	public JsonResult batchtaggingForUser(String accountid, int tagid,List<String> openidList) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("openid_list",new JSONArray(openidList));
		json.put("tagid", tagid);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/members/batchtagging?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				batchtaggingForUser( accountid,  tagid, openidList) ;
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

	/**
	 * 批量为用户取消标签
	 * @param accountid
	 * @param tagid
	 * @param openidList
	 * @return
	 * @throws Exception
	 */
	public JsonResult batchuntaggingForUser(String accountid, int tagid,List<String> openidList) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("openid_list",new JSONArray(openidList));
		json.put("tagid", tagid);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/members/batchuntagging?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				batchuntaggingForUser( accountid,  tagid, openidList) ;
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

	/**
	 * 获取用户身上的标签列表
	 * @param accountid
	 * @param openid
	 * @return
	 * @throws Exception
	 */
	public JsonResult getidlistForUser(String accountid, String openid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		json.put("openid", openid);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/getidlist?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				JSONArray array=jsonObj.getJSONArray("tagid_list");
				List<Integer> list=null;
				if(array.length()>0){
					list=new ArrayList<Integer>();
					for(int i=0;i<array.length();i++){
						list.add(array.getInt(i));
					}
				}
				jsonResult.setResult(list);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getidlistForUser( accountid,  openid);
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
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:config/spring/applicationContext.xml");
		new LoadDataHelper().doJob();
		// System.out.println(AccessTokenUtil.getInstance().getAccessToken("jssdk_ctest"));
		List<String> openidList=new ArrayList<String>();
		openidList.add("oDkf1so5GFsBZW5SzzJpn3-nLSUY");
		UserTagsService.getInstance().batchtaggingForUser("jssdk_ctest", 101, openidList);

	}
}
