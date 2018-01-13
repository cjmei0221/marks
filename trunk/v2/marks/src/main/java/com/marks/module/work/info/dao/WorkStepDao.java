package com.marks.module.work.info.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.work.info.pojo.WorkStep;

@MapperScan
public interface WorkStepDao {

	WorkStep findById(@Param("stepId") String stepId);

	void save(@Param("info") WorkStep workStep);
	
	void saveBatch(@Param("list") List<WorkStep> list);

	void update(@Param("info") WorkStep workStep);
	
//	void updateBatch(@Param("list") List<WorkStep> list);

	void delete(@Param("stepId") String stepId);

	List<WorkStep> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<WorkStep> list(PageBounds pageBounds, Map<String,Object> param);
}