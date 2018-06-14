package com.marks.module.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.pojo.OrderInfo;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.BarCodeForm;
import com.marks.module.mall.stock.pojo.StockBatch;

public interface StockBatchService{

	public StockBatch findById(String batchId);

	public PojoDomain<StockBatch> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 首次入库
	 * 
	 * @param reqVo
	 * @return
	 */
	public Result saveFirstStockIn(BarCodeForm reqVo) throws Exception;

	/**
	 * 获取批次和进货价，进货金额
	 * 
	 * @param goodId
	 * @param nums
	 * @return
	 */
	public List<StockBatch> getStockBatchByGood(OrderInfo order, OrderGood good);

	/**
	 * 保存售出
	 * 
	 * @param stockList
	 */
	public void updateSaleOut(List<StockBatch> stockList, List<BarCode> barCodeList);
}