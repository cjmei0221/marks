package com.cjmei.module.teacher.service;


import com.cjmei.module.teacher.pojo.Teacher;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface TeacherService{

	public Teacher findById(String teacherId);
	public void save(Teacher teacher);
	public void update(Teacher teacher);
	public void delete(String teacherId);
	public List<Teacher> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Teacher> list(int page_number, int page_size,Map<String,Object> param);
}