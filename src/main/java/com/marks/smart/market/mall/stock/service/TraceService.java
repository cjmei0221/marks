package com.marks.smart.market.mall.stock.service;


import com.marks.smart.market.mall.stock.pojo.Trace;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface TraceService{

	public Trace findById(String traceId);
	public void save(Trace trace);
	public void update(Trace trace);
	public void delete(String traceId);
	public List<Trace> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Trace> list(int page_number, int page_size,Map<String,Object> param);
}