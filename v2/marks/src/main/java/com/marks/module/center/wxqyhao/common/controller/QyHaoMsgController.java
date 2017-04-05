package com.marks.module.center.wxqyhao.common.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.center.wxqyhao.common.entity.QyHaoMsg;
import com.marks.module.center.wxqyhao.common.wxservice.QyHaoMsgUtil;

import net.sf.json.JSONObject;

@Controller
public class QyHaoMsgController {
	private Logger logger = Logger.getLogger(QyHaoMsgController.class);

	@RequestMapping("/center/qyhao/sendTextMsg")
	public void noticeXdManager(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		String accountid = request.getParameter("accountid") == null ? ""
				: request.getParameter("accountid");
		String content = request.getParameter("content") == null ? "" : request
				.getParameter("content");
		try {
			content = URLDecoder.decode(content, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
		}
		String userid = request.getParameter("userid") == null ? ""
				: request.getParameter("userid");
		String agentid =request.getParameter("agentid") == null ? "0"
				: request.getParameter("agentid");
		String safe=request.getParameter("safe")==null?"0":request.getParameter("save");

		QyHaoMsg qyHaoMsg = new QyHaoMsg();
		qyHaoMsg.setAgentid(agentid);
		qyHaoMsg.setContent(content);
		qyHaoMsg.setMsgtype("text");
		qyHaoMsg.setSafe(safe);
		qyHaoMsg.setTouser(userid);

		try {
			result = QyHaoMsgUtil.sendQyMsg(qyHaoMsg, accountid);
		} catch (Exception e) {
			logger.info("通知失败", e);
			result.setSuccess(Boolean.FALSE);
		}
		JSONObject array = JSONObject.fromObject(result);

		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(array.toString());
			response.getWriter().close();
		} catch (IOException e) {
			logger.info("IOException");
		}

	}
}
