package com.marks.module.center.wxfwhao.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.common.util.center.SysCode;
import com.marks.module.center.wxfwhao.common.wxservice.JssdkUtil;

import net.sf.json.JSONObject;

@Controller
public class JssdkController {
	
	private static Logger logger = Logger.getLogger(JssdkController.class);
	/**
	 * 获取关注者信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/jssdk/getJssdkTicket")
	public void getUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		result.setErrorCode(SysCode.ERROR);
		try {
			String accountid = request.getParameter("accountid");
			String ticket=JssdkUtil.getInstance().getJsapi_ticket(accountid);
			result.setResult(ticket);
			result.setSuccess(Boolean.TRUE);
			result.setErrorCode(SysCode.SUCCESS);
		} catch (Exception e) {
			logger.error("系统异常，请稍后再试", e);
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
