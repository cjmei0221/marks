package com.marks.module.system.login.service.impl;

import com.marks.module.system.login.dao.SysUserDao;
import com.marks.module.system.login.pojo.SysUser;
import com.marks.module.system.login.service.SysUserService;

public class SysUserServiceImpl implements SysUserService {

	private SysUserDao sysUserDao;

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Override
	public SysUser getSysUserByUseridOrMobile(String userid) {
		return sysUserDao.getSysUserByUseridOrMobile(userid);
	}

	@Override
	public void updatePwd(String userid, String password) {
		sysUserDao.updatePwd(userid, password);
	}

	@Override
	public void updateSkin(String userid, int skin) {
		sysUserDao.updateSkin(userid, skin);
	}

	@Override
	public void save(SysUser sysUser) {
		sysUserDao.save(sysUser);
		saveSysUserOrg(sysUser.getUserid(), sysUser.getCompanyId(), sysUser.getCreator());
	}

	private void saveSysUserOrg(String userid, String orgid, String creator) {
		sysUserDao.saveSysUserOrg(userid,orgid,creator);
	}

	@Override
	public void update(SysUser sysUser) {
		sysUserDao.update(sysUser);
	}

	@Override
	public void updateMobile(String userid, String mobile) {
		sysUserDao.updateMobile(userid, mobile);
	}

}
