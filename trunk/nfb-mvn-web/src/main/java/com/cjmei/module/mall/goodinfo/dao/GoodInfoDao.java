package com.cjmei.module.mall.goodinfo.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;

public interface GoodInfoDao {

	GoodInfo findById(String goodId);

	List<GoodInfo> list(PageBounds pageBounds, Map<String,Object> param);
}