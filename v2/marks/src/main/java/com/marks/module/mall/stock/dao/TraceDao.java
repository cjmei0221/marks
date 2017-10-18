package com.marks.module.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.stock.pojo.Trace;

@MapperScan
public interface TraceDao {

	Trace findById(@Param("traceId") String traceId);

	void save(@Param("info") Trace trace);
	
	void saveBatch(@Param("list") List<Trace> list);

	void update(@Param("info") Trace trace);

	void delete(@Param("traceId") String traceId);

	List<Trace> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<Trace> list(PageBounds pageBounds, Map<String,Object> param);
}