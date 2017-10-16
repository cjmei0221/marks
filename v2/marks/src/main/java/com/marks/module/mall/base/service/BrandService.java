package com.marks.module.mall.base.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.base.pojo.Brand;

public interface BrandService{

	public Brand findById(String brandId);
	public void save(Brand brand);
	public void update(Brand brand);
	public void delete(String brandId);
	public List<Brand> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Brand> list(int page_number, int page_size,Map<String,Object> param);

	public List<Brand> findListByTypeId(String companyId, String typeId);
}