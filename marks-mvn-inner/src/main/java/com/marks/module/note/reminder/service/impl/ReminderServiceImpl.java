package com.marks.module.note.reminder.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.date.Lunar;
import com.marks.module.note.reminder.dao.ReminderDao;
import com.marks.module.note.reminder.pojo.Reminder;
import com.marks.module.note.reminder.service.ReminderService;

public class ReminderServiceImpl implements ReminderService {

	private ReminderDao reminderDao;

	public ReminderDao getReminderDao() {
		return reminderDao;
	}

	public void setReminderDao(ReminderDao reminderDao) {
		this.reminderDao = reminderDao;
	}

	/**
	 * 根据ID查找事务提醒
	 */
	@Override
	public Reminder findById(String id) {
		return reminderDao.findById(id);
	}

	/**
	 * 保存事务提醒
	 * @throws Exception 
	 */
	@Override
	public void save(Reminder reminder) throws Exception {
		if (1 == reminder.getCalendar_type()) {
			SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar today = Calendar.getInstance();
			today.setTime(chineseDateFormat.parse(reminder.getRemind_date()));
			Lunar lunar = new Lunar(today);
			reminder.setNoli_date(lunar.toString());
		}
		reminderDao.save(reminder);
	}

	/**
	 * 更新事务提醒
	 */
	@Override
	public void update(Reminder reminder) throws Exception{
		if (1 == reminder.getCalendar_type()) {
			SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar today = Calendar.getInstance();
			today.setTime(chineseDateFormat.parse(reminder.getRemind_date()));
			Lunar lunar = new Lunar(today);
			reminder.setNoli_date(lunar.toString());
		}
		reminderDao.update(reminder);
	}

	/**
	 * 删除事务提醒
	 */
	@Override
	public void delete(String id) {
		reminderDao.delete(id);
	}

	/**
	 * 查找所有事务提醒
	 */
	@Override
	public List<Reminder> findAll() {
		return reminderDao.findAll();
	}

	/**
	 * 删除多个事务提醒
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		reminderDao.deleteBatch(ids);
	}

	public PojoDomain<Reminder> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<Reminder> pojoDomain = new PojoDomain<Reminder>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Reminder> list = reminderDao.list(pageBounds, param);
		PageList<Reminder> pageList = (PageList<Reminder>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

}