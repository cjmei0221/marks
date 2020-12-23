package com.marks.smart.market.project.sales.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.project.sales.pojo.SalesDetail;

@MapperScan
public interface SalesDetailDao {

	SalesDetail findById(@Param("id") String id);

	void save(@Param("info") SalesDetail salesDetail);
	
	void saveBatch(@Param("list") List<SalesDetail> list);

	void update(@Param("info") SalesDetail salesDetail);
	
//	void updateBatch(@Param("list") List<SalesDetail> list);

	void delete(@Param("id") String id);

	List<SalesDetail> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<SalesDetail> list(PageBounds pageBounds, Map<String,Object> param);
}