package com.cjmei.module.system.syslog.service;


import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.system.sys.pojo.SysLog;

public interface SysLogService{
	public PojoDomain<SysLog> list(int page_number, int page_size,Map<String,Object> param);
}