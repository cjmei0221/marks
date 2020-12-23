package com.marks.smart.market.mall.good.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.pojo.GoodShop;

@MapperScan
public interface GoodShopDao {

	GoodShop findById(@Param("goodShopId") String goodShopId);

	void save(@Param("info") GoodShop goodShop);
	
	void saveBatch(@Param("list") List<GoodShop> list);

	void update(@Param("info") GoodShop goodShop);
	
//	void updateBatch(@Param("list") List<GoodShop> list);

	void delete(@Param("goodShopId") String goodShopId);

	List<GoodShop> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<GoodInfo> list(PageBounds pageBounds, Map<String, Object> param);
}