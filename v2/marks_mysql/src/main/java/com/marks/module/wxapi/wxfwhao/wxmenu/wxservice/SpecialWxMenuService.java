package com.marks.module.wxapi.wxfwhao.wxmenu.wxservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.inner.wx.wxmenu.dao.WxMenuDao;
import com.marks.module.quartz.data.job.LoadDataHelper;
import com.marks.module.sys.common.SpringContextHolder;
import com.marks.module.wxapi.wxfwhao.common.utils.AccessTokenUtil;
import com.marks.module.wxapi.wxfwhao.common.utils.WxHttpUtils;
import com.marks.module.wxapi.wxfwhao.common.utils.WxfwConfig;
import com.marks.module.wxapi.wxfwhao.wxmenu.pojo.SpecialCondition;
import com.marks.module.wxapi.wxfwhao.wxmenu.pojo.WxMenu;

/**
 * 个性化微信菜单接口
 * 
 * @author cjmei
 *
 */
public class SpecialWxMenuService {
	private static Logger logger = Logger.getLogger(SpecialWxMenuService.class);
	private static SpecialWxMenuService util = null;

	private SpecialWxMenuService() {
	};

	public static SpecialWxMenuService getInstance() {
		if (util == null) {
			util = new SpecialWxMenuService();
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
	public JsonResult createSpecialWxMenu(String accountid, SpecialCondition condition, List<WxMenu> menu_list)
			throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		JSONArray button_array = new JSONArray();
		for (WxMenu first_menu : menu_list) {
			JSONObject first_json = WxMenuUtil.getInstance().createWXMenuJson(first_menu);
			if (first_menu.getChildren().size() != 0) {// 只有一级菜单
				JSONArray array = new JSONArray();
				for (WxMenu second_menu : first_menu.getChildren()) {
					JSONObject second_json = WxMenuUtil.getInstance().createWXMenuJson(second_menu);
					array.put(second_json);
				}
				first_json.put("sub_button", array);
			}
			button_array.put(first_json);
		}
		json.put("button", button_array);
		json.put("matchrule", new JSONObject(condition));
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/menu/addconditional?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {
				jsonResult.setResult(jsonObj.optString("menuid"));
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {
				createSpecialWxMenu(accountid, condition, menu_list);
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
	 * 删除个性化菜单接口
	 * @param accountid
	 * @param menuid
	 * @return
	 * @throws Exception
	 */
	public JsonResult delSpecialWxMenu(String accountid, String menuid) throws Exception {
		JsonResult jsonResult = new JsonResult();
		JSONObject json = new JSONObject();
		
		json.put("menuid", menuid);
		
		String access_token = AccessTokenUtil.getInstance().getAccessToken(accountid);
		logger.info("access_token:" + access_token);
		// 请求url
		String url = WxfwConfig.weixin_server_prefix + "/menu/delconditional?access_token=" + access_token;
		logger.info("url:" + url);
		JsonResult returnJson = WxHttpUtils.doPostJson(accountid, url, json, null);
		if (returnJson.getSuccess() && returnJson.getResult() != null) {
			JSONObject jsonObj = new JSONObject(returnJson.getResult().toString());
			if (SysCode.SUCCESS.equals(returnJson.getErrorCode())) {//成功
				
			} else if (SysCode.C9980.equals(returnJson.getErrorCode())) {//access_token 过期，重新调用
				delSpecialWxMenu( accountid,  menuid);
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
		SpecialCondition condition = new SpecialCondition();
		condition.setTag_id("101");
		String accountid = "jssdk_ctest";
		WxMenuDao wxMenuDao = SpringContextHolder.getBean(WxMenuDao.class);
		List<WxMenu> menuList = wxMenuDao.getWxMenuListByAccountId(accountid);
		if (null != menuList && menuList.size() > 0) {
			List<WxMenu> mlist = new ArrayList<WxMenu>();
			// 一级菜单
			for (WxMenu wm : menuList) {
				if (wm.getParent_id().equals(accountid)) {
					mlist.add(wm);
				}
			}
			// 加载二级菜单
			for (WxMenu wmchild : mlist) {
				for (WxMenu wm : menuList) {
					if (wmchild.getId().equals(wm.getParent_id())) {
						wmchild.addChildren(wm);
					}
				}
				if (wmchild.getChildren().size() > 0) {
					wmchild.setType("click");
					// wmchild.setContent("");
				}
			}
			SpecialWxMenuService.getInstance().createSpecialWxMenu("jssdk_ctest", condition, mlist);
		}

	}
}
