package com.cjmei.module.mall.goodinfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.mall.goodinfo.pojo.GoodImg;
import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface GoodInfoDao {

	GoodInfo findById(String goodId);

	void save(GoodInfo goodInfo);

	void update(GoodInfo goodInfo);

	void delete(String goodId);

	List<GoodInfo> findAll();

	void deleteBatch(List<String> list);

	List<GoodInfo> list(PageBounds pageBounds, Map<String,Object> param);

	GoodInfo getGoodInfoBySkuNum(@Param("sku_num")String sku_num);

	void saveGoodImg(GoodImg img);

	void deleteGoodImg(@Param("goodId")String goodId);
	
	List<GoodImg> getGoodImgByGoodId(@Param("goodId") String goodId);

	void onSale(@Param("goodId")String goodId, @Param("state")int state);
}