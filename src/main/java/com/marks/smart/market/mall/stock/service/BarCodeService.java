package com.marks.smart.market.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.stock.pojo.BarCode;
import com.marks.smart.market.mall.stock.pojo.StockBatch;

public interface BarCodeService{

	public BarCode findById(String barcode);
	public void update(BarCode barCode);
	public void delete(String barcode);
	public List<BarCode> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<BarCode> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 首次入库
	 * 
	 * @param info
	 * @param good
	 * @return
	 * @throws Exception
	 */
	public Result saveBarCode(StockBatch info, GoodInfo good);

	public List<BarCode> getBarCodeListByBarCodes(List<String> barCodeList);

	/**
	 * 条码更新出库
	 * 
	 * @param barCodeList
	 * @param value
	 */
	public void updateBarCodeStockOut(List<BarCode> barCodeList);
}