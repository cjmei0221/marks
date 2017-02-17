package com.marks.module.system.syslog.service;


import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.sys.pojo.SysLog;

public interface SysLogService{
	public PojoDomain<SysLog> list(int page_number, int page_size,Map<String,Object> param);
}