package com.marks.module.inner.system.sysconf.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.system.sysconf.pojo.SysConf;
@MapperScan
public interface SysConfDao {

	SysConf findById(String ckey);

	void save(SysConf sysConf);

	void update(SysConf sysConf);

	void delete(String ckey);

	List<SysConf> findAll();

	void deleteBatch(List<String> list);

	List<SysConf> list(PageBounds pageBounds, Map<String,Object> param);
}