package com.marks.smart.market.project.sales.service;


import com.marks.smart.market.project.sales.pojo.SalesDetail;

import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface SalesDetailService{
	public PojoDomain<SalesDetail> list(int page_number, int page_size,Map<String,Object> param);
}