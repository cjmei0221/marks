package com.marks.smart.market.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.stock.pojo.AdjustGood;
import com.marks.smart.market.mall.stock.pojo.AdjustInfo;

public interface AdjustInfoService{

	public AdjustInfo findById(String orderId);

	public void save(AdjustInfo info, List<AdjustGood> goodList);

	public void update(AdjustInfo info, List<AdjustGood> goodList);
	public void delete(String id);
	public List<AdjustInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AdjustInfo> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 审核
	 * 
	 * @param map
	 */
	public void updateCheckStatus(Map<String, String> map);
}