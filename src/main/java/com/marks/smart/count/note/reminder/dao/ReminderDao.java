package com.marks.smart.count.note.reminder.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.count.note.reminder.pojo.Reminder;
@MapperScan
public interface ReminderDao {

	Reminder findById(String id);

	void save(Reminder reminder);

	void update(Reminder reminder);

	void delete(String id);

	List<Reminder> findAll();

	void deleteBatch(List<String> list);

	List<Reminder> list(PageBounds pageBounds, Map<String,Object> param);

	List<Reminder> findNeedReminderList(@Param("noliMMDD")String noliMMDD,@Param("yangliMMDD")String yangliMMDD,@Param("yearStr")String yearStr);
}