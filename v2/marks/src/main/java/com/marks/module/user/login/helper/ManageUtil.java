package com.marks.module.user.login.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.user.sysuser.pojo.SysUser;

/**
 * 用户助手类
 * 
 * @author cypei
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class ManageUtil {

	private static final Logger LOG = Logger.getLogger(ManageUtil.class);

	/**
	 * 获取取当前用户key
	 */
	public static final String USER_SESSION_KEY = "INNER_USER_SESSION_KEY";

	/**
	 * 根据请求对象取得当前用户信息对象
	 * 
	 * @param request
	 * @return
	 */
	public static SysUser getCurrentUserInfo(HttpServletRequest request) {
		return (SysUser) request.getSession().getAttribute(USER_SESSION_KEY);
	}

	/**
	 * 设置当前用户信息到session对象中
	 * 
	 * @param request
	 * @param u
	 */
	public static void setCurrentUserInfo(HttpServletRequest request, SysUser u) {
		request.getSession().setAttribute(USER_SESSION_KEY, u);
	}

}
