package com.marks.module.wxapi.wxfwhao.tags.wxservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.quartz.data.job.LoadDataHelper;
import com.marks.module.wxapi.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wxapi.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.wxapi.wxfwhao.common.utils.WxfwConfig;
import com.marks.module.wxapi.wxfwhao.tags.pojo.Tag;

public class TagsService {
	private static Logger logger = Logger.getLogger(TagsService.class);
	private static TagsService util = null;

	private TagsService() {
	};

	public static TagsService getInstance() {
		if (util == null) {
			util = new TagsService();
		}
		return util;
	}

	/**
	 * 创建用户标签
	 * 
	 * @param accountid
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public JsonResult createTag(String accountid, String name) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		JSONObject subjson = new JSONObject();
		subjson.put("name", name);
		json.put("tag", subjson);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/create?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				JSONObject jo=jsonObj.optJSONObject("tag");
				Tag info = new Tag();
				info.setId(jo.optInt("id") );
				info.setName(jo.optString("name"));
				jsonResult.setResult(info);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				createTag(accountid, name);
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
	 * 获取标签列表
	 * 
	 * @param accountid
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public JsonResult getTags(String accountid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/get?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doGet(accountid, url, null, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				List<Tag> list = new ArrayList<Tag>();
				if (jsonObj != null) {
					Tag info = null;
					JSONArray array = jsonObj.optJSONArray("tags");
					if (array.length() > 0) {
						for (int i = 0; i < array.length(); i++) {
							info = new Tag();
							info.setId(array.getJSONObject(i).optInt("id"));
							info.setCount(array.getJSONObject(i).optInt("count"));
							info.setName(array.getJSONObject(i).optString("name"));
							list.add(info);
						}
					}
				}
				jsonResult.setResult(list);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getTags(accountid);
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
	 * 编辑用户标签
	 * 
	 * @param accountid
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public JsonResult editTag(String accountid, int id, String name) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		JSONObject subjson = new JSONObject();
		subjson.put("id", id);
		subjson.put("name", name);
		json.put("tag", subjson);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/update?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {

			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				editTag(accountid, id, name);
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
	 * 删除用户标签
	 * 
	 * @param accountid
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public JsonResult delTag(String accountid, int id) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		JSONObject subjson = new JSONObject();
		subjson.put("id", id);
		json.put("tag", subjson);
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/tags/delete?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {

			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				delTag(accountid, id);
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
	 * 获取标签下粉丝列表
	 * 
	 * @param accountid
	 * @param tagid
	 * @param next_openid
	 *            第一个拉取的OPENID，不填默认从头开始拉取
	 * @return
	 * @throws Exception
	 */
	public JsonResult getOpenidListByTag(String accountid, int tagid, String next_openid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		JSONObject json = new JSONObject();
		json.put("tagid", tagid);
		json.put("next_openid", next_openid);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/user/tag/get?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				Tag info = new Tag();
				info.setCount(jsonObj.optInt("count"));
				info.setNext_openid(jsonObj.optString("next_openid"));
				JSONObject data=jsonObj.optJSONObject("data");
				JSONArray array = data.optJSONArray("openid");
				if (array.length() > 0) {
					for (int i = 0; i < array.length(); i++) {
						info.addOpenid(array.getString(i));
					}
				}
				jsonResult.setResult(info);
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				getTags(accountid);
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
		String accountid="jssdk_ctest";
		// System.out.println(AccessTokenUtil.getInstance().getAccessToken("jssdk_ctest"));
		//TagsService.getInstance().getTags("jssdk_ctest");
		TagsService.getInstance().getOpenidListByTag(accountid, 101, "");

	}
}
