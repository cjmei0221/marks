package com.marks.module.mall.dispatch.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.dispatch.pojo.DispatchLog;

@MapperScan
public interface DispatchLogDao {

	DispatchLog findById(@Param("logId") String logId);

	void save(@Param("info") DispatchLog dispatchLog);
	
	void saveBatch(@Param("list") List<DispatchLog> list);

	void update(@Param("info") DispatchLog dispatchLog);
	
//	void updateBatch(@Param("list") List<DispatchLog> list);

	void delete(@Param("logId") String logId);

	List<DispatchLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<DispatchLog> list(PageBounds pageBounds, Map<String,Object> param);
}