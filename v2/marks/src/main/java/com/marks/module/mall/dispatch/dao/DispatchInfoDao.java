package com.marks.module.mall.dispatch.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.dispatch.pojo.DispatchInfo;

@MapperScan
public interface DispatchInfoDao {

	DispatchInfo findById(@Param("orderId") String orderId);

	void save(@Param("info") DispatchInfo dispatchInfo);
	
	void saveBatch(@Param("list") List<DispatchInfo> list);

	void update(@Param("info") DispatchInfo dispatchInfo);
	
//	void updateBatch(@Param("list") List<DispatchInfo> list);

	void delete(@Param("orderId") String orderId);

	List<DispatchInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<DispatchInfo> list(PageBounds pageBounds, Map<String,Object> param);
}