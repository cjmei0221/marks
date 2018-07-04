package com.marks.module.mall.order.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.order.pojo.OrderGood;

public interface OrderGoodService{

	public OrderGood findById(String companyId, String id);
	public void save(OrderGood info);
	public void update(OrderGood info);
	public void delete(String id);
	public List<OrderGood> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<OrderGood> list(int page_number, int page_size,Map<String,Object> param);

	public List<OrderGood> findByOrderId(String orderId);
}