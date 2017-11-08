package com.marks.module.wx.api.controller.mp.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.wx.api.wxInterface.mp.user.wxservice.UserUtil;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 获取关注者信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/center/user/getUserInfo")
	public void getUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String openid = request.getParameter("openid");
			result=UserUtil.getInstance().getWXUserInfo(accountid,openid);
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
 * 获取用户列表
 * @param request
 * @param response
 * @throws Exception
 */
	@RequestMapping(value = "/center/user/getWXUserOpenId")
	public void getWXUserOpenId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String next_openid = request.getParameter("next_openid");
			result=UserUtil.getInstance().getWXUserList(accountid,next_openid);
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
