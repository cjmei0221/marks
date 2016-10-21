package com.grgbanking.module.wxfwhao.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grgbanking.common.util.JsonResult;
import com.grgbanking.common.util.SysCode;
import com.grgbanking.module.wxfwhao.entity.WeixinMenu;
import com.grgbanking.module.wxfwhao.wxservice.WxMenuUtil;

@Controller
public class WxMenuController {

	private static Logger logger = Logger.getLogger(WxMenuController.class);
	
	@RequestMapping(value = "/wechat/createWXMenu")
	public void createWXMenu(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		result.setErrorCode(SysCode.ERROR);
		try {
			String accountid = request.getParameter("accountid");
			String list = request.getParameter("menu_list");
			JSONArray arr = JSONArray.fromObject(list);
			if (arr != null && arr.size() > 0) {
				List<WeixinMenu> menu_list = new ArrayList<WeixinMenu>();
				WeixinMenu first = null;
				for (Object obj : arr) {
					first = new WeixinMenu();
					JSONObject json = JSONObject.fromObject(obj);
					String content = json.getString("content");
					if (null != content && !"".equals(content)) {
						content = URLDecoder.decode(content, "utf-8");
					}
					first.setContent(content);
					first.setName(URLDecoder.decode(json.getString("name"),
							"utf-8"));
					first.setId(json.getString("id"));
					first.setType(json.getString("type"));
					JSONArray subarr = JSONArray.fromObject(json
							.get("sub_button"));
					if (null != subarr && subarr.size() > 0) {
						for (Object second : subarr) {
							JSONObject secondjson = JSONObject
									.fromObject(second);
							WeixinMenu sec = new WeixinMenu();
							String contents = secondjson.getString("content");
							if (null != contents && !"".equals(contents)) {
								contents = URLDecoder.decode(contents, "utf-8");
							}
							sec.setContent(contents);
							sec.setName(URLDecoder.decode(
									secondjson.getString("name"), "utf-8"));
							sec.setId(secondjson.getString("id"));
							sec.setType(secondjson.getString("type"));
							first.addSub_button(sec);
						}
					}
					menu_list.add(first);
				}
				result=WxMenuUtil.getInstance().createWXMenu(accountid,menu_list);
			}
		} catch (Exception e) {
			logger.error("系统异常，请稍后再试", e);
			e.printStackTrace();
			result.setSuccess(Boolean.FALSE);
			result.setErrorMsg("系统异常，请稍后再试");
			result.setErrorCode("9999");
		}
		try {
			JSONObject array = JSONObject.fromObject(result);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(array.toString());
			response.getWriter().close();
		} catch (IOException e) {

		}
	}
}
