package com.marks.module.mall.order.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.order.pojo.OrderGood;

@MapperScan
public interface OrderGoodDao {

	OrderGood findById(@Param("goodId") String goodId);

	void save(@Param("info") OrderGood orderGood);
	
	void saveBatch(@Param("list") List<OrderGood> list);

	void update(@Param("info") OrderGood orderGood);
	
//	void updateBatch(@Param("list") List<OrderGood> list);

	void delete(@Param("orderGoodId") String orderGoodId);

	List<OrderGood> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<OrderGood> list(PageBounds pageBounds, Map<String,Object> param);
}