package com.marks.smart.market.mall.good.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.good.pojo.GoodImg;
import com.marks.smart.market.mall.good.pojo.GoodInfo;

@MapperScan
public interface GoodInfoDao {

	GoodInfo findById(String goodId);

	void save(GoodInfo goodInfo);

	void update(GoodInfo goodInfo);

	void delete(String goodId);

	List<GoodInfo> findAll();

	void deleteBatch(List<String> list);

	List<GoodInfo> list(PageBounds pageBounds, Map<String,Object> param);

	GoodInfo getGoodInfoByGoodNo(@Param("companyId") String companyId, @Param("goodNo") String sku_num,
			@Param("helpCode") String helpCode);

	void saveGoodImg(GoodImg img);

	void deleteGoodImg(@Param("goodId")String goodId);
	
	List<GoodImg> getGoodImgByGoodId(@Param("goodId") String goodId);

	void onSale(@Param("goodId")String goodId, @Param("state")int state);

	/**
	 * 通过类型查询商品
	 * 
	 * @param typeId
	 * @return
	 */
	List<GoodInfo> listGoodByTypeId(@Param("typeId") String typeId);

	/**
	 * 通过品牌查询商品
	 * 
	 * @param typeId
	 * @return
	 */
	List<GoodInfo> listGoodByBrandId(@Param("brandId") String brandId);

	String getGoodNo(@Param("companyId") String companyId);

	List<GoodInfo> getGoodInfoByLike(@Param("companyId") String companyId, @Param("goodNo") String goodNo);
}