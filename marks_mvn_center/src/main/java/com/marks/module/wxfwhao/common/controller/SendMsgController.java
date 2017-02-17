package com.marks.module.wxfwhao.common.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.wxfwhao.common.wxservice.SendMsgUtils;

import net.sf.json.JSONObject;

@Controller
public class SendMsgController {
	 private static Logger logger = Logger.getLogger(SendMsgController.class);
	 
	 /**
	  * 发送客户消息
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 @RequestMapping(value = "/wechat/sendCustomTextMsg")
	  public void sendCustomTextMsg(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			JsonResult result = new JsonResult();
			result.setErrorCode(SysCode.ERROR);
			try {
				String accountid = request.getParameter("accountid");
				String content = request.getParameter("content");
				content = URLDecoder.decode(content, "utf-8");
				String openid = request.getParameter("openid");
				result=SendMsgUtils.getInstance().sendCustomTextMsg(accountid,openid, content);
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
