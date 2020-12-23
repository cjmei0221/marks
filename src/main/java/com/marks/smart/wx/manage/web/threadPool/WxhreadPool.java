package com.marks.smart.wx.manage.web.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.wx.api.mp.wxInteface.user.entity.WxUser;
import com.marks.smart.wx.manage.mp.dao.WxUserDao;
import com.marks.smart.wx.manage.mp.entity.WxChatSession;
import com.marks.smart.wx.manage.mp.service.WxChatSessionService;
import com.marks.smart.wx.manage.mp.service.WxUserService;
import com.marks.smart.wx.manage.mp.util.WxMpUtil;

public class WxhreadPool {
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

	public static void saveWxChatMsg(WxChatSession msg) {
		pool.execute(new WxChatMsgThread(msg));
	}

}


class WxChatMsgThread implements Runnable {
	private static Logger logger = Logger.getLogger(WxChatMsgThread.class);
	private WxChatSession msg;
	WxUserDao wxUserDao = (WxUserDao) SpringContextHolder
			.getBean(WxUserDao.class);
	WxChatSessionService wxChatSessionService = (WxChatSessionService) SpringContextHolder
			.getBean(WxChatSessionService.class);
	public WxChatMsgThread(WxChatSession msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			if (msg != null) {
				wxChatSessionService.save(msg);
			}
		} catch (Exception e) {
			logger.error("WxChatMsgThread", e);
		}
	}

}

class UpdateWxUserThread implements Runnable {
	private int subcribeFlag;
	private WxUser wxUser;
	WxUserService wxUserService = (WxUserService) SpringContextHolder
			.getBean(WxUserService.class);

	public UpdateWxUserThread(int subcribeFlag, WxUser wxUser) {
		this.subcribeFlag = subcribeFlag;
		this.wxUser = wxUser;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			WxUser user = WxMpUtil.getInstance().getUserInfo(wxUser.getAccountid(), wxUser.getOpenid());
			if (user != null) {
				if (subcribeFlag == 1) {
					user.setSubscribetype(wxUser.getSubscribetype());
					user.setQrNo(wxUser.getQrNo());
					user.setIssubscribe(wxUser.getIssubscribe());
				}
				wxUserService.saveOrUpdateWxUser(user);;
			}
		} catch (Exception e) {

		}
	}

}