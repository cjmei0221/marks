package com.marks.module.mall.order.service;


import com.marks.module.mall.order.pojo.OrderGood;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface OrderGoodService{

	public OrderGood findById(String orderGoodId);
	public void save(OrderGood info);
	public void update(OrderGood info);
	public void delete(String id);
	public List<OrderGood> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<OrderGood> list(int page_number, int page_size,Map<String,Object> param);
}