package com.grgbanking.inner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.inner.po.sys.SysLog;

public interface SysLogDao {

	List<SysLog> getSysLogParam(@Param("url")String url);

	void saveSysLog(@Param("log")SysLog log);

}
