package com.marks.module.asset.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.asset.base.pojo.AssetLog;
import com.marks.module.asset.base.pojo.AssetLogCount;

@MapperScan
public interface AssetLogDao {

	AssetLog findById(@Param("id") String id);

	void save(@Param("info") AssetLog assetLog);
	
	void saveBatch(@Param("list") List<AssetLog> list);

	void update(@Param("info") AssetLog assetLog);
	
	void updateBatch(@Param("list") List<AssetLog> list);

	void delete(@Param("id") String id);

	List<AssetLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AssetLog> list(PageBounds pageBounds, Map<String,Object> param);

	List<AssetLogCount> listCount(PageBounds pageBounds, Map<String, Object> param);

	List<AssetLogCount> countAmount(Map<String, Object> param);

	List<AssetLogCount> listDayCount(PageBounds pageBounds, Map<String, Object> param);
}