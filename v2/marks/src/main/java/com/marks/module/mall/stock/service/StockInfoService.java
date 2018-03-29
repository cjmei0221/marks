package com.marks.module.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.stock.pojo.StockInfo;

public interface StockInfoService{

	public StockInfo findById(String stockId);

	public String save(StockInfo info);
	public void update(StockInfo info);
	public void delete(String id);
	public List<StockInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<StockInfo> list(int page_number, int page_size,Map<String,Object> param);
}