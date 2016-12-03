package com.cjmei.module.system.sysuser.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysUserRole;
import com.cjmei.module.system.sysuser.pojo.SysUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SysUserDao {

	SysUser findByUserid(String userid);
	SysUser findByMobile(String mobile);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

	void delete(String userid);

	List<SysUser> findAll();

	void deleteBatch(List<String> list);

	List<SysUser> list(PageBounds pageBounds, Map<String,Object> param);

	void deleteSysUserRole(@Param("userid")String userid);

	void saveSysUserRole(SysUserRole su);
	SysUser findById(@Param("userid")String userid);
	void updatetPwd(SysUser sysUser);
	void updateMobile(@Param("userid")String userid, @Param("newPhone")String newPhone);
}