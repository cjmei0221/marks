package com.marks.smart.system.quartz.note.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.count.note.diary.service.DiaryService;
import com.marks.smart.count.note.reminder.pojo.Reminder;
import com.marks.smart.count.note.reminder.service.ReminderService;
import com.marks.smart.wx.api.mp.wxInteface.user.entity.WxUser;

public class NoteThreadPool {

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
	ReminderService reminderService = (ReminderService) SpringContextHolder.getBean(ReminderService.class);

	public RiminderWxMsgThread(Reminder reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		if (reminder != null) {
			try {
				reminderService.pushReminderWxMsg(reminder);
			} catch (Exception e) {
			
			}
		}
	}

}

class DairyWxMsgThread implements Runnable {

	private WxUser wxUser;
	DiaryService diaryService = (DiaryService) SpringContextHolder.getBean(DiaryService.class);

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