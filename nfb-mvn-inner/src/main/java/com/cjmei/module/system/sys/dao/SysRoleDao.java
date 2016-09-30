package com.cjmei.module.system.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysFunc;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysRole;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SysRoleDao {

	List<SysRole> querySysRoleList(PageBounds pageBounds,@Param("shopids")List<String> shopids,@Param("keyword") String keyword);

	void saveSysRole(@Param("sysRole")SysRole sysRole);

	void updateSysRole(@Param("sysRole")SysRole sysRole);

	SysRole getNeedDeleteSysRoleByRoleid(@Param("roleId") String roleId);

	void deleteSysRole(@Param("roleId")String roleId);

	void deleteSysFuncByRoleId(@Param("roleId")String roleId);

	List<String> getSysFuncIdListByRoleId(@Param("roleId")String roleid);

	List<SysFunc> getSysFuncListByUserId(@Param("userRoleid")String userRoleid);

	void saveSysFuncByRoleId(@Param("roleId")String roleId, @Param("funcId")String funcId);

	List<SysMenu> getChildMenuList();

	

}
