package com.marks.module.inner.note.plan.service;


import com.marks.module.inner.note.plan.pojo.Plan;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface PlanService{

	public Plan findById(String id);
	public void save(Plan plan);
	public void update(Plan plan);
	public void delete(String id);
	public List<Plan> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Plan> list(int page_number, int page_size,Map<String,Object> param);
}