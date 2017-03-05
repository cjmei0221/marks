package com.marks.module.note.reminder.service;


import com.marks.module.note.reminder.pojo.Reminder;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface ReminderService{

	public Reminder findById(String id);
	public void save(Reminder reminder);
	public void update(Reminder reminder);
	public void delete(String id);
	public List<Reminder> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Reminder> list(int page_number, int page_size,Map<String,Object> param);
}