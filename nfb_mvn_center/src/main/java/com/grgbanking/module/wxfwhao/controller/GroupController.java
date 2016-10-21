package com.grgbanking.module.wxfwhao.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grgbanking.common.util.JsonResult;
import com.grgbanking.module.wxfwhao.wxservice.GroupUtil;

import net.sf.json.JSONObject;

@Controller
public class GroupController {
	private static Logger logger = Logger.getLogger(GroupController.class);
	/**
	 * 移动用户分组
	 * @param request
	 * @param response
	 * @throws Exception
	 */
		@RequestMapping(value = "/groups/members/update")
		public void getWXUserOpenId(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			JsonResult result = new JsonResult();
			try {
				String accountid = request.getParameter("accountid");
				String openid = request.getParameter("openid");
				String to_groupid=request.getParameter("to_groupid");
				result=GroupUtil.getInstance().toGroup(accountid,openid,to_groupid);
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
