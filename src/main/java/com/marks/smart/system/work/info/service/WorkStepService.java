package com.marks.smart.system.work.info.service;


import com.marks.smart.system.work.info.pojo.WorkStep;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface WorkStepService{

	public WorkStep findById(String stepId);
	public void save(WorkStep info);
	public void update(WorkStep info);
	public void delete(String id);
	public List<WorkStep> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WorkStep> list(int page_number, int page_size,Map<String,Object> param);
}