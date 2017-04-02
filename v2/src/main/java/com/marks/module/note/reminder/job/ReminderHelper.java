package com.marks.module.note.reminder.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.common.util.date.Lunar;
import com.marks.module.note.diary.threadPool.DairyThreadPool;
import com.marks.module.note.reminder.dao.ReminderDao;
import com.marks.module.note.reminder.pojo.Reminder;
import com.marks.module.system.core.listener.DatabaseHelper;

public class ReminderHelper extends QuartzJobBean {

	public void doJob() {
		ReminderDao reminderDao = (ReminderDao) DatabaseHelper.getBean(ReminderDao.class);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		Calendar today = Calendar.getInstance();
		Lunar lunar = new Lunar(today);
		String noliMMDD=lunar.toMMDD();
		String yangliMMDD=dateFormat.format(today.getTime());
		dateFormat = new SimpleDateFormat("yyyy");
		String yearStr=dateFormat.format(today.getTime());
		List<Reminder> list = reminderDao.findNeedReminderList(noliMMDD,yangliMMDD,yearStr);
		if (null != list && list.size() > 0) {
			for (Reminder Reminder : list) {
				DairyThreadPool.pushRiminderWxMsg(Reminder);
			}
		}

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}

}

