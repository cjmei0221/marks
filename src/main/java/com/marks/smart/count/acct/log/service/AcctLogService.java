package com.marks.smart.count.acct.log.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.count.acct.log.pojo.AcctLog;

public interface AcctLogService{

	public AcctLog findById(String id);
	public PojoDomain<AcctLog> list(int page_number, int page_size,Map<String,Object> param);
}