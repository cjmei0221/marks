package com.marks.module.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.stock.pojo.TraceLog;

@MapperScan
public interface TraceLogDao {

	TraceLog findById(@Param("id") String id);

	void save(@Param("info") TraceLog traceLog);
	
	void saveBatch(@Param("list") List<TraceLog> list);

	void update(@Param("info") TraceLog traceLog);

	void delete(@Param("id") String id);

	List<TraceLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<TraceLog> list(PageBounds pageBounds, Map<String,Object> param);
}