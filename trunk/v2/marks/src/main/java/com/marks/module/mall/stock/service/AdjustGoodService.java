package com.marks.module.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.stock.pojo.AdjustGood;

public interface AdjustGoodService{

	public AdjustGood findById(String orderGoodId);
	public void save(AdjustGood info);
	public void update(AdjustGood info);
	public void delete(String id);
	public List<AdjustGood> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AdjustGood> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 根据订单号查询商品
	 * 
	 * @param orderId
	 * @return
	 */
	public List<AdjustGood> findByOrderId(String orderId);
}