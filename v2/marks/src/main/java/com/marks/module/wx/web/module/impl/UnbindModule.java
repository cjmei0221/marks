package com.marks.module.wx.web.module.impl;

import javax.servlet.http.HttpServletRequest;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.user.login.helper.LoginUtil;
import com.marks.module.user.sysuser.service.SysUserService;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.module.Module;

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
