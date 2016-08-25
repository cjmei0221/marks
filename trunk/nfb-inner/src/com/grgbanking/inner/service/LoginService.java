package com.grgbanking.inner.service;

import java.util.List;

import com.grgbanking.inner.po.sys.SysMenu;
import com.grgbanking.inner.po.sys.SysOperate;
import com.grgbanking.inner.po.sys.SysUser;

/**
 * 登录服务层接口
 * File Name: com.grgbanking.inner.service.LoginService.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月27日下午2:09:26
 * @see (optional) 
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
 */
public interface LoginService {

	SysUser getSysUserByUserid(String userid);

	List<SysMenu> getSysMenuOfSysUser(SysUser user);

	List<SysOperate> getSysOperate(String menuid,SysUser user);

}
