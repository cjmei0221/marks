package com.marks.smart.system.system.syslogparam.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.system.system.syslogparam.pojo.SysLogParam;

public interface SysLogParamService{
	public SysLogParam findById(String id);
	public void save(SysLogParam sysLogParam);
	public void update(SysLogParam sysLogParam);
	public void delete(String id);
	public List<SysLogParam> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysLogParam> list(int page_number, int page_size,Map<String,Object> param);
	public SysLogParam findByUrlAndSource(String url, int source);
}