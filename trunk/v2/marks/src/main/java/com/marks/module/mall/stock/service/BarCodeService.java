package com.marks.module.mall.stock.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.BarCodeForm;

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
	public Result saveBarCode(BarCodeForm info, GoodInfo good) throws Exception;

	public List<BarCode> getBarCodeListByBarCodes(List<String> barCodeList);

	/**
	 * 条码更新出库
	 * 
	 * @param barCodeList
	 * @param value
	 */
	public void updateBarCodeStockOut(List<BarCode> barCodeList);
}