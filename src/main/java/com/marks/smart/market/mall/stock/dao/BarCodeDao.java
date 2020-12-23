package com.marks.smart.market.mall.stock.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.stock.pojo.BarCode;

@MapperScan
public interface BarCodeDao {

	BarCode findById(@Param("barcode") String barcode);

	void save(@Param("info") BarCode barCode);
	
	void saveBatch(@Param("list") List<BarCode> list);

	void update(@Param("info") BarCode barCode);

	void delete(@Param("barcode") String barcode);

	List<BarCode> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<BarCode> list(PageBounds pageBounds, Map<String,Object> param);

	String getMaxCode();

	List<String> getInvalidCode();

	/**
	 * 获取条码集合
	 * 
	 * @param codelist
	 */
	List<BarCode> getBarCodeListByBarCodes(@Param("list") List<String> barCodeList);
}