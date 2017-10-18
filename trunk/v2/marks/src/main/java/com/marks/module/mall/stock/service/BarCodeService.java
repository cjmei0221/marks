package com.marks.module.mall.stock.service;


import com.marks.module.mall.stock.pojo.BarCode;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface BarCodeService{

	public BarCode findById(String barcode);
	public void save(BarCode barCode);
	public void update(BarCode barCode);
	public void delete(String barcode);
	public List<BarCode> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<BarCode> list(int page_number, int page_size,Map<String,Object> param);
}