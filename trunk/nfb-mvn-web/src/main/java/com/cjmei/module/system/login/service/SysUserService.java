package com.cjmei.module.system.login.service;

import com.cjmei.module.system.login.pojo.SysUser;

public interface SysUserService {

	SysUser getSysUserByUseridOrMobile(String userid);

	void updatePwd(String userid, String password);

	void updateSkin(String userid, int skin);

	void save(SysUser sysUser);

}
