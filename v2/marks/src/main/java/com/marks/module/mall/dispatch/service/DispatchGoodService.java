package com.marks.module.mall.dispatch.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.dispatch.pojo.DispatchGood;

public interface DispatchGoodService{

	public DispatchGood findById(String orderGoodId);
	public void save(DispatchGood info);
	public void update(DispatchGood info);
	public void delete(String id);
	public List<DispatchGood> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<DispatchGood> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 查询订单商品
	 * 
	 * @param orderId
	 * @return
	 */
	public List<DispatchGood> findByOrderId(String orderId);
}