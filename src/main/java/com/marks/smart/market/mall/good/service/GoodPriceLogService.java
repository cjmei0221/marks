package com.marks.smart.market.mall.good.service;


import com.marks.smart.market.mall.good.pojo.GoodPriceLog;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface GoodPriceLogService{

	public GoodPriceLog findById(String id);
	public void save(GoodPriceLog info);
	public void update(GoodPriceLog info);
	public void delete(String id);
	public List<GoodPriceLog> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<GoodPriceLog> list(int page_number, int page_size,Map<String,Object> param);
}