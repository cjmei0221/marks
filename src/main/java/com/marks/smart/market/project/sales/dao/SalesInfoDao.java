package com.marks.smart.market.project.sales.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.project.sales.pojo.SalesInfo;

@MapperScan
public interface SalesInfoDao {

	SalesInfo findById(@Param("projectCode") String projectCode);

	void save(@Param("info") SalesInfo salesInfo);
	
	void saveBatch(@Param("list") List<SalesInfo> list);

	void update(@Param("info") SalesInfo salesInfo);
	
//	void updateBatch(@Param("list") List<SalesInfo> list);

	void delete(@Param("projectCode") String projectCode);

	List<SalesInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<SalesInfo> list(PageBounds pageBounds, Map<String,Object> param);

	List<SalesInfo> findActiveSalesInfo(Map<String, String> params);
}