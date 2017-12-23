package com.marks.module.work.base.service;


import com.marks.module.work.base.pojo.WorkType;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface WorkTypeService{

	public WorkType findById(String typeId);
	public void save(WorkType info);
	public void update(WorkType info);
	public void delete(String id);
	public List<WorkType> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WorkType> list(int page_number, int page_size,Map<String,Object> param);
}