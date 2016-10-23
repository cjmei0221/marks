package com.cjmei.module.system.sysrole.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysFunc;
import com.cjmei.module.system.sys.pojo.SysRoleFunc;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

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

	List<SysFunc> getFuncList(@Param("list")List<String> list,@Param("roleId") String roleId);
}