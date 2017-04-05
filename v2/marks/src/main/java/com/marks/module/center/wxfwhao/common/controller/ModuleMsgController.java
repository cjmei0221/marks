package com.marks.module.center.wxfwhao.common.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.inner.wx.modulemsg.service.ModuleMsgService;

import net.sf.json.JSONObject;

/**
 * 模板消息
 * 
 * @author cjmei
 *
 */
@Controller
public class ModuleMsgController {

	private static Logger logger = Logger.getLogger(ModuleMsgController.class);
	@Autowired
	private ModuleMsgService moduleMsgService;

	@RequestMapping(value = "/center/modulemsg/sendTemplateMsg")
	public void sendTemplateMsg(HttpServletRequest request, HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String toUser = request.getParameter("toUser");
			String templateCode = request.getParameter("templateCode");
			String url = "";
			if (request.getParameter("toUrl") != null && !request.getParameter("toUrl").trim().equals("")) {
				url = URLDecoder.decode(request.getParameter("toUrl"), "utf-8");
				logger.info("toUrl>>" + url);
			}
			String data = "";
			if (request.getParameter("data") != null && !request.getParameter("data").trim().equals("")) {
				data = URLDecoder.decode(request.getParameter("data"), "utf-8");
			}

			String note = "";
			if (request.getParameter("note") != null && !request.getParameter("note").trim().equals("")) {
				note = URLDecoder.decode(request.getParameter("note"), "utf-8");
			}
			result = moduleMsgService.sendTemplateMsg(accountid, toUser, templateCode, url, data,note);
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
