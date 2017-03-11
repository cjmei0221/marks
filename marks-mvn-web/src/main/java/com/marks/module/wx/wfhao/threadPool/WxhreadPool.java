package com.marks.module.wx.wfhao.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.common.util.IDUtil;
import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wx.util.WxFwUtil;
import com.marks.module.wx.wfhao.pojo.WxUser;
import com.marks.module.wx.wfhao.service.WeixinAccountService;
import com.marks.module.wx.wxchatmsg.dao.WxChatMsgDao;
import com.marks.module.wx.wxchatmsg.pojo.WxChatMsg;

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

	public static void saveWxChatMsg(WxChatMsg msg) {
		pool.execute(new WxChatMsgThread(msg));
	}

}


class WxChatMsgThread implements Runnable {
	private WxChatMsg msg;
	WeixinAccountService weixinAccountService = (WeixinAccountService) DatabaseHelper
			.getBean(WeixinAccountService.class);
	WxChatMsgDao wxChatMsgDao = (WxChatMsgDao) DatabaseHelper
			.getBean(WxChatMsgDao.class);
	public WxChatMsgThread(WxChatMsg msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			if (msg != null) {
				msg.setC_type(0);
				WxUser wxUser=weixinAccountService.queryWxUserByOpenID(msg.getAccountid(), msg.getOpenid());
				if(wxUser !=null){
					msg.setFanId(wxUser.getFanId());
				}
//				msg.setSession_id("S"+IDUtil.getTimeID());
				wxChatMsgDao.save(msg);
			}
		} catch (Exception e) {

		}
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