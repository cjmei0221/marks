package com.marks.module.mall.stock.service;


import com.marks.module.mall.stock.pojo.StockBatch;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface StockBatchService{

	public StockBatch findById(String batchId);
	public void save(StockBatch info);
	public void update(StockBatch info);
	public void delete(String id);
	public List<StockBatch> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<StockBatch> list(int page_number, int page_size,Map<String,Object> param);
}