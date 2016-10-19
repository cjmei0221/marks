package com.cjmei.module.cell.diary.service;


import com.cjmei.module.cell.diary.pojo.Diary;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface DiaryService{

	public Diary findById(String ID);
	public void save(Diary diary);
	public void update(Diary diary);
	public void delete(String ID);
	public List<Diary> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Diary> list(int page_number, int page_size,Map<String,Object> param);
}