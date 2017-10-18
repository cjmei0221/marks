package com.marks.module.mall.stock.service;


import com.marks.module.mall.stock.pojo.TraceLog;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface TraceLogService{

	public TraceLog findById(String id);
	public void save(TraceLog traceLog);
	public void update(TraceLog traceLog);
	public void delete(String id);
	public List<TraceLog> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<TraceLog> list(int page_number, int page_size,Map<String,Object> param);
}