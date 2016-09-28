package com.cjmei.module.system.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysLog;

public interface SysLogDao {

	List<SysLog> getSysLogParam(@Param("url")String url);

	void saveSysLog(@Param("log")SysLog log);

}
