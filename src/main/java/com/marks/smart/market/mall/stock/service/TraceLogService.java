package com.marks.smart.market.mall.stock.service;


import com.marks.smart.market.mall.stock.pojo.TraceLog;

import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface TraceLogService{

	
	public PojoDomain<TraceLog> list(int page_number, int page_size,Map<String,Object> param);
}