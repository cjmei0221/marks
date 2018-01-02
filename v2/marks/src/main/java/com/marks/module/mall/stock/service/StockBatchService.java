package com.marks.module.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.mall.stock.pojo.BarCodeForm;
import com.marks.module.mall.stock.pojo.StockBatch;

public interface StockBatchService{

	public StockBatch findById(String batchId);
	public void save(StockBatch info);
	public void update(StockBatch info);
	public void delete(String id);
	public List<StockBatch> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<StockBatch> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 首次入库
	 * 
	 * @param reqVo
	 * @return
	 */
	public Result saveFirstStockIn(BarCodeForm reqVo) throws Exception;
}