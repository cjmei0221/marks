package com.marks.module.wx.manage.thread;

import java.util.List;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.wx.api.wxInterface.mp.user.entity.WxUser;
import com.marks.module.wx.manage.service.user.WxUserService;
import com.marks.module.wx.manage.util.WxMpUtil;

public class SyncWxUserThread implements Runnable {

	private List<String> openid_list;
	private String accountId;

	public SyncWxUserThread(String accountId, List<String> openid_list) {
		this.openid_list = openid_list;
		this.accountId = accountId;
	}
	@Override
	public void run() {
		try {
			WxUserService wxUserService = SpringContextHolder.getBean(WxUserService.class);
			for (String openid : openid_list) {
				WxUser user = WxMpUtil.getInstance().getUserInfo(accountId, openid);
				wxUserService.saveOrUpdateWxUser(user);
			}
		} catch (Exception e) {

		}
	}

}
