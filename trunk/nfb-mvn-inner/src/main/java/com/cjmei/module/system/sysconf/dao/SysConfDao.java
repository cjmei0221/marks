package com.cjmei.module.system.sysconf.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.system.sysconf.pojo.SysConf;

public interface SysConfDao {

	SysConf findById(String ckey);

	void save(SysConf sysConf);

	void update(SysConf sysConf);

	void delete(String ckey);

	List<SysConf> findAll();

	void deleteBatch(List<String> list);

	List<SysConf> list(PageBounds pageBounds, Map<String,Object> param);
}