package com.cjmei.module.weixin.wfhao.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.util.WxFwUtil;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;
import com.cjmei.module.weixin.wfhao.service.WeixinAccountService;

public class UpdateWxUserhreadPool {
	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(5);// 开5个线程处理消息推送
	}

	public static void destroy() {
		pool.shutdown();
	}

	public static void updateWxUser(String accountid, String openid) {
		WxUser wxUser = new WxUser();
		wxUser.setAccountid(accountid);
		wxUser.setOpenid(openid);
		pool.execute(new UpdateWxUserThread(0, wxUser));
	}

	public static void updateWxUser(WxUser user) {
		pool.execute(new UpdateWxUserThread(1, user));
	}

}

class UpdateWxUserThread implements Runnable {
	private int subcribeFlag;
	private WxUser wxUser;
	WeixinAccountService weixinAccountService = (WeixinAccountService) DatabaseHelper
			.getBean(WeixinAccountService.class);

	public UpdateWxUserThread(int subcribeFlag, WxUser wxUser) {
		this.subcribeFlag = subcribeFlag;
		this.wxUser = wxUser;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			WxUser user = WxFwUtil.getInstance().getUserInfo(wxUser.getAccountid(), wxUser.getOpenid());
			if (user != null) {
				if (subcribeFlag == 1) {
					user.setSubscribetype(wxUser.getSubscribetype());
					user.setQrNo(wxUser.getQrNo());
					user.setIssubscribe(wxUser.getIssubscribe());
				}
				weixinAccountService.updateOrUpdateWxUser(user);
			}
		} catch (Exception e) {

		}
	}

}