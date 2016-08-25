package com.grgbanking.inner.helper;

import javax.servlet.http.HttpServletRequest;

import com.grgbanking.inner.po.sys.SysUser;

/**
 * 用户助手类
 * @author cypei
 *
 */
public class SysUserHelper {
	
	private static final String USER_SESSION_KEY = "USER_SESSION_KEY";

	/**
	 * 根据请求对象取得当前用户信息对象
	 * @param request
	 * @return
	 */
	public static SysUser getCurrentUserInfo(HttpServletRequest request){
		return (SysUser)request.getSession().getAttribute(USER_SESSION_KEY);
	}
	
	/**
	 * 设置当前用户信息到session对象中 
	 * @param request
	 * @param u
	 */
	public static void setCurrentUserInfo(HttpServletRequest request,SysUser u){
		request.getSession().setAttribute(USER_SESSION_KEY, u);
	}
}
