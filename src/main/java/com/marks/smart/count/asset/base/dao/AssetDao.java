package com.marks.smart.count.asset.base.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.count.asset.base.pojo.Asset;

@MapperScan
public interface AssetDao {

	Asset findById(@Param("idNo") String idNo);

	void save(@Param("info") Asset asset);
	
	void saveBatch(@Param("list") List<Asset> list);

	void update(@Param("info") Asset asset);
	
	void updateBatch(@Param("list") List<Asset> list);

	void delete(@Param("idNo") String idNo);

	List<Asset> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<Asset> list(PageBounds pageBounds, Map<String,Object> param);
}