package com.marks.module.work.base.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.work.base.pojo.WorkTypeStep;

public interface WorkTypeStepService{

	public WorkTypeStep findById(String stepId);
	public void save(WorkTypeStep info);
	public void update(WorkTypeStep info);
	public void delete(String id);
	public List<WorkTypeStep> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WorkTypeStep> list(int page_number, int page_size,Map<String,Object> param);

	public void saveStep(String typeId, String status, String listArr);
}