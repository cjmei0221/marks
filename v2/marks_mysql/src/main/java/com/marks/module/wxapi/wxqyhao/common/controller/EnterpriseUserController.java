package com.marks.module.wxapi.wxqyhao.common.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.JsonResult;
import com.marks.module.wxapi.wxqyhao.common.entity.EnterpriseUser;
import com.marks.module.wxapi.wxqyhao.common.wxservice.EnterpriseUserUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class EnterpriseUserController {
	private static Logger logger = Logger.getLogger(EnterpriseUserController.class);
	@RequestMapping(value = "/center/user/createEnterpriseUser")
	public void createEnterpriseUser(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		logger.info("进入创建企业成员！");
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid");
			String name = request.getParameter("name");
			name = URLDecoder.decode(name, "utf-8");
			String department = request.getParameter("department");
			String position = request.getParameter("position");
			position = URLDecoder.decode(position, "utf-8");
			String mobile = request.getParameter("mobile");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String weixinid = request.getParameter("weixinid");
			String avatar_mediaid = request.getParameter("avatar_mediaid");
			/*String extattr = request.getParameter("extattr");
			extattr = URLDecoder.decode(extattr, "utf-8");*/
			EnterpriseUser po = new EnterpriseUser();
			po.setUserid(userid);
			po.setName(name);
			po.setDepartment(department);
			po.setPosition(position);
			po.setMobile(mobile);
			po.setGender(gender);
			po.setEmail(email);
			po.setWeixinid(weixinid);
			po.setAvatar_mediaid(avatar_mediaid);
//			po.setExtattr(extattr);
			logger.info("msgcenter:-accountid==" +accountid+"-userid=="+po.getUserid()+"-name=="+po.getName()+"-department=="+po.getDepartment()+"-position=="+po.getPosition()+"-mobile"+po.getMobile()+"-gender=="+po.getGender()+"-email=="+po.getEmail()+"-weixinid=="+po.getWeixinid()+"-avatar_mediaid=="+po.getAvatar_mediaid()+"-extattr=="+po.getExtattr());
			result = EnterpriseUserUtil.getInstance().createEnterpriseUser(accountid, po);
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
	//修改企业成员
	@RequestMapping(value = "/center/user/updateEnterpriseUser")
	public void updateEnterpriseUser(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		logger.info("进入修改企业成员！");
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid");
			String name = request.getParameter("name") ;
			if(null!=name&&!("".equals(name))){
				name = URLDecoder.decode(name, "utf-8");
			}
			String department = request.getParameter("department");
			String position = request.getParameter("position");
			if(null!=position&&!("".equals(position))){
				position = URLDecoder.decode(position, "utf-8");
			}
			String enable = request.getParameter("enable");
			String mobile = request.getParameter("mobile");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email") ;
			String weixinid = request.getParameter("weixinid");
//			String avatar_mediaid = request.getParameter("avatar_mediaid");
//			name = URLDecoder.decode(name, "utf-8");
//			String extattr = request.getParameter("extattr");
			EnterpriseUser po = new EnterpriseUser();
			po.setUserid(userid);
			po.setName(name);
			po.setDepartment(department);
			po.setPosition(position);
			po.setMobile(mobile);
			po.setGender(gender);
			po.setEmail(email);
			po.setWeixinid(weixinid);
			po.setEnable(enable);
//			po.setAvatar_mediaid(avatar_mediaid);
//			po.setExtattr(extattr);
			result = EnterpriseUserUtil.getInstance().updateEnterpriseUser(accountid, po);
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

	// 删除企业成员
	@RequestMapping(value = "/center/user/deleteEnterpriseUser")
	public void deleteEnterpriseUser(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid") == null ? ""
					: request.getParameter("userid");
			result = EnterpriseUserUtil.getInstance().deleteEnterpriseUser(accountid, userid);
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

	// 批量删除企业成员
	@RequestMapping(value = "/center/user/deleteEnterpriseUserList")
	public void deleteEnterpriseUserList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		List<String> userids = new ArrayList<String>();
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid") == null ? ""
					: request.getParameter("userid");
			if (null != userid) {
				JSONArray arr = JSONArray.fromObject(userid);
				for (int i = 0; i < arr.size(); i++) {
					String useridd = arr.optString(i);
					userids.add(useridd);
				}
			}
			result = EnterpriseUserUtil.getInstance().deleteEnterpriseUserList(accountid, userids);
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

	// 获取成员
	@RequestMapping(value = "/center/user/getEnterpriseUser")
	public void getEnterpriseUser(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid");
			result = EnterpriseUserUtil.getInstance().getEnterpriseUser(accountid, userid);
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

	// 获取部门成员
	@RequestMapping(value = "/center/user/getDepartmentMember")
	public void getDepartmentMember(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String department_id = request.getParameter("department_id");
			String fetch_child = request.getParameter("fetch_child");
			String status = request.getParameter("status");
			result = EnterpriseUserUtil.getInstance().getDepartmentMember(accountid, department_id, fetch_child, status);
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

	// 获取部门成员详情
	@RequestMapping(value = "/center/user/getDepartmentMember")
	public void getDepartmentMemberDetail(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String department_id = request.getParameter("department_id");
			String fetch_child = request.getParameter("fetch_child");
			String status = request.getParameter("status");
			result = EnterpriseUserUtil.getInstance().getDepartmentMemberDetail(accountid, department_id, fetch_child, status);
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

	// 邀请成员关注
	@RequestMapping(value = "/center/user/sendInvite")
	public void sendInvite(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult result = new JsonResult();
		try {
			String accountid = request.getParameter("accountid");
			String userid = request.getParameter("userid");
			result = EnterpriseUserUtil.getInstance().sendInvite(accountid, userid);
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
