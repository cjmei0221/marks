package com.cjmei.module.mall.goodinfo.service;


import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface GoodInfoService{

	public GoodInfo findById(String goodId);
	public void save(GoodInfo goodInfo);
	public void update(GoodInfo goodInfo);
	public void delete(String goodId);
	public List<GoodInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<GoodInfo> list(int page_number, int page_size,Map<String,Object> param);
}