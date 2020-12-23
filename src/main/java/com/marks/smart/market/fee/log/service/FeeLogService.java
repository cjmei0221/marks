package com.marks.smart.market.fee.log.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.fee.log.pojo.FeeLog;

public interface FeeLogService{

	public FeeLog findById(String id);
	public void save(FeeLog info);
	public PojoDomain<FeeLog> list(int page_number, int page_size,Map<String,Object> param);

	public void update(FeeLog info);
}