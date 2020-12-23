package com.marks.smart.market.fee.log.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.fee.log.pojo.FeeLog;

@MapperScan
public interface FeeLogDao {

	FeeLog findById(@Param("id") String id);

	void save(@Param("info") FeeLog feeLog);
	
	void saveBatch(@Param("list") List<FeeLog> list);

	void update(@Param("info") FeeLog feeLog);
	
//	void updateBatch(@Param("list") List<FeeLog> list);

	void delete(@Param("id") String id);

	List<FeeLog> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<FeeLog> list(PageBounds pageBounds, Map<String,Object> param);
}