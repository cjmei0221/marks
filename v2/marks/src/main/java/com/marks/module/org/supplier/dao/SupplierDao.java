package com.marks.module.org.supplier.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.org.supplier.pojo.Supplier;

@MapperScan
public interface SupplierDao {

	Supplier findById(@Param("orgid") String orgid);

	void save(@Param("info") Supplier supplier);
	
	void saveBatch(@Param("list") List<Supplier> list);

	void update(@Param("info") Supplier supplier);

	void delete(@Param("orgid") String orgid);

	List<Supplier> findAll(@Param("companyId") String companyId);

	void deleteBatch(@Param("list") List<String> list);

	List<Supplier> list(PageBounds pageBounds, Map<String,Object> param);
}