package com.marks.module.note.plan.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.note.plan.pojo.Plan;

public interface PlanService{

	public Plan findById(String id);
	public void save(Plan plan);
	public void update(Plan plan);
	public void delete(String id);
	public List<Plan> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Plan> list(int page_number, int page_size,Map<String,Object> param);
}