package com.marks.module.user.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.util.validate.ValidateCode;
import com.marks.common.util.validate.VcodeUtil;

@Controller
public class ValidateCodeImgController {
	private static Logger logger = Logger.getLogger(ValidateCodeImgController.class);
	
	/**
	 * 查询我的日记
	 */
	@RequestMapping("/web/getValidateCode")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {
		// 设置响应的类型格式为图片格式  
	    try {
			response.setContentType("image/jpeg");  
			//禁止图像缓存。  
			response.setHeader("Pragma", "no-cache");  
			response.setHeader("Cache-Control", "no-cache");  
			response.setDateHeader("Expires", 0);   
			int width=Integer.parseInt(request.getParameter("width"));
			int height=Integer.parseInt(request.getParameter("height"));
			ValidateCode vCode = new ValidateCode(width,height,4,0);  
			VcodeUtil.getInstance().setValidateCode(request, vCode.getCode());
			vCode.write(response.getOutputStream());
		} catch (IOException e) {
			logger.error("getValidateCode", e);
		}  
	}

	
}
