package com.marks.module.mall.good.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.good.pojo.GoodImg;
import com.marks.module.mall.good.pojo.GoodInfo;

public interface GoodInfoService{

	public GoodInfo findById(String goodId);
	public void save(GoodInfo goodInfo,String addMainImagePut,String addDetailImagePut);
	public void update(GoodInfo goodInfo,String addMainImagePut,String addDetailImagePut);
	public void delete(String goodId);
	public List<GoodInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<GoodInfo> list(int page_number, int page_size,Map<String,Object> param);

	public GoodInfo getGoodInfoByGoodNo(String companyId, String goodNo, String helpCode);
	public List<GoodImg> findGoodImgByGoodId(String goodId);

	public void updateStatus(String goodId, int value);

	public List<GoodInfo> listGoodByTypeId(String typeId);

	/**
	 * 查询品牌下的商品
	 * 
	 * @param typeId
	 * @return
	 */
	public List<GoodInfo> listGoodByBrandId(String brandId);

	/**
	 * 获取商品自编码
	 * 
	 * @return
	 */
	public String getGoodNo(String companyId);

	public GoodInfo getGoodInfoByLike(String companyId, String goodNo);
}