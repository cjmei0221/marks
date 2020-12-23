package com.marks.smart.wx.api.mp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.smart.wx.api.mp.wxInteface.acct.wxservice.DownloadTempUtil;

import net.sf.json.JSONObject;

public class DownloadTempController {
	private static Logger logger = Logger.getLogger(DownloadTempController.class);
	/**
	 * 移动用户分组
	 * @param request
	 * @param response
	 * @throws Exception
	 */
		@RequestMapping(value = "/center/download/temp")
		public void getWXUserOpenId(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			JsonResult result = new JsonResult();
			try {
				String accountid = request.getParameter("accountid");
				String media_id = request.getParameter("media_id");
				String type = request.getParameter("type");
				String fileName = request.getParameter("fileName");
				result=DownloadTempUtil.getInstance().download(accountid,type,fileName,media_id);
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
