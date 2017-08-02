package com.marks.module.inner.note.reminder.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.util.date.Lunar;
import com.marks.module.inner.note.diary.service.impl.DiaryServiceImpl;
import com.marks.module.inner.note.reminder.dao.ReminderDao;
import com.marks.module.inner.note.reminder.pojo.Reminder;
import com.marks.module.inner.note.reminder.service.ReminderService;
import com.marks.module.inner.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.inner.wx.modulemsg.pojo.WxMsg;
import com.marks.module.inner.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.inner.wx.modulemsg.util.WxMsgUtil;
import com.marks.module.inner.wx.wxtemplate.dao.WxTemplateDao;
import com.marks.module.inner.wx.wxtemplate.pojo.WxTemplate;

public class ReminderServiceImpl implements ReminderService {
	private static Logger logger = Logger.getLogger(DiaryServiceImpl.class);
	private ReminderDao reminderDao;
	private WxTemplateDao wxTemplateDao;
	private ModuleMsgService moduleMsgService;

	public WxTemplateDao getWxTemplateDao() {
		return wxTemplateDao;
	}

	public void setWxTemplateDao(WxTemplateDao wxTemplateDao) {
		this.wxTemplateDao = wxTemplateDao;
	}

	public ModuleMsgService getModuleMsgService() {
		return moduleMsgService;
	}

	public void setModuleMsgService(ModuleMsgService moduleMsgService) {
		this.moduleMsgService = moduleMsgService;
	}

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

	@Override
	public void pushReminderWxMsg(Reminder reminder) throws Exception {
		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd"); Calendar
		 * today = Calendar.getInstance(); Lunar lunar = new Lunar(today);
		 * String noliMMDD = lunar.toMMDD(); String yangliMMDD =
		 * dateFormat.format(today);
		 */
		// 普通提示
		if (reminder.getRemind_type() == 0) {
			reminder.setNeedFlag(0);
			pushModuleMsgByParams(reminder, "wxtemplate_reminder_normal");
			reminderDao.update(reminder);
			return;
		}

		// 特殊节日 农历
		if (reminder.getHoliday_type() == 1) {
			// 生日
			pushModuleMsgByParams(reminder, "wxtemplate_reminder_birthday");
			return;
		}
		pushModuleMsgByParams(reminder, "wxtemplate_reminder_holiday");

		if (reminder.getIs_repeat() == 0) {
			reminder.setNeedFlag(0);
			reminderDao.update(reminder);
		}
		return;
	}

	public Result pushModuleMsgByParams(Reminder reminder, String templateId) {

		Result result = new Result();

		List<String> keywordList = new ArrayList<String>();
		keywordList.add(reminder.getRemind_content());
		if (reminder.getCalendar_type() == 1) {
			keywordList.add("(农历)" + reminder.getRemind_date());
		} else {
			keywordList.add(reminder.getRemind_date());
		}
		List<String> openidList = new ArrayList<String>();
		openidList.add(reminder.getOpenid());
		WxMsgUtil.getInstance().pushModuleMsgByKeywordList(false,reminder.getAccountid(), templateId, openidList, keywordList,
				reminder.getNickname(),null);
		return result;
	}

	/**
	 * 保存事务提醒
	 * 
	 * @throws Exception
	 */
	@Override
	public void save(Reminder reminder) throws Exception {
		if (1 == reminder.getCalendar_type()) {
			SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar today = Calendar.getInstance();
			today.setTime(chineseDateFormat.parse(reminder.getRemind_date()));
			Lunar lunar = new Lunar(today);
			// reminder.setNoli_date(lunar.toString());
		}
		reminderDao.save(reminder);
	}

	/**
	 * 更新事务提醒
	 */
	@Override
	public void update(Reminder reminder) throws Exception {
		if (1 == reminder.getCalendar_type()) {
			SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar today = Calendar.getInstance();
			today.setTime(chineseDateFormat.parse(reminder.getRemind_date()));
			Lunar lunar = new Lunar(today);
			// reminder.setNoli_date(lunar.toString());
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