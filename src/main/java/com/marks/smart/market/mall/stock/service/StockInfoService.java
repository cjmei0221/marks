package com.marks.smart.market.mall.stock.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.stock.pojo.StockInfo;

public interface StockInfoService{

	public StockInfo findById(String stockId);

	public StockInfo save(StockInfo info);

	public StockInfo updateSaleOut(StockInfo info);

	public PojoDomain<StockInfo> list(int page_number, int page_size,Map<String,Object> param);

	public StockInfo findByOrgIdAndGoodNo(String companyId, String orgId, String goodNo);
}