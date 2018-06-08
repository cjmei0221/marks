package com.marks.module.mall.dispatch.service;


import com.marks.module.mall.dispatch.pojo.DispatchInfo;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface DispatchInfoService{

	public DispatchInfo findById(String orderId);
	public void save(DispatchInfo info);
	public void update(DispatchInfo info);
	public void delete(String id);
	public List<DispatchInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<DispatchInfo> list(int page_number, int page_size,Map<String,Object> param);
}