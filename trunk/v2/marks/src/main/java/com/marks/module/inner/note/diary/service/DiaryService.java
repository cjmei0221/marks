package com.marks.module.inner.note.diary.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.inner.note.diary.pojo.Diary;
import com.marks.module.inner.wx.wxuser.pojo.WxUser;

public interface DiaryService{

	public Diary findById(String ID);
	public void save(Diary diary);
	public void update(Diary diary);
	public void delete(String ID);
	public List<Diary> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Diary> list(int page_number, int page_size,Map<String,Object> param);
	
	public void pushDairyWxMsg(WxUser wxUser);
}