package com.nfb.module.syslog.dao;

import org.apache.ibatis.annotations.Param;

import com.nfb.module.syslog.entity.SysLog;
import com.nfb.module.syslog.entity.SysLogParam;

public interface SysLogDao {

	void saveSysLog(@Param("log") SysLog log);

	SysLogParam getSysLogParam(@Param("reqUrl")String url,@Param("source") int source);

}
