package com.marks.smart.count.asset.manage.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.count.asset.manage.pojo.AssetPlan;

@MapperScan
public interface AssetPlanDao {

	AssetPlan findById(@Param("planId") String planId);

	void save(@Param("info") AssetPlan assetPlan);
	
	void saveBatch(@Param("list") List<AssetPlan> list);

	void update(@Param("info") AssetPlan assetPlan);
	
	void updateBatch(@Param("list") List<AssetPlan> list);

	void delete(@Param("planId") String planId);

	List<AssetPlan> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AssetPlan> list(PageBounds pageBounds, Map<String,Object> param);
}