package com.marks.module.mall.base.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.base.pojo.Brand;

@MapperScan
public interface BrandDao {

	Brand findById(@Param("brandId") String brandId);

	void save(@Param("info") Brand brand);
	
	void saveBatch(@Param("list") List<Brand> list);

	void update(@Param("info") Brand brand);

	void delete(@Param("brandId") String brandId);

	List<Brand> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<Brand> list(PageBounds pageBounds, Map<String,Object> param);
}