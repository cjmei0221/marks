package com.cjmei.module.teacher.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.teacher.pojo.Teacher;
import com.cjmei.module.teacher.dao.TeacherDao;
import com.cjmei.module.teacher.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
   

    private TeacherDao teacherDao;

    public TeacherDao getTeacherDao(){
        return teacherDao;
    }
    public void setTeacherDao(TeacherDao teacherDao){
        this.teacherDao =teacherDao;
    }

    
    /**
    *根据ID查找老师
    */
    @Override
    public Teacher findById(String teacherId){
        return teacherDao.findById(teacherId);
    }
    
    /**
    *保存老师
    */
    @Override
    public void save(Teacher teacher){
        teacherDao.save(teacher);
    }
    
    /**
    *更新老师
    */
    @Override
    public void update(Teacher teacher){
        teacherDao.update(teacher);
    }
    
    /**
    *删除老师
    */
    @Override
    public void delete(String teacherId){
        teacherDao.delete(teacherId);       
    }
    
    /**
    *查找所有老师
    */
    @Override
    public List<Teacher> findAll(){
        return teacherDao.findAll();   
    }
    
    /**
    *删除多个老师
    */
    @Override
   public void deleteBatch(List<String> ids) {
		teacherDao.deleteBatch(ids);
	}
	
	public PojoDomain<Teacher> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Teacher> pojoDomain = new PojoDomain<Teacher>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Teacher> list = teacherDao.list(pageBounds,param);
		PageList<Teacher> pageList = (PageList<Teacher>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}