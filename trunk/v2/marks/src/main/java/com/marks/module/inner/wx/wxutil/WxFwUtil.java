package com.marks.module.inner.wx.wxutil;

import java.net.URLDecoder;
import java.util.List;

import org.apache.log4j.Logger;

import com.marks.common.domain.JsonResult;
import com.marks.common.domain.Result;
import com.marks.common.util.Code;
import com.marks.module.center.wxfwhao.common.entity.UserGet;
import com.marks.module.center.wxfwhao.common.entity.WxMenu;
import com.marks.module.center.wxfwhao.common.entity.WxUser;
import com.marks.module.center.wxfwhao.common.wxservice.AccountUtil;
import com.marks.module.center.wxfwhao.common.wxservice.GroupUtil;
import com.marks.module.center.wxfwhao.common.wxservice.JssdkUtil;
import com.marks.module.center.wxfwhao.common.wxservice.SendMsgUtils;
import com.marks.module.center.wxfwhao.common.wxservice.UserUtil;
import com.marks.module.center.wxfwhao.common.wxservice.WxMenuUtil;
import com.marks.module.sys.system.core.data.StaticData;

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
	// private static String wx_host_url = "http://127.0.0.1:6080";
	private static String wx_host_url = StaticData.getSysConf("wx_host_url");
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
	 * 发送客服文本消息
	 * 
	 * @param accountId
	 * @param openid
	 * @param content
	 * @throws Exception
	 */
	public Result sendCustomTextMsg(String accountId, String openid, String content) throws Exception {
		Result result = new Result();
		JsonResult res = SendMsgUtils.getInstance().sendCustomTextMsg(accountId, openid, content);
		if (res.getSuccess()) {
			result.setCode(Code.CODE_SUCCESS);
		} else {
			result.setCode(res.getErrorCode());
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
		JsonResult result = AccountUtil.getInstance().createQrcode(accountId, action_type, expire_seconds, scene_id);
		if (result.getSuccess()) {
			return result.getResult().toString();
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
		result.setCode(Code.CODE_FAIL);
		if (null != menu_list && menu_list.size() > 0) {
			JsonResult res = WxMenuUtil.getInstance().createWXMenu(accountid, menu_list);
			if (res.getSuccess()) {
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setCode(res.getErrorCode());
				result.setMessage(res.getErrorMsg());
			}
		}
		return result;
	}

	/**
	 * 模板推送,直接发送
	 * 
	 * @param msg
	 */
	public Result pushTemplateMsg(String accountid, String toUser, String templateid, String toUrl, String data,
			String note) {
		Result result = new Result();
		try {
			JsonResult res = SendMsgUtils.getInstance().sendTemplateMsg(accountid, toUser, templateid, toUrl, data);
			if (res.getSuccess()) {
				result.setCode(Code.CODE_SUCCESS);
			} else {
				result.setCode(res.getErrorCode());
				result.setMessage(res.getErrorMsg());
			}
		} catch (Exception e) {
			logger.info("pushMessage>>", e);
			result.setCode("4000");
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
	 * @author marks
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	public Result moveOpenidtoGroup(String accountid, String openid, String to_groupid) throws Exception {
		Result result = new Result();
		JsonResult res = GroupUtil.getInstance().toGroup(accountid, openid, to_groupid);
		if (res.getSuccess()) {
			result.setCode(Code.CODE_SUCCESS);
		} else {
			result.setCode(res.getErrorCode());
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
		String str = JssdkUtil.getInstance().getJsapi_ticket(accountId);
		return str;
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
		JsonResult result = UserUtil.getInstance().getWXUserList(accountid, next_openid);
		if (result.getSuccess()) {
			
			UserGet ug = (UserGet) result.getResult();
			
			return ug;
		}
		return null;
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
		WxUser user = null;
		JsonResult result = UserUtil.getInstance().getWXUserInfo(accountId, openid);
		if (result.getSuccess()) {
			user= (WxUser) result.getResult();
			if (null != user) {
				user.setAccountid(accountId);
				String username = user.getNickname();
				try {
					username = URLDecoder.decode(username, "utf-8");
				} catch (Exception e) {
					username = user.getNickname();
				}
				user.setNickname(username);
			}
		}
		return user;
	}
}