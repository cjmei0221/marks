package com.marks.smart.wx.api.mp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.smart.wx.api.mp.wxInteface.material.wxservice.WxMaterialUtil;

import net.sf.json.JSONObject;
/**
 * 微社区素材控制层
 * @author developer265
 * 2016年3月22日15:22:13
 */
@Controller
public class WxMaterialController {
	private Logger logger = Logger.getLogger(WxMaterialController.class);
	
	//素材数量
	@RequestMapping("/center/weixinmaterial/getcount")
	public void getCount(HttpServletRequest request,HttpServletResponse response){
		try {
			JsonResult result = new JsonResult();
			logger.info("获取素材数量");
			String accountId = request.getParameter("accountId");
			if(accountId!=null&&!"".equals(accountId)){
				JsonResult json = WxMaterialUtil.getCount(accountId);
				result.setResult(json);
			}else{
				result.setErrorCode("1");
				result.setErrorMsg("参数错误");
				result.setSuccess(false);
			}
			
			JSONObject array = JSONObject.fromObject(result);
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().write(array.toString());
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info(e);
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取素材数量失败",e);
		}
		
	}
	//素材列表
	@RequestMapping("/center/weixinmaterial/getmateriallist")
	public void getMaterialList(HttpServletRequest request,HttpServletResponse response){
		try {
			JsonResult result = new JsonResult();
			String accountId = request.getParameter("accountId");
			String type = request.getParameter("type");
			String start = request.getParameter("start");
			if(accountId!=null&&!"".equals(accountId)&&type!=null&&!"".equals(type)&&start!=null&&!"".equals(start)){
				JsonResult json = WxMaterialUtil.getMaterialList(accountId,type,start);
				result.setResult(json);
			}else{
				result.setErrorCode("1");
				result.setErrorMsg("参数错误");
				result.setSuccess(false);
			}
			
			JSONObject array = JSONObject.fromObject(result);
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().write(array.toString());
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info(e);
				e.printStackTrace();
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取素材列表失败",e);
		}
	}
	
}
