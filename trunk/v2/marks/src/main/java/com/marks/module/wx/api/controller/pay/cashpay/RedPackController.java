package com.marks.module.wx.api.controller.pay.cashpay;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.core.controller.SupportContorller;
import com.marks.module.wx.api.wxInterface.pay.cashpay.pojo.QueryRedPackReq;
import com.marks.module.wx.api.wxInterface.pay.cashpay.pojo.RedPackReq;
import com.marks.module.wx.api.wxInterface.pay.cashpay.pojo.RedPackReqGroup;
import com.marks.module.wx.api.wxInterface.pay.cashpay.wxservice.RedPackService;

import net.sf.json.JSONObject;

@Controller
public class RedPackController extends SupportContorller{
	private static Logger logger = Logger.getLogger(RedPackController.class);
	
	/**
	 * 发放普通红包
	 * */ 
	@RequestMapping(value = "/center/redPack/sendredpack")
	public void sendredpack(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid=request.getParameter("accountid");
			RedPackReq vo = getModel(RedPackReq.class);
			result=RedPackService.getInstance().sendCommonRad(accountid,vo);
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
	 * 发放裂变红包
	 * */ 
	@RequestMapping(value = "/center/redPack/sendgroupredpack")
	public void sendgroupredpack(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid=request.getParameter("accountid");
			RedPackReqGroup vo = getModel(RedPackReqGroup.class);
			result=RedPackService.getInstance().sendgroupredpack(accountid,vo);
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
	@RequestMapping(value = "/center/redPack/gethbinfo")
	public void gethbinfo(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid=request.getParameter("accountid");
			QueryRedPackReq vo = getModel(QueryRedPackReq.class);
			result=RedPackService.getInstance().gethbinfo(accountid,vo);
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
