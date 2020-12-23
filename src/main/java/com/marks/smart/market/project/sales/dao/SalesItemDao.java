package com.marks.smart.market.project.sales.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.project.sales.pojo.SalesItem;

@MapperScan
public interface SalesItemDao {

	SalesItem findById(@Param("itemId") String itemId);

	void save(@Param("info") SalesItem salesItem);
	
	void saveBatch(@Param("list") List<SalesItem> list);

	void update(@Param("info") SalesItem salesItem);

	void delete(@Param("itemId") String itemId);

	List<SalesItem> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<SalesItem> list(PageBounds pageBounds, Map<String,Object> param);

	void deleteByProjectCode(@Param("projectCode") String projectCode);

	List<SalesItem> findByProjectCode(@Param("projectCode") String projectCode);
}