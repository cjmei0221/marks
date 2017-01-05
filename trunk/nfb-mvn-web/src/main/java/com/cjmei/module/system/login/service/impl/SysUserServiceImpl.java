package com.cjmei.module.system.login.service.impl;

import com.cjmei.module.system.login.dao.SysUserDao;
import com.cjmei.module.system.login.pojo.SysUser;
import com.cjmei.module.system.login.service.SysUserService;

public class SysUserServiceImpl implements SysUserService{

	private SysUserDao sysUserDao;

	

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}



	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}



	@Override
	public SysUser getSysUserByUserid(String userid) {
		return sysUserDao.getSysUserByUserid(userid);
	}



	@Override
	public void updatePwd(String userid, String password) {
		sysUserDao.updatePwd(userid,password);
	}



	@Override
	public void updateSkin(String userid, int skin) {
		sysUserDao.updateSkin(userid,skin);
	}
	
	
}
