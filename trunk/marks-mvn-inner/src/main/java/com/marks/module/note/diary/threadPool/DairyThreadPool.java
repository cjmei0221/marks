package com.marks.module.note.diary.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.wx.wxuser.pojo.WxUser;

public class DairyThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(150);// 开10个线程
	}

	public static void destroy() {
		pool.shutdown();
	}

	public static void pushDairyWxMsg(WxUser wxUser) {
		pool.execute(new DairyWxMsgThread(wxUser));
	}

}

class DairyWxMsgThread implements Runnable {

	private WxUser wxUser;
	ModuleMsgService moduleMsgService = (ModuleMsgService) DatabaseHelper.getBean(ModuleMsgService.class);

	public DairyWxMsgThread(WxUser wxUser) {
		this.wxUser = wxUser;
	}

	@Override
	public void run() {
		if (wxUser != null) {
			moduleMsgService.pushDairyWxMsg(wxUser);
		}
	}

}