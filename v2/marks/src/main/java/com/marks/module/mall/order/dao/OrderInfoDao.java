package com.marks.module.mall.order.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.order.pojo.OrderInfo;

@MapperScan
public interface OrderInfoDao {

	OrderInfo findById(@Param("orderId") String orderId);

	void save(@Param("info") OrderInfo orderInfo);
	
	void saveBatch(@Param("list") List<OrderInfo> list);

	void update(@Param("info") OrderInfo orderInfo);
	
//	void updateBatch(@Param("list") List<OrderInfo> list);

	void delete(@Param("orderId") String orderId);

	List<OrderInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<OrderInfo> list(PageBounds pageBounds, Map<String,Object> param);
}