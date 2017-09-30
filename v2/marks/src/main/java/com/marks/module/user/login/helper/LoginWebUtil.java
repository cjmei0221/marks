package com.marks.module.user.login.helper;

import javax.servlet.http.HttpServletRequest;

import com.marks.module.core.runModel.RunModel;
import com.marks.module.user.sysuser.pojo.SysUser;

public class LoginWebUtil {
	public static LoginWebUtil util = null;

	private LoginWebUtil() {
	}

	public static LoginWebUtil getInstance() {
		if(util==null){
			util = new LoginWebUtil();
		}
		return util;
	}
	public void setCurrentUser(HttpServletRequest request,SysUser user) {
		user.setPassword("");
		request.getSession().setAttribute("cSysUser", user);
	}
	public SysUser getCurrentUser(HttpServletRequest request){
		Object obj = request.getSession().getAttribute("cSysUser");
		SysUser user = null;
		if (null != obj) {
			user = (SysUser) obj;
		}
		if (RunModel.getInstance().getMode().equals("N")) {
			user=new SysUser();
			user.setUserid("admin");
		}
		return user;
	}
}
