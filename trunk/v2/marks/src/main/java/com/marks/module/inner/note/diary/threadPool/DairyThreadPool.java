package com.marks.module.inner.note.diary.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.module.inner.note.diary.service.DiaryService;
import com.marks.module.inner.note.reminder.pojo.Reminder;
import com.marks.module.inner.note.reminder.service.ReminderService;
import com.marks.module.inner.wx.wxuser.pojo.WxUser;
import com.marks.module.sys.system.core.listener.DatabaseHelper;

public class DairyThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(200);// 开10个线程
	}

	public static void destroy() {
		pool.shutdown();
	}

	public static void pushDairyWxMsg(WxUser wxUser) {
		pool.execute(new DairyWxMsgThread(wxUser));
	}

	public static void pushRiminderWxMsg(Reminder reminder) {
		pool.execute(new RiminderWxMsgThread(reminder));
	}

}
class RiminderWxMsgThread implements Runnable {

	private Reminder reminder;
	ReminderService diaryService = (ReminderService) DatabaseHelper.getBean(ReminderService.class);

	public RiminderWxMsgThread(Reminder reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		if (reminder != null) {
			try {
				diaryService.pushReminderWxMsg(reminder);
			} catch (Exception e) {
			
			}
		}
	}

}

class DairyWxMsgThread implements Runnable {

	private WxUser wxUser;
	DiaryService diaryService = (DiaryService) DatabaseHelper.getBean(DiaryService.class);

	public DairyWxMsgThread(WxUser wxUser) {
		this.wxUser = wxUser;
	}

	@Override
	public void run() {
		if (wxUser != null) {
			diaryService.pushDairyWxMsg(wxUser);
		}
	}

}