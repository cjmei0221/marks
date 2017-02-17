package com.marks.module.wxfwhao.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.util.JsonResult;
import com.marks.common.util.SysCode;
import com.marks.module.wxfwhao.common.wxservice.AccountUtil;

import net.sf.json.JSONObject;
@Controller
public class AccountController {
	
	private static Logger logger = Logger.getLogger(AccountController.class);

	/**
	 * 获取二维码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/wechat/createQrcode")
	public void createQrcode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JsonResult result = new JsonResult();
		result.setErrorCode(SysCode.ERROR);
		try {
			String accountid = request.getParameter("accountid");
			String action_type = request.getParameter("action_type");
			String expire_seconds = request.getParameter("expire_seconds");
			String scene_id = request.getParameter("scene_id");
			logger.info("accountid:"+accountid+"-action_type:"+action_type+"-expire_seconds:"+expire_seconds+"-scene_id:"+scene_id);
			result=AccountUtil.getInstance().createQrcode(accountid,Integer.parseInt(action_type),Integer.parseInt(expire_seconds),Integer.parseInt(scene_id));
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
