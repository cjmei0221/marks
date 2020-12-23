package com.marks.smart.wx.api.mp.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.smart.wx.api.mp.wxInteface.user.wxservice.TagsService;

import net.sf.json.JSONObject;

@Controller
public class TagsController{
	private static Logger logger = Logger.getLogger(TagsController.class);
	/**
	 * 创建用户标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/create")
	public void createTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
			result=TagsService.getInstance().createTag(accountid, name);
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
	 * 获取标签列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/get")
	public void getTags(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			result=TagsService.getInstance().getTags(accountid);
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
	 * 编辑用户标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/update")
	public void editTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			int id = Integer.parseInt(request.getParameter("tagid"));
			String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
			result=TagsService.getInstance().editTag(accountid,id,name);
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
	 * 删除标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/delete")
	public void delTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			int id = Integer.parseInt(request.getParameter("tagid"));
			result=TagsService.getInstance().delTag(accountid,id);
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
	 * 删除标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/tags/userOpenid")
	public void getOpenidListByTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			int id = Integer.parseInt(request.getParameter("tagid"));
			String next_openid = request.getParameter("next_openid");
			result=TagsService.getInstance().getOpenidListByTag(accountid,id,next_openid);
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
