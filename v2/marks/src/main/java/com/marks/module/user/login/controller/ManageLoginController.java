package com.marks.module.user.login.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marks.common.domain.Result;
import com.marks.common.enums.Enums;
import com.marks.common.util.Code;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.RequestUtil;
import com.marks.common.util.encrypt.EncryptUtil;
import com.marks.module.core.runModel.RunModel;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.org.orginfo.service.OrgInfoService;
import com.marks.module.system.syslog.pojo.SysLog;
import com.marks.module.system.syslog.thread.SysLogThreadPool;
import com.marks.module.system.sysmenu.pojo.SysMenu;
import com.marks.module.system.sysmenu.pojo.SysOperate;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysrole.pojo.SysRole;
import com.marks.module.user.sysrole.service.SysRoleService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.wx.manage.base.service.WxAccountService;

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
	@Autowired
	private LoginService loginService;
	@Autowired
	private WxAccountService wxAccountService;

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private OrgInfoService orgInfoService;
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
		String companyId = RunModel.getInstance().getCompanyId();
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
		if (Enums.SysUserUse.NOUSE.getValue() == user.getActiveFlag()) {
			result.setCode("4002");
			result.setMessage("用户被禁用");
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

		SysRole role = sysRoleService.findById(user.getRoleid());
		if (role == null) {
			result.setCode("4005");
			result.setMessage("您没有权限登录");
			JsonUtil.output(response, result);
			return;
		}
		List<String> list = loginService.getUrlByUserid(user.getUserid());
		user.setUserUrlList(list);

		result.setCode("0");
		result.setMessage("success");
		user.setLoginTime(new Date());
		user.setPassword("");
		user.setRole(role);
		user.setCompanyNo(user.getCompanyId());
		// 所属机构
		List<OrgInfo> orgList = loginService.getOrgInfoListByUserid(user.getUserid());
		user.setOrgInfoList(orgList);
		List<String> orgids = null;
		// 组织架构
		boolean companyflag=false;
		if (null != orgList && orgList.size() > 0) {
			orgids = new ArrayList<String>();
			for (OrgInfo sr : orgList) {
				orgids.add(sr.getOrgid());
				if (Enums.OrgType.company.getValue() == sr.getOrgType()) {
					companyflag = true;
				}
				if (1 == sr.getIsDefault()) {
					user.setDefaultOrgid(sr.getOrgid());
					user.setDefaultOrgname(sr.getOrgname());
				}
			}
		}
		OrgInfo company = orgInfoService.findById(user.getCompanyNo());
		user.setOrgids(null);
		if (company.getIsMain() == 1) {
			user.setCompanyId(null);
		}
		if(!companyflag){
			user.setOrgids(orgids);
		}
		// 关联服务号
		user.setAccountids(null);
		if (null != user.getCompanyNo()) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("conpanyId", user.getCompanyNo());
			// param.put("orgids", user.getOrgids());
			param.put("orgids", null);
			List<String> accountids = wxAccountService.getAccountIdsByLoginUser(param);
			if(accountids !=null && accountids.size()>0){
				user.setAccountids(accountids);
			}
		}
		ManageUtil.setCurrentUserInfo(request, user);
		// 保存日志
		SysLog log = new SysLog();
		log.setUserid(user.getUserid());
		log.setUsername(user.getUsername());
		log.setRetain3(user.getCompanyNo());
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
		SysUser user = ManageUtil.getCurrentUserInfo(request);
		if (user != null) {
			ManageUtil.setCurrentUserInfo(request, null);
			// 保存日志
			SysLog log = new SysLog();
			log.setUserid(user.getUserid());
			log.setUsername(user.getUsername());
			log.setRetain3(user.getCompanyNo());
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
		SysUser user = ManageUtil.getCurrentUserInfo(request);
		List<SysMenu> list = loginService.getSysMenuOfSysUser(user);
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		result.getData().put("menuList", list);
		result.getData().put("loginUser", user);
		JsonUtil.output(response, result);
	}
	@RequestMapping("/inner/sys/menuOperate")
	public void menuOperate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		SysUser user = ManageUtil.getCurrentUserInfo(request);
		String menuid=request.getParameter("menuid");
		List<SysOperate> list=loginService.getSysOperate(menuid,user);
		result.setCode(Code.CODE_SUCCESS);
		result.setMessage("success");
		result.getData().put("operList", list);
		JsonUtil.output(response, result);
	}
}
