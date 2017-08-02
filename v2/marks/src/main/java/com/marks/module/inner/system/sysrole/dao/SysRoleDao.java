package com.marks.module.inner.system.sysrole.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.system.sys.pojo.SysFunc;
import com.marks.module.inner.system.sys.pojo.SysRoleFunc;
import com.marks.module.inner.system.sysrole.pojo.SysRole;

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

	SysRole findByUserTypeAndCompanyId(@Param("roleid") String roleid, 
			@Param("companyId") String companyId);

	int countUserByRoleid( @Param("roleId") String roleid);

	List<SysRole> getUserlist(Map<String, Object> param);
}