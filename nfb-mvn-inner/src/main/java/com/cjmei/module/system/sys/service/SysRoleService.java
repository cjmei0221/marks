package com.cjmei.module.system.sys.service;

import java.util.List;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysRole;
import com.cjmei.module.system.sys.pojo.SysUser;

public interface SysRoleService {

	void saveSysRole(SysRole sysRole);

	SysRole getNeedDeleteSysRoleByRoleid(String roleId);

	void deleteSysRole(String roleId);

	List<SysMenu> getSysFuncTree(String userroleid, String roleid);

	void saveSysFuncByRoleId( String roleId, List<String> funcIds);

	PojoDomain<SysRole> querySysRoleList(SysUser admin, int page_number, int page_size,String keyword);


}
