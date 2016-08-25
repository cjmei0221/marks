package com.grgbanking.inner.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.grgbanking.inner.dao.LoginDao;
import com.grgbanking.inner.data.StaticData;
import com.grgbanking.inner.po.sys.SysMenu;
import com.grgbanking.inner.po.sys.SysOperate;
import com.grgbanking.inner.po.sys.SysUser;
import com.grgbanking.inner.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public SysUser getSysUserByUserid(String userid) {
		SysUser user = loginDao.getSysUserByUserid(userid);
		return user;
	}

	@Override
	public List<SysMenu> getSysMenuOfSysUser(SysUser user) {
		List<Integer> rolelist = user.getRolelist();
		boolean getflag = false;// 请求数据标识
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();
		if ("system".equals(user.getUserid())) {
			getflag = true;
			rolelist = null;
		} else {
			// 未指定用户角色不可查看任何菜单
			if (null != rolelist && rolelist.size() > 0) {
				getflag = true;
			}
		}

		if (getflag) {
			List<SysMenu> child = loginDao.getChildMenu(rolelist);
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
		}
		return returnMenu;
	}

	@Override
	public List<SysOperate> getSysOperate(String menuid, SysUser user) {
		List<Integer> rolelist = user.getRolelist();
		if ("system".equals(user.getUserid())) {
			rolelist = null;
		}
		List<SysOperate> list = loginDao.getSysOperate(menuid, rolelist);
		return list;
	}

}
