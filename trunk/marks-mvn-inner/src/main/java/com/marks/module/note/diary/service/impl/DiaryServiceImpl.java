package com.marks.module.note.diary.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.note.diary.dao.DiaryDao;
import com.marks.module.note.diary.pojo.Diary;
import com.marks.module.note.diary.service.DiaryService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class DiaryServiceImpl implements DiaryService{
   

    private DiaryDao diaryDao;

    public DiaryDao getDiaryDao(){
        return diaryDao;
    }
    public void setDiaryDao(DiaryDao diaryDao){
        this.diaryDao =diaryDao;
    }

    
    /**
    *根据ID查找我的日记
    */
    @Override
    public Diary findById(String ID){
        return diaryDao.findById(ID);
    }
    
    /**
    *保存我的日记
    */
    @Override
    public void save(Diary diary){
        diaryDao.save(diary);
    }
    
    /**
    *更新我的日记
    */
    @Override
    public void update(Diary diary){
        diaryDao.update(diary);
    }
    
    /**
    *删除我的日记
    */
    @Override
    public void delete(String ID){
        diaryDao.delete(ID);       
    }
    
    /**
    *查找所有我的日记
    */
    @Override
    public List<Diary> findAll(){
        return diaryDao.findAll();   
    }
    
    /**
    *删除多个我的日记
    */
    @Override
   public void deleteBatch(List<String> ids) {
		diaryDao.deleteBatch(ids);
	}
	
	public PojoDomain<Diary> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Diary> pojoDomain = new PojoDomain<Diary>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Diary> list = diaryDao.list(pageBounds,param);
		PageList<Diary> pageList = (PageList<Diary>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}