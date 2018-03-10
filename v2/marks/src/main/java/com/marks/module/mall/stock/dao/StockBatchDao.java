package com.marks.module.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.mall.stock.pojo.StockBatch;

@MapperScan
public interface StockBatchDao {

	StockBatch findById(@Param("batchId") String batchId);

	void save(@Param("info") StockBatch stockBatch);
	
	void saveBatch(@Param("list") List<StockBatch> list);

	void update(@Param("info") StockBatch stockBatch);
	
	void updateBatch(@Param("list") List<StockBatch> list);

	void delete(@Param("batchId") String batchId);

	List<StockBatch> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<StockBatch> list(PageBounds pageBounds, Map<String,Object> param);

	List<StockBatch> getStockBatchByGoodIdAndOrgId(@Param("orgId") String orgId, @Param("goodId") String goodId);

	List<StockBatch> getStockBatchByBarCodeList(@Param("list") List<String> barCodeList);
}