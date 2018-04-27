package com.marks.module.fee.base.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.fee.base.pojo.FeeType;

@MapperScan
public interface FeeTypeDao {

	FeeType findById(@Param("typeId") String typeId);

	void save(@Param("info") FeeType feeType);
	
	void saveBatch(@Param("list") List<FeeType> list);

	void update(@Param("info") FeeType feeType);
	
//	void updateBatch(@Param("list") List<FeeType> list);

	void delete(@Param("typeId") String typeId);

	List<FeeType> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<FeeType> list(PageBounds pageBounds, Map<String,Object> param);
}