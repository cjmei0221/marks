package com.marks.smart.system.user.sysrole.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.system.system.sysmenu.pojo.SysFunc;
import com.marks.smart.system.user.sysrole.pojo.SysRole;
import com.marks.smart.system.user.sysrole.pojo.SysRoleFunc;

@MapperScan
public interface SysRoleDao {

	SysRole findById(String roleid);

	void save(SysRole sysRole);

	void update(SysRole sysRole);

	void delete(String roleid);

	List<SysRole> findAll();

	void deleteBatch(List<String> list);

	List<SysRole> list(PageBounds pageBounds, Map<String, Object> param);

	void saveRoleFunc(SysRoleFunc srf);

	void deleteFuncByRoleid(String roleid);

	List<SysFunc> getFuncList(@Param("loginUserRoleId") String loginUserRoleId, @Param("roleId") String roleId);

	int countUserByRoleid(@Param("roleId") String roleid);

	List<SysRole> getUserlist(Map<String, Object> param);

	void saveBatchRoleFunc(@Param("list") List<SysRoleFunc> list);

	void updateSysUserByRole(@Param("info") SysRole sysRole);

	void updateSysUserRoleByRole(@Param("info") SysRole sysRole);

	List<String> getFuncListByRoleId(@Param("roleId") String roleId);

	List<SysRole> listByOrgId(@Param("orgId")String orgId);
}