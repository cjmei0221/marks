package com.marks.smart.system.system.syslogparam.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.system.syslogparam.pojo.SysLogParam;
@MapperScan
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