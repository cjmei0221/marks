package com.marks.module.wx.api.controller.work.department;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.wx.api.wxInterface.work.department.entity.Department;
import com.marks.module.wx.api.wxInterface.work.department.wxservice.DepartmentUtil;

import net.sf.json.JSONObject;

@Controller
public class DepartmentController {
	private static Logger logger = Logger.getLogger(DepartmentController.class);
	
	@RequestMapping(value = "/center/department/createDepartment")
	public void createDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String parentid = request.getParameter("parentid");
			String name = request.getParameter("name");
			name = URLDecoder.decode(name, "utf-8");
			String order = request.getParameter("order");
			String id = request.getParameter("id");
			Department po = new Department();
			po.setId(id);
			po.setName(name);
			po.setOrder(order);
			po.setParentid(parentid);
			result=DepartmentUtil.getInstance().createDepartment(accountid,po);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/center/department/updateDepartment")
	public void updateDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String parentid = request.getParameter("parentid");
			String name = request.getParameter("name");
			name = URLDecoder.decode(name, "utf-8");
			String order = request.getParameter("order");
			String id = request.getParameter("id");
			Department po = new Department();
			po.setId(id);
			po.setName(name);
			po.setOrder(order);
			po.setParentid(parentid);
			result=DepartmentUtil.getInstance().updateDepartment(accountid,po);
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
			e.printStackTrace();
		}

	}
	@RequestMapping(value = "/center/department/deleteDepartment")
	public void deleteDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String id = request.getParameter("id");
			result=DepartmentUtil.getInstance().deleteDepartment(accountid,id);
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
	@RequestMapping(value = "/center/department/listDepartment")
	public void listDepartment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String id = request.getParameter("id");
			result=DepartmentUtil.getInstance().listDepartment(accountid,id);
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
}
