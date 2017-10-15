package com.marks.module.mall.base.service;


import com.marks.module.mall.base.pojo.Brand;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface BrandService{

	public Brand findById(String brandId);
	public void save(Brand brand);
	public void update(Brand brand);
	public void delete(String brandId);
	public List<Brand> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Brand> list(int page_number, int page_size,Map<String,Object> param);
}