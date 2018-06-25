package com.marks.module.user.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.Constants;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.RequestUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.module.system.syslog.pojo.SysLog;
import com.marks.module.system.syslog.thread.SysLogThreadPool;
import com.marks.module.system.sysmenu.pojo.SysMenu;
import com.marks.module.system.sysmenu.pojo.SysOperate;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserOrgRole;

/**
 * 用户登录 控制层 File Name: com.grgbanking.inner.controller.LoginController.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月27日下午1:59:34
 * @see (optional)
 * @Copyright (c) 2016, marks All Rights Reserved.
 */
@Controller
public class ManageLoginController {
	private static Logger logger = Logger.getLogger(ManageLoginController.class);
	@Autowired
	private LoginService loginService;

	/**
	 * 登录 queryDepartmentList:描述 <br/>
	 *
	 * @param request
	 * @param response
	 * @author marks
	 * @throws Exception
	 * @修改记录:(日期,修改人,描述) (可选) <br/>
	 */
	@RequestMapping("/inner/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String companyId = request.getParameter("companyId");
		// String companyId = RunModel.getInstance().getCompanyId();
		/**
		 * 如果登陆用为system，则拥有所有权限除了业务权限
		 */
		SysUser user = loginService.findById(companyId, userid);
		if (user == null) {
			result.setCode("4001");
			result.setMessage("用户不存在");
			JsonUtil.output(response, result);
			return;
		}
		String password = EncryptUtil.encryptPwd(pwd);
		if (!password.equals(user.getPassword())) {
			result.setCode("4003");
			result.setMessage("密码错误");
			JsonUtil.output(response, result);
			return;
		}
		if (Enums.Status.Unable.getValue() == user.getActiveFlag()) {
			result.setCode("4002");
			result.setMessage("用户被禁用");
			JsonUtil.output(response, result);
			return;
		}
		if (Constants.default_roleId.equals(user.getRoleId())) {
			user.setCompanyId(companyId);
		}
		List<String> list = loginService.getUrlByRoleId(user.getRoleId());
		user.setUserUrlList(list);
		result.setCode("0");
		result.setMessage("success");
		user.setPassword("");
		LoginUtil.getInstance().setCurrentUser(request, user);
		// 保存日志
		SysLog log = new SysLog();
		log.setUserid(user.getUserCode());
		log.setUsername(user.getUsername());
		log.setRetain3(user.getCompanyId());
		String url = request.getRequestURI().replace(request.getContextPath(), "").replace(".do", "");
		String ip = RequestUtil.getIpAddr(request);
		log.setIp(ip);
		log.setRetain1("0");
		log.setRetain2(url);
		log.setUrl(url);
		log.setMenuname("登录管理");
		log.setOpername("登录");
		SysLogThreadPool.saveSysLog(true, log);

		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = LoginUtil.getInstance().getCurrentUser(request);
		if (user != null) {
			result.getData().put("companyId", user.getCompanyId());
			LoginUtil.getInstance().setCurrentUser(request, null);
			// 保存日志
			SysLog log = new SysLog();
			log.setUserid(user.getUserCode());
			log.setUsername(user.getUsername());
			log.setRetain3(user.getCompanyId());
			String url = request.getRequestURI().replace(request.getContextPath(), "").replace(".do", "");
			String ip = RequestUtil.getIpAddr(request);
			log.setIp(ip);
			log.setRetain1("0");
			log.setRetain2(url);
			log.setUrl(url);
			log.setMenuname("登录管理");
			log.setOpername("退出");
			SysLogThreadPool.saveSysLog(true, log);
		}
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");

		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sys/menu")
	public void sysMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = LoginUtil.getInstance().getCurrentUser(request);
		List<SysMenu> list = loginService.getSysMenuOfSysUser(user);
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		result.getData().put("menuList", list);
		JsonUtil.output(response, result);
	}

	@RequestMapping("/inner/sys/menuOperate")
	public void menuOperate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = LoginUtil.getInstance().getCurrentUser(request);
		String menuid = request.getParameter("menuid");
		List<SysOperate> list = loginService.getSysOperate(menuid, user);
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		result.getData().put("operList", list);
		JsonUtil.output(response, result);
	}

	/**
	 * 登陆转换
	 * 
	 * @param accountid
	 * @param pageUrl
	 * @param request
	 * @param response
	 */
	@RequestMapping("/inner/{companyId}")
	public void login1(@PathVariable String companyId, HttpServletRequest request, HttpServletResponse response) {
		logger.info("login companyId > " + companyId);
		String url = "/inner/login.html";

		try {
			// response.sendRedirect(url);
			request.setAttribute("companyId", companyId);
			request.getRequestDispatcher(url).forward(request, response);

		} catch (Exception e) {

		}
	}

	/**
	 * 加载用户角色列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/inner/sys/userRoleList")
	public void userRoleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String userid = admin.getUserid();
		List<SysUserOrgRole> list = loginService.getUserOrgRolelistByUserid(userid);
		result.getData().put("list", list);
		result.getData().put("loginUser", admin);
		JsonUtil.output(response, result);
	}

	/**
	 * 改变角色
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/inner/sys/changeRole")
	public void changeRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser admin = LoginUtil.getInstance().getCurrentUser(request);
		String roleId = request.getParameter("userRoleOrgId");
		List<SysUserOrgRole> list = loginService.getUserOrgRolelistByUserid(admin.getUserid());
		if (list != null && list.size() > 0) {
			for (SysUserOrgRole role : list) {
				if (roleId.equals(role.getUserRoleOrgId())) {
					admin.setRoleId(role.getRoleId());
					admin.setRoleLvl(role.getRoleLvl());
					admin.setRoleName(role.getRoleName());
					admin.setRoleType(role.getRoleType());
					admin.setOrgCategory(role.getOrgCategory());
					admin.setOrgId(role.getOrgId());
					admin.setOrgName(role.getOrgName());
					admin.setOrgType(role.getOrgType());
					admin.setParentOrgId(role.getParentOrgId());
					admin.setParentOrgName(role.getParentOrgName());
					admin.setUserRoleOrgId(role.getUserRoleOrgId());
					admin.setUserUrlList(loginService.getUrlByRoleId(admin.getRoleId()));
				}
			}
		}
		JsonUtil.output(response, result);
	}
}
