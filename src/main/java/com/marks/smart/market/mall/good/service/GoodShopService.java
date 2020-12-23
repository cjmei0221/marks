package com.marks.smart.market.mall.good.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.pojo.GoodShop;

public interface GoodShopService{

	public GoodShop findById(String goodShopId);
	public void update(GoodShop info);

	public void delete(String id);
	public List<GoodShop> findAll();

	public PojoDomain<GoodInfo> list(int page_number, int page_size, Map<String, Object> param);

	public void save(GoodShop info);
	/**
	 * 查询商品
	 * @param goodNo
	 * @return
	 */
	public GoodShop findGoodShopByGoodNo(String companyId,String goodNo,String shopId);
	

	public GoodInfo findGoodInfoByGoodNo(String companyId,String goodNo,String shopId);
}