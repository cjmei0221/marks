package com.marks.smart.market.mall.report.service;

import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.report.pojo.OrderLog;

public interface OrderLogService{

	PojoDomain<OrderLog> list(int page_number, int page_size, Map<String, Object> param);
	
}