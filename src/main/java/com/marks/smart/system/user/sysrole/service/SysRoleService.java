package com.marks.smart.system.user.sysrole.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.system.system.sysmenu.pojo.SysMenu;
import com.marks.smart.system.user.sysrole.pojo.SysRole;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

public interface SysRoleService{

	public SysRole findById(String roleid);
	public void save(SysRole sysRole);
	public void update(SysRole sysRole);
	public void delete(String roleid);
	public List<SysRole> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SysRole> list(int page_number, int page_size,Map<String,Object> param);
	public void addSysFuncByRoleId(String role_id, List<String> funcIds);
	public List<SysMenu> funcList(SysUser admin,String roleId);

	public void saveSysFuncByRoleId(String roleId, List<String> funcList);
	public boolean isDelete(String roleid);
	public List<SysRole> getUserlist(Map<String, Object> param);
	public List<SysRole> listByOrgId(String orgid);
}