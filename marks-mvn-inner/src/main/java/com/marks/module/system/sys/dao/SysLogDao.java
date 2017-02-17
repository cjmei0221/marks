package com.marks.module.system.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.system.sys.pojo.SysLog;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SysLogDao {

	List<SysLog> getSysLogParam(@Param("url")String url);

	void saveSysLog(@Param("log")SysLog log);

	List<SysLog> list(PageBounds pageBounds, Map<String,Object> param);
}
