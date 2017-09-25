package com.marks.module.system.sysconf.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.sysconf.pojo.SysConf;

public interface SysConfService{

	public SysConf findById(String ckey);
	public void save(SysConf sysConf);
	public void update(SysConf sysConf);
	public void delete(String ckey);
	public List<SysConf> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysConf> list(int page_number, int page_size,Map<String,Object> param);
}