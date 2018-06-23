package com.marks.module.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.stock.pojo.AdjustGood;

@MapperScan
public interface AdjustGoodDao {

	AdjustGood findById(@Param("orderGoodId") String orderGoodId);

	void save(@Param("info") AdjustGood adjustGood);
	
	void saveBatch(@Param("list") List<AdjustGood> list);

	void update(@Param("info") AdjustGood adjustGood);
	
//	void updateBatch(@Param("list") List<AdjustGood> list);

	void delete(@Param("orderGoodId") String orderGoodId);

	List<AdjustGood> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<AdjustGood> list(PageBounds pageBounds, Map<String,Object> param);

	List<AdjustGood> findByOrderId(@Param("orderId") String orderId);

	void deleteByOrderId(@Param("orderId") String orderId);
}