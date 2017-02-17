package com.marks.module.wxqyhao.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.util.JsonResult;
import com.marks.module.wxqyhao.common.wxservice.UserUtil;

import net.sf.json.JSONObject;

@Controller
public class QyUserController {
	private static Logger logger = Logger.getLogger(QyUserController.class);
	@RequestMapping(value = "/qyAuth/getUserid")
	public void createDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String code = request.getParameter("code");
			String accountid=request.getParameter("accountid");
			result=UserUtil.getInstance().getUserid(accountid, code);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/wechat/changeUidToOpid")
	public void changeUidToOpid(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String userId = request.getParameter("userId");
			String accountid = request.getParameter("accountid");
			String agentid=request.getParameter("agentid");
			result=UserUtil.getInstance().change(accountid,userId,agentid);
		} catch (Exception e) {
			logger.error("系统异常，请稍后再试", e);
			result.setSuccess(Boolean.FALSE);
			result.setErrorMsg("系统异常，请稍后再试");
			result.setErrorCode("9999");
		}
		try {
			JSONObject array = JSONObject.fromObject(result);
			logger.info("返回数据："+array.toString());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(array.toString());
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
