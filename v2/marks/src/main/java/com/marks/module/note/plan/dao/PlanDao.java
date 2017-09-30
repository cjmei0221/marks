package com.marks.module.note.plan.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.note.plan.pojo.Plan;

@MapperScan
public interface PlanDao {

	Plan findById(@Param("id") String id);

	void save(Plan plan);

	void update(Plan plan);

	void delete(@Param("id") String id);

	List<Plan> findAll();

	void deleteBatch(List<String> list);

	List<Plan> list(PageBounds pageBounds, Map<String,Object> param);
}