package com.marks.smart.wx.manage.web.module.impl;

import javax.servlet.http.HttpServletRequest;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.system.user.login.helper.LoginUtil;
import com.marks.smart.system.user.sysuser.service.SysUserService;
import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.module.Module;

/**
 * 回复文本消息
 * 
 * @author lhyan3 2015年7月15日下午2:47:11
 */
public class UnbindModule extends Module{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	@Override
	public WechatResponse syncRequest(HttpServletRequest request, WechatRequest requestMessage) {
		SysUserService sysUserService = SpringContextHolder.getBean(SysUserService.class);
		WechatResponse textResponseMessage = new WechatResponse(requestMessage);
		sysUserService.updateUnbinding(requestMessage.getAccountId(), requestMessage.getFromUserName());
		LoginUtil.getInstance().setCurrentUser(request, null);
		textResponseMessage.setContent("解绑成功");
		return textResponseMessage;
	}

	@Override
	public String getOperate() {
		return "回复文本消息";
	}

}
