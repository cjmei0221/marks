package com.marks.module.mall.dispatch.service;


import com.marks.module.mall.dispatch.pojo.DispatchLog;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface DispatchLogService{

	public DispatchLog findById(String logId);
	public void save(DispatchLog info);
	public void update(DispatchLog info);
	public void delete(String id);
	public List<DispatchLog> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<DispatchLog> list(int page_number, int page_size,Map<String,Object> param);
}