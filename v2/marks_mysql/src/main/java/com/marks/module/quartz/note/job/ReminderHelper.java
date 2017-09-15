package com.marks.module.quartz.note.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.common.util.date.Lunar;
import com.marks.module.inner.note.reminder.dao.ReminderDao;
import com.marks.module.inner.note.reminder.pojo.Reminder;
import com.marks.module.quartz.note.thread.pool.NoteThreadPool;
import com.marks.module.sys.common.SpringContextHolder;

public class ReminderHelper extends QuartzJobBean {

	public void doJob() {
		ReminderDao reminderDao = (ReminderDao) SpringContextHolder.getBean(ReminderDao.class);
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
				NoteThreadPool.pushRiminderWxMsg(Reminder);
			}
		}

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}

}

