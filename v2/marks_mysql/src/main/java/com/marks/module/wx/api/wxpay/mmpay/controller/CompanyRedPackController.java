package com.marks.module.wx.api.wxpay.mmpay.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.wx.api.wxpay.mmpay.pojo.CompanyQueryRedPackReq;
import com.marks.module.wx.api.wxpay.mmpay.pojo.CompanyRedPackReq;
import com.marks.module.wx.api.wxpay.mmpay.wxservice.CompanyRedPackService;

import net.sf.json.JSONObject;

@Controller
public class CompanyRedPackController extends SupportContorller{
	private static Logger logger = Logger.getLogger(CompanyRedPackController.class);
	
	/**
	 * 发放普通红包
	 * */ 
	@RequestMapping(value = "/center/companyRedPack/transfers")
	public void companyPay(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid=request.getParameter("accountid");
			CompanyRedPackReq vo = getModel(CompanyRedPackReq.class);
			result=CompanyRedPackService.getInstance().companyPay(accountid,vo);
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
	
	/**
	 * 查询红包结果
	 * */ 
	@RequestMapping(value = "/center/companyRedPack/gettransferinfo")
	public void gettransferinfo(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid=request.getParameter("accountid");
			CompanyQueryRedPackReq vo = getModel(CompanyQueryRedPackReq.class);
			result=CompanyRedPackService.getInstance().gettransferinfo(accountid,vo);
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

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return logger;
	}

}
