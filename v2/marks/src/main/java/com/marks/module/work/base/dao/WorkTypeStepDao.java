package com.marks.module.work.base.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.work.base.pojo.WorkTypeStep;

@MapperScan
public interface WorkTypeStepDao {

	WorkTypeStep findById(@Param("stepId") String stepId);

	void save(@Param("info") WorkTypeStep workTypeStep);
	
	void saveBatch(@Param("list") List<WorkTypeStep> list);

	void update(@Param("info") WorkTypeStep workTypeStep);
	
	void updateBatch(@Param("list") List<WorkTypeStep> list);

	void delete(@Param("stepId") String stepId);

	List<WorkTypeStep> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<WorkTypeStep> list(PageBounds pageBounds, Map<String,Object> param);
}