package com.marks.module.user.login.helper;

import javax.servlet.http.HttpServletRequest;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.core.runModel.RunModel;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;

public class LoginUtil {
	public static LoginUtil util = null;
	private static String LOGINUSER_OPENID = "LOGINUSER_OPENID";
	private static String LOGINUSER_ACCOUNTID = "LOGINUSER_ACCOUNTID";

	private LoginUtil() {
	}

	public static LoginUtil getInstance() {
		if (util == null) {
			util = new LoginUtil();
		}
		return util;
	}

	public void setCurrentUser(HttpServletRequest request, SysUser user) {
		if (null != user) {
			user.setPassword("");
		}
		request.getSession().setAttribute("cSysUser", user);
	}

	public SysUser getCurrentUser(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute("cSysUser");
		SysUser user = null;
		if (null != obj) {
			user = (SysUser) obj;
		}
		if (RunModel.getInstance().getMode().equals("N")) {
			String openid = this.getCurrentOpenid(request);
			String accountid = this.getCurrentAccountid(request);
			LoginService loginService = SpringContextHolder.getBean(LoginService.class);
			user = loginService.getSysUserByOpenidAndAccountid(accountid, openid);
		}
		return user;
	}

	public String getCurrentOpenid(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(LOGINUSER_OPENID);
		String openid = null;
		if (null != obj && !"".equals(String.valueOf(obj)) && !"null".equals(String.valueOf(obj))) {
			openid = String.valueOf(obj);
		}
		if (RunModel.getInstance().getWeixinMode().equals("N")) {
			openid = RunModel.getInstance().getTestOpenid();
		}
		return openid;
	}

	public void setCurrentOpenid(HttpServletRequest request, String openid) {
		request.getSession().setAttribute(LOGINUSER_OPENID, openid);
	}

	public void setCurrentAccountid(HttpServletRequest request, String accountid) {
		request.getSession().setAttribute(LOGINUSER_ACCOUNTID, accountid);
	}

	public String getCurrentAccountid(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(LOGINUSER_ACCOUNTID);
		String accountid = null;
		if (null != obj && !"".equals(String.valueOf(obj)) && !"null".equals(String.valueOf(obj))) {
			accountid = String.valueOf(obj);
		}
		if (RunModel.getInstance().getWeixinMode().equals("N")) {
			accountid = RunModel.getInstance().getWxAccountId();
		}
		return accountid;
	}

}
