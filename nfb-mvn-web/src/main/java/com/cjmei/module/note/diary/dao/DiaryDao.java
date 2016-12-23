package com.cjmei.module.note.diary.dao;


import java.util.List;
import java.util.Map;

import com.cjmei.module.note.diary.pojo.Diary;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface DiaryDao {

	Diary findById(String id);

	void save(Diary diary);

	void update(Diary diary);

	void delete(String id);

	List<Diary> findAll();

	void deleteBatch(List<String> list);

	List<Diary> list(PageBounds pageBounds, Map<String,Object> param);
}