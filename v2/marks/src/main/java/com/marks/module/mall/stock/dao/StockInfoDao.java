package com.marks.module.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.stock.pojo.StockInfo;

@MapperScan
public interface StockInfoDao {

	StockInfo findById(@Param("stockId") String stockId);

	void save(@Param("info") StockInfo stockInfo);
	
	void saveBatch(@Param("list") List<StockInfo> list);

	void update(@Param("info") StockInfo stockInfo);
	
	void updateBatch(@Param("list") List<StockInfo> list);

	void delete(@Param("stockId") String stockId);

	List<StockInfo> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<StockInfo> list(PageBounds pageBounds, Map<String,Object> param);

	StockInfo findByOrgIdAndGoodNo(@Param("companyId") String companyId, @Param("orgId") String orgId,
			@Param("goodNo") String goodNo);
}