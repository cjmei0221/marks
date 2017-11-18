package com.marks.module.mall.base.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.base.pojo.GoodTag;

@MapperScan
public interface GoodTagDao {

	GoodTag findById(@Param("tagId") String tagId);

	void save(@Param("info") GoodTag goodTag);
	
	void saveBatch(@Param("list") List<GoodTag> list);

	void update(@Param("info") GoodTag goodTag);
	
	void updateBatch(@Param("list") List<GoodTag> list);

	void delete(@Param("tagId") String tagId);

	List<GoodTag> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<GoodTag> list(PageBounds pageBounds, Map<String,Object> param);
}