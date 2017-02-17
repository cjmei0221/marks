package com.cjmei.module.system.syslog.dao;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.syslog.pojo.SysLog;
import com.cjmei.module.system.syslog.pojo.SysLogParam;

public interface SysLogDao {

	void saveSysLog(@Param("log") SysLog log);
	SysLogParam getSysLogParam(@Param("reqUrl")String url,@Param("source") int source);
}
