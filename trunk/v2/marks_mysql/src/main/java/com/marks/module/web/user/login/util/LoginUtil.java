package com.marks.module.web.user.login.util;

import javax.servlet.http.HttpServletRequest;

import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.web.runModel.RunModel;

public class LoginUtil {
	public static LoginUtil util=null;
	private LoginUtil(){}
	public static LoginUtil getInstance(){
		if(util==null){
			util=new LoginUtil();
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
