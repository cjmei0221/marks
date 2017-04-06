package com.marks.module.inner.system.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.marks.module.inner.system.orginfo.pojo.OrgInfo;
import com.marks.module.inner.system.sys.dao.LoginDao;
import com.marks.module.inner.system.sys.pojo.SysMenu;
import com.marks.module.inner.system.sys.pojo.SysOperate;
import com.marks.module.inner.system.sys.service.LoginService;
import com.marks.module.inner.system.sysuser.pojo.SysUser;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public SysUser getSysUserByUserid(String userid) {
		SysUser user = loginDao.getSysUserByUserid(userid);
		if (null != user) {
			List<String> list = loginDao.getUrlByUserid(user.getUserid());
			user.setUserUrlList(list);
		}
		return user;
	}

	@Override
	public List<SysMenu> getSysMenuOfSysUser(SysUser user) {
		boolean getflag = false;// 请求数据标识
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();

		List<SysMenu> child = loginDao.getChildMenu(user.getRoleid());
		if (null != child && child.size() > 0) {
			List<SysMenu> parentMenu = loginDao.getParentSysMenu();
			for (SysMenu pm : parentMenu) {
				for (SysMenu cm : child) {
					if (pm.getMenuid().equals(cm.getParentid())) {
						pm.addChildren(cm);
					}
				}
				if (pm.getChildren().size() > 0) {
					returnMenu.add(pm);
				}
			}
		}

		return returnMenu;
	}

	@Override
	public List<SysOperate> getSysOperate(String menuid, SysUser user) {
		List<SysOperate> list = loginDao.getSysOperate(menuid, user.getRoleid());
		return list;
	}

	@Override
	public List<String> getOrgidBySysUser(List<OrgInfo> orglist) {

		return loginDao.getOrgidBySysUser(orglist);
	}

	@Override
	public List<OrgInfo> getOrgInfoListByUserid(String userid) {
		return loginDao.getOrgInfoListByUserid(userid);
	}

}