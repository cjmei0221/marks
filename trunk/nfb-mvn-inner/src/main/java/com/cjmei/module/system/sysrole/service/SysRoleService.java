package com.cjmei.module.system.sysrole.service;


import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.system.sysrole.pojo.SysRole;

public interface SysRoleService{

	public SysRole findById(String roleid);
	public void save(SysRole sysRole);
	public void update(SysRole sysRole);
	public void delete(String roleid);
	public List<SysRole> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysRole> list(int page_number, int page_size,Map<String,Object> param);
	public void addSysFuncByRoleId(String role_id, List<String> funcIds);
}