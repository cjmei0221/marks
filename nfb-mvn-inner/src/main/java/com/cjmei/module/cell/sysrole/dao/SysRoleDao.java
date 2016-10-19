package com.cjmei.module.cell.sysrole.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.cell.sysrole.pojo.SysRole;
import com.cjmei.module.system.sys.pojo.SysRoleFunc;

public interface SysRoleDao {

	SysRole findById(String roleid);

	void save(SysRole sysRole);

	void update(SysRole sysRole);

	void delete(String roleid);

	List<SysRole> findAll();

	void deleteBatch(List<String> list);

	List<SysRole> list(PageBounds pageBounds, Map<String,Object> param);

	void saveRoleFunc(SysRoleFunc srf);

	void deleteFuncByRoleid(String roleid);
}