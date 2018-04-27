package com.marks.module.fee.base.service;


import com.marks.module.fee.base.pojo.FeeType;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface FeeTypeService{

	public FeeType findById(String typeId);
	public void save(FeeType info);
	public void update(FeeType info);
	public void delete(String id);
	public List<FeeType> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<FeeType> list(int page_number, int page_size,Map<String,Object> param);
}