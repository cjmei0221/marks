package com.marks.module.org.supplier.service;


import com.marks.module.org.supplier.pojo.Supplier;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface SupplierService{

	public Supplier findById(String orgid);
	public void save(Supplier supplier);
	public void update(Supplier supplier);
	public void delete(String orgid);
	public List<Supplier> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Supplier> list(int page_number, int page_size,Map<String,Object> param);
}