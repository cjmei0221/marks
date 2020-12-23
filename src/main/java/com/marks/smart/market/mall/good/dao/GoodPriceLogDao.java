package com.marks.smart.market.mall.good.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.good.pojo.GoodPriceLog;

@MapperScan
public interface GoodPriceLogDao {

	GoodPriceLog findById(@Param("id") String id);

	void save(@Param("info") GoodPriceLog goodPriceLog);
	
	void saveBatch(@Param("list") List<GoodPriceLog> list);

	void update(@Param("info") GoodPriceLog goodPriceLog);
	
//	void updateBatch(@Param("list") List<GoodPriceLog> list);

	void delete(@Param("id") String id);

	List<GoodPriceLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<GoodPriceLog> list(PageBounds pageBounds, Map<String,Object> param);
}