package com.marks.module.center.wxfwhao.tags.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.center.wxfwhao.tags.wxservice.UserTagsService;
import com.marks.module.inner.system.sys.controller.SupportContorller;

import net.sf.json.JSONObject;

@Controller
public class UserTagsController {
	private static Logger logger = Logger.getLogger(UserTagsController.class);

	

	/**
	 * 批量为用户打标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/members/batchtagging")
	public void batchtagging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			int tagid = Integer.parseInt(request.getParameter("tagid"));
			String openidArrStr = request.getParameter("openidList");
			JSONArray array = new JSONArray(openidArrStr);
			List<String> openidList = new ArrayList<String>();
			if (array.length() > 0) {
				for (int i = 0; i < array.length(); i++) {
					openidList.add(array.getString(i));
				}
			}
			result = UserTagsService.getInstance().batchtaggingForUser(accountid, tagid, openidList);
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

	/**
	 * 批量为用户取消标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/members/batchuntagging")
	public void batchuntagging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			int tagid = Integer.parseInt(request.getParameter("tagid"));
			String openidArrStr = request.getParameter("openidList");
			JSONArray array = new JSONArray(openidArrStr);
			List<String> openidList = new ArrayList<String>();
			if (array.length() > 0) {
				for (int i = 0; i < array.length(); i++) {
					openidList.add(array.getString(i));
				}
			}
			result = UserTagsService.getInstance().batchtaggingForUser(accountid, tagid, openidList);
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

	/**
	 * 获取用户身上的标签列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/members/batchuntagging")
	public void getidlistForUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String openid = request.getParameter("openid");
			result = UserTagsService.getInstance().getidlistForUser(accountid, openid);
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
