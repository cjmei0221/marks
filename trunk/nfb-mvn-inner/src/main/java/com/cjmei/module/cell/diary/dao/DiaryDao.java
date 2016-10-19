package com.cjmei.module.cell.diary.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.cell.diary.pojo.Diary;

public interface DiaryDao {

	Diary findById(String ID);

	void save(Diary diary);

	void update(Diary diary);

	void delete(String ID);

	List<Diary> findAll();

	void deleteBatch(List<String> list);

	List<Diary> list(PageBounds pageBounds, Map<String,Object> param);
}