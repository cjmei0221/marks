package com.marks.module.inner.system.syslogparam.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.inner.system.syslogparam.pojo.SysLogParam;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SysLogParamDao {

	SysLogParam findById(String id);

	void save(SysLogParam sysLogParam);

	void update(SysLogParam sysLogParam);

	void delete(String id);

	List<SysLogParam> findAll();

	void deleteBatch(List<String> list);

	List<SysLogParam> list(PageBounds pageBounds, Map<String,Object> param);

	SysLogParam findByUrlAndSource(@Param("reqUrl")String url, @Param("source") int source);
}