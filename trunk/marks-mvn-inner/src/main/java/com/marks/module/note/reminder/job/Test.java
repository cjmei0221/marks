package com.marks.module.note.reminder.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.marks.common.util.date.Lunar;
import com.marks.module.note.reminder.dao.ReminderDao;
import com.marks.module.note.reminder.pojo.Reminder;
import com.marks.module.system.core.listener.DatabaseHelper;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		Calendar today = Calendar.getInstance();
		Lunar lunar = new Lunar(today);
		String noliMMDD=lunar.toMMDD();
		String yangliMMDD=dateFormat.format(today.getTime());
		dateFormat = new SimpleDateFormat("yyyy");
		String yearStr=dateFormat.format(today.getTime());
//		System.out.println(noliMMDD+"-"+yangliMMDD+"-"+yearStr);
		ClassPathXmlApplicationContext context = new
				  ClassPathXmlApplicationContext(
				 "classpath:config/spring/applicationContext.xml");
				DatabaseHelper.init(context);
				ReminderDao reminderDao = (ReminderDao) DatabaseHelper.getBean(ReminderDao.class);
		List<Reminder> list = reminderDao.findNeedReminderList(noliMMDD,yangliMMDD,yearStr);
		System.out.println(list.size());
	}
}
