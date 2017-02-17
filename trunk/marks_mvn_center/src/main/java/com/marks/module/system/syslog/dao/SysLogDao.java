package com.marks.module.system.syslog.dao;

import org.apache.ibatis.annotations.Param;

import com.marks.module.system.syslog.entity.SysLog;
import com.marks.module.system.syslog.entity.SysLogParam;

public interface SysLogDao {

	void saveSysLog(@Param("log") SysLog log);

	SysLogParam getSysLogParam(@Param("reqUrl")String url,@Param("source") int source);

}
