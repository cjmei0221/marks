package com.cjmei.module.mall.goodinfo.service;


import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;

public interface GoodInfoService{

	public GoodInfo findById(String goodId);
	public PojoDomain<GoodInfo> list(int page_number, int page_size,Map<String,Object> param);
}