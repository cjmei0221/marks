package com.cjmei.module.teacher.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.teacher.pojo.Teacher;

public interface TeacherDao {

	Teacher findById(String teacherId);

	void save(Teacher teacher);

	void update(Teacher teacher);

	void delete(String teacherId);

	List<Teacher> findAll();

	void deleteBatch(List<String> list);

	List<Teacher> list(PageBounds pageBounds, Map<String,Object> param);
}