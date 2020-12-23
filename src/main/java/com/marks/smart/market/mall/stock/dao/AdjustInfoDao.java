package com.marks.smart.market.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.stock.pojo.AdjustInfo;

@MapperScan
public interface AdjustInfoDao {

	AdjustInfo findById(@Param("orderId") String orderId);

	void save(@Param("info") AdjustInfo adjustInfo);
	
	void saveBatch(@Param("list") List<AdjustInfo> list);

	void update(@Param("info") AdjustInfo adjustInfo);
	
//	void updateBatch(@Param("list") List<AdjustInfo> list);

	void delete(@Param("orderId") String orderId);

	List<AdjustInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AdjustInfo> list(PageBounds pageBounds, Map<String,Object> param);

	void updateCheckStatus(Map<String, String> map);
}