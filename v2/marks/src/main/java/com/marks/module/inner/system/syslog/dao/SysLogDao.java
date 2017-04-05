package com.marks.module.inner.system.syslog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.system.syslog.pojo.SysLog;
import com.marks.module.inner.system.syslogparam.pojo.SysLogParam;

public interface SysLogDao {

	List<SysLog> getSysLogParam(@Param("url")String url);

	void saveSysLog(@Param("log")SysLog log);

	List<SysLog> list(PageBounds pageBounds, Map<String,Object> param);

	void deleteData(@Param("clearDate") String clearDate);

	SysLogParam getSysLogParamNoForInner(@Param("reqUrl")String url,@Param("source") int source);
}
