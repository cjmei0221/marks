package com.marks.smart.wx.manage.mp.thread;

import java.util.List;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.wx.api.mp.wxInteface.user.entity.WxUser;
import com.marks.smart.wx.manage.mp.service.WxUserService;
import com.marks.smart.wx.manage.mp.util.WxMpUtil;

public class WxUserThread implements Runnable {

	private List<String> openid_list;
	private String accountId;

	public WxUserThread(String accountId, List<String> openid_list) {
		this.openid_list = openid_list;
		this.accountId = accountId;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			WxUserService wxUserService = SpringContextHolder.getBean(WxUserService.class);
			for (String openid : openid_list) {
				WxUser user = WxMpUtil.getInstance().getUserInfo(accountId, openid);
				wxUserService.saveOrUpdateWxUser(user);
			}
		} catch (Exception e) {

		}
	}

}
