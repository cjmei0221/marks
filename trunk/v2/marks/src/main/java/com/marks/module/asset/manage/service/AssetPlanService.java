package com.marks.module.asset.manage.service;


import com.marks.module.asset.manage.pojo.AssetPlan;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface AssetPlanService{

	public AssetPlan findById(String planId);
	public void save(AssetPlan info);
	public void update(AssetPlan info);
	public void delete(String id);
	public List<AssetPlan> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AssetPlan> list(int page_number, int page_size,Map<String,Object> param);
}