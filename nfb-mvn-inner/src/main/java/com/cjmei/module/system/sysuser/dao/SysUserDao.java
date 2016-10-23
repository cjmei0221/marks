package com.cjmei.module.system.sysuser.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.system.sysuser.pojo.SysUser;

public interface SysUserDao {

	SysUser findById(String userid);

	void save(SysUser sysUser);

	void update(SysUser sysUser);

	void delete(String userid);

	List<SysUser> findAll();

	void deleteBatch(List<String> list);

	List<SysUser> list(PageBounds pageBounds, Map<String,Object> param);
}