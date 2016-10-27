package com.nfb.test;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nfb.module.wxfwhao.entity.UserGet;
import com.nfb.module.wxfwhao.entity.WxMenu;
import com.nfb.module.wxmodulemsg.entity.ModuleMsg;
import com.nfb.test.pojo.WxUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 调用微信接口服务工具类
 * 
 * @author lwgang
 * @createTime 2015-02-03
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WxFwUtil {
	private static String CHARSET = "UTF-8";
	private static String wx_host_url = "http://127.0.0.1:6080/";
	private static Logger logger = Logger.getLogger(WxFwUtil.class);
	private static WxFwUtil util = null;

	private WxFwUtil() {
	}

	public static WxFwUtil getInstance() {
		if (util == null) {
			util = new WxFwUtil();
		}
		return util;
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @param accountId
	 * @param openid
	 * @return
	 * @throws Exception
	 */
	public WxUser getUserInfo(String accountId, String openid) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("openid", openid);
		WxUser user = null;
		JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/getUserInfo.do", params, null,
				CHARSET);
		if (result.getSuccess()) {
			JSONObject userobj = JSONObject.fromObject(result.getResult());
			if (null != userobj) {
				user = new WxUser();
				user.setAccountid(accountId);
				user.setCity(userobj.getString("city"));
				user.setCountry(userobj.getString("country"));
				user.setGroupid(userobj.getInt("group_id"));
				user.setImageurl(userobj.getString("image_url"));
				user.setIssubscribe(userobj.getInt("is_subscribe"));
				user.setLanguage(userobj.getString("language"));
				String username = userobj.getString("nickname");
				try {
					username = URLDecoder.decode(username, "utf-8");
				} catch (Exception e) {
					username = user.getNickname();
				}
				user.setNickname(username);
				user.setOpenid(openid);
				user.setSex(userobj.getInt("sex"));
				user.setProvince(userobj.getString("province"));
				user.setSubscribetime(new Date(userobj.getLong("subscribe_time")));
				user.setRemark(userobj.getString("remark"));
				user.setUnionid(userobj.optString("unionid"));
				user.setTagid_list(userobj.getJSONArray("tagid_list").toString());
			}
		}
		return user;
	}

	/**
	 * 发送客服文本消息
	 * 
	 * @param accountId
	 * @param openid
	 * @param content
	 * @throws Exception
	 */
	public Result sendCustomTextMsg(String accountId, String openid, String content) throws Exception {
		Result result = new Result();
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("openid", openid);
		params.put("content", URLEncoder.encode(content, CHARSET));
		JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/sendCustomTextMsg.do", params, null,
				CHARSET);
		if (res.getSuccess()) {
			result.setCode(0);
		} else {
			result.setCode(Integer.parseInt(res.getErrorCode()));
			result.setMessage(res.getErrorMsg());
		}
		return result;
	}

	/**
	 * 创建二维码
	 * 
	 * @param accountId
	 * @param openid
	 * @param content
	 * @throws Exception
	 */
	public String createQrcode(String accountId, int action_type, int expire_seconds, int scene_id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("action_type", action_type + "");
		params.put("expire_seconds", expire_seconds + "");
		params.put("scene_id", scene_id + "");
		JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/createQrcode.do", params, null,
				CHARSET);
		if (result.getSuccess()) {
			return result.getResult().toString();
		}
		return null;
	}

	/**
	 * 获取粉丝列表
	 * 
	 * @param accountId
	 * @param openid
	 * @param content
	 * @throws Exception
	 */
	public UserGet getWXUserOpenId(String accountid, String next_openid) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountid);
		params.put("next_openid", next_openid);
		JsonResult result = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/getWXUserOpenId.do", params, null,
				CHARSET);
		if (result.getSuccess()) {
			JSONObject userobj = JSONObject.fromObject(result.getResult());
			UserGet ug = new UserGet();
			ug.setNext_openid(userobj.getString("next_openid"));
			JSONArray arrobj = JSONArray.fromObject(userobj.get("openid_list"));
			List<String> openid_list = new ArrayList<String>();
			if (null != arrobj && arrobj.size() > 0) {
				for (Object openid : arrobj) {
					openid_list.add(String.valueOf(openid));
				}
			}
			ug.setOpenid_list(openid_list);
			return ug;
		}
		return null;
	}

	/**
	 * 发送客服文本消息
	 * 
	 * @param accountId
	 * @param openid
	 * @param content
	 * @throws Exception
	 */
	public Result createWXMenu(String accountid, List<WxMenu> menu_list) throws Exception {
		Result result = new Result();
		result.setCode(-1);
		if (null != menu_list && menu_list.size() > 0) {
			for (WxMenu wm : menu_list) {
				wm.setName(URLEncoder.encode(wm.getName(), CHARSET));
				if (null != wm.getContent() && !"".equals(wm.getContent())) {
					wm.setContent(URLEncoder.encode(wm.getContent(), CHARSET));
				}
				if (wm.getSub_button().size() > 0) {
					for (WxMenu sub : wm.getSub_button()) {
						sub.setName(URLEncoder.encode(sub.getName(), CHARSET));
						if (null != sub.getContent() && !"".equals(sub.getContent())) {
							sub.setContent(URLEncoder.encode(sub.getContent(), CHARSET));
						}
					}
				}
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("accountid", accountid);
			params.put("menu_list", JSONArray.fromObject(menu_list).toString());
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/createWXMenu.do", params, null,
					CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 模板推送
	 * 
	 * @param msg
	 */
	public Result pushMessage(ModuleMsg msg) {
		Result result = new Result();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("accountid", msg.getAccountid());
			params.put("toUser", msg.getTouser());
			params.put("templateCode", msg.getTemplate_id());
			if (null != msg.getUrl() && msg.getUrl().length() > 5) {
				params.put("toUrl", URLEncoder.encode(msg.getUrl(), CHARSET));
			} else {
				params.put("toUrl", "");
			}
			params.put("data", URLEncoder.encode(msg.getData(), CHARSET));
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/receive/sendTemplateMsg.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		} catch (Exception e) {
			logger.info("pushMessage>>pushMessage>>", e);
			result.setCode(4000);
			result.setMessage("系统错误");
		}
		return result;
	}

	/**
	 * 模板推送,直接发送
	 * 
	 * @param msg
	 */
	public Result pushTemplateMsg(String accountid, String toUser, String templateid, String toUrl, String data) {
		Result result = new Result();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("accountid", accountid);
			params.put("toUser", toUser);
			params.put("templateCode", templateid);
			if (null != toUrl && toUrl.length() > 5) {
				params.put("toUrl", URLEncoder.encode(toUrl, CHARSET));
			} else {
				params.put("toUrl", "");
			}
			params.put("data", URLEncoder.encode(data, CHARSET));
			logger.info("pushMessage>>url>>" + wx_host_url + "/wechat/receive/sendTemplateMsg.do");
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/wechat/receive/sendTemplateMsg.do", params,
					null, CHARSET);
			if (res.getSuccess()) {
				result.setCode(0);
			} else {
				result.setCode(Integer.parseInt(res.getErrorCode()));
				result.setMessage(res.getErrorMsg());
			}
		} catch (Exception e) {
			logger.info("pushMessage>>", e);
			result.setCode(4000);
			result.setMessage("系统错误");
		}
		return result;
	}

	/**
	 * 移动分组 moveOpenidtoGroup:描述 <br/>
	 *
	 * @param accountid
	 * @param openid
	 * @param to_groupid
	 * @return
	 * @throws Exception
	 * @author cjmei
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public Result moveOpenidtoGroup(String accountid, String openid, String to_groupid) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Result result = new Result();
		params.put("accountid", accountid);
		params.put("openid", openid);
		params.put("to_groupid", to_groupid);
		JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/groups/members/update.do", params, null,
				CHARSET);
		if (res.getSuccess()) {
			result.setCode(0);
		} else {
			result.setCode(Integer.parseInt(res.getErrorCode()));
			result.setMessage(res.getErrorMsg());
		}
		return result;
	}

	/**
	 * 获取js_sdk 的jsapi_ticket
	 * 
	 * @param accountId
	 *            服务号ID
	 * @return Result 返回内容 jsapi_ticket
	 */
	public String getJsSDKTicket(String accountId) {
		String str = null;
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("accountid", accountId);
			JsonResult res = HttpUtils.getInstance().doPost(wx_host_url + "/jssdk/getJssdkTicket.do", params, null, CHARSET);
			if (res.getSuccess()) {
				str = res.getResult().toString();
			}
		} catch (IOException e) {
			logger.info("IOException error");
		}

		return str;
	}
}