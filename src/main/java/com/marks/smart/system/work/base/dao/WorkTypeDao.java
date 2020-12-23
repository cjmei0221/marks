package com.marks.smart.system.work.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.work.base.pojo.WorkType;

@MapperScan
public interface WorkTypeDao {

	WorkType findById(@Param("typeId") String typeId);

	void save(@Param("info") WorkType workType);
	
	void saveBatch(@Param("list") List<WorkType> list);

	void update(@Param("info") WorkType workType);

	void delete(@Param("typeId") String typeId);

	List<WorkType> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<WorkType> list(PageBounds pageBounds, Map<String,Object> param);
}