package com.marks.module.inner.mall.goodinfo.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.mall.goodinfo.pojo.GoodImg;
import com.marks.module.inner.mall.goodinfo.pojo.GoodInfo;

@MapperScan
public interface GoodInfoDao {

	GoodInfo findById(String goodId);

	void save(GoodInfo goodInfo);

	void update(GoodInfo goodInfo);

	void delete(String goodId);

	List<GoodInfo> findAll();

	void deleteBatch(List<String> list);

	List<GoodInfo> list(PageBounds pageBounds, Map<String,Object> param);

	GoodInfo getGoodInfoBySkuNum(@Param("orgid") String orgid,@Param("sku_num")String sku_num);

	void saveGoodImg(GoodImg img);

	void deleteGoodImg(@Param("goodId")String goodId);
	
	List<GoodImg> getGoodImgByGoodId(@Param("goodId") String goodId);

	void onSale(@Param("goodId")String goodId, @Param("state")int state);
}