package com.marks.module.mall.stock.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.stock.pojo.StockInfo;

public interface StockInfoService{

	public StockInfo findById(String stockId);

	public String save(StockInfo info);

	public String updateSaleOut(StockInfo info);

	public PojoDomain<StockInfo> list(int page_number, int page_size,Map<String,Object> param);
}