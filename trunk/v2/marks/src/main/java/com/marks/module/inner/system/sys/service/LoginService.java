package com.marks.module.inner.system.sys.service;

import java.util.List;

import com.marks.module.inner.system.orginfo.pojo.OrgInfo;
import com.marks.module.inner.system.sys.pojo.SysMenu;
import com.marks.module.inner.system.sys.pojo.SysOperate;
import com.marks.module.inner.system.sysrole.pojo.SysRole;
import com.marks.module.inner.system.sysuser.pojo.SysUser;

/**
 * 登录服务层接口
 * File Name: com.grgbanking.inner.service.LoginService.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月27日下午2:09:26
 * @see (optional) 
 * @Copyright (c) 2016, marks  All Rights Reserved.
 */
public interface LoginService {

	SysUser getSysUserByUserid(String userid);

	List<SysMenu> getSysMenuOfSysUser(SysUser user);

	List<SysOperate> getSysOperate(String menuid,SysUser user);

	List<String> getOrgidBySysUser(List<OrgInfo> orgInfo);

	List<OrgInfo> getOrgInfoListByUserid(String userid);

}