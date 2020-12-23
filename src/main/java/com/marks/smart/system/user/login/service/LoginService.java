package com.marks.smart.system.user.login.service;

import java.util.List;

import com.marks.smart.system.system.sysmenu.pojo.SysMenu;
import com.marks.smart.system.system.sysmenu.pojo.SysOperate;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.SysUserOrgRole;

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

	SysUser findById(String companyId, String id);

	List<SysMenu> getSysMenuOfSysUser(SysUser user);

	List<SysOperate> getSysOperate(String menuid,SysUser user);
	/**
	 * 根据openid和accountid获取系统用户
	 * @param accountid
	 * @param openid
	 * @return
	 */
	SysUser getSysUserByOpenidAndAccountid(String accountid, String openid);

	List<String> getUrlByRoleId(String userid);

	SysUser findSysUserByUserid(String userid);

	List<SysUserOrgRole> getUserOrgRolelistByUserid(String userid);

}
