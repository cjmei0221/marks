package com.cjmei.module.system.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.common.enums.Enums;
import com.cjmei.module.system.sys.dao.LoginDao;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.service.LoginService;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysuser.pojo.SysUser;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public SysUser getSysUserByUserid(String userid) {
		SysUser user = loginDao.getSysUserByUserid(userid);
		if(null !=user){
			List<String> list=loginDao.getUrlByUserid(user.getUserid());
			user.setUserUrlList(list);
		}
		return user;
	}
	

	@Override
	public List<SysRole> getUserRoleList(String userid) {
		return loginDao.getUserRoleList(userid);
	}

	@Override
	public List<SysMenu> getSysMenuOfSysUser(SysUser user) {
		List<SysRole> roleIds = user.getRoleIds();
		boolean getflag = false;// 请求数据标识
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();

		// 未指定用户角色不可查看任何菜单
		if (null != roleIds && roleIds.size() > 0) {
			getflag = true;
		}

		if (getflag) {
			List<SysMenu> child = loginDao.getChildMenu(roleIds);
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
		List<SysOperate> list = loginDao.getSysOperate(menuid, user.getRoleIds());
		return list;
	}

	@Override
	public List<String> getOrgidBySysUser(String orgid) {
		
		return loginDao.getOrgidBySysUser(orgid);
	}
	
	

}
