package com.cjmei.module.system.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.module.system.sys.dao.LoginDao;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.pojo.SysRole;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sys.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public SysUser getSysUserByUserid(String userid) {
		SysUser user = loginDao.getSysUserByUserid(userid);
		if(null !=user){
			List<String> list=loginDao.getUrlByUserid(userid);
			user.setUserUrlList(list);
			SysRole info=loginDao.getSysRoleByRoleid(user.getRoleid());
			user.setRole(info);
			if(info.getLvl()==0){
				user.setShopList(null);	
			}else if(info.getLvl()==1){
				List<String> shopList=loginDao.getShopidsByOrgid(user.getOrgid());
				shopList.add(user.getOrgid());
				user.setShopList(shopList);
			}else{
				List<String> shopList=new ArrayList<String>();
				shopList.add(user.getOrgid());
				user.setShopList(shopList);
			}
		}
		return user;
	}

	@Override
	public List<SysMenu> getSysMenuOfSysUser(SysUser user) {
		String roleid = user.getRoleid();
		boolean getflag = false;// 请求数据标识
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();

		// 未指定用户角色不可查看任何菜单
		if (null != roleid && roleid.length() > 5) {
			getflag = true;
		}

		if (getflag) {
			List<SysMenu> child = loginDao.getChildMenu(roleid);
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
		String roleid = user.getRoleid();
		List<SysOperate> list = loginDao.getSysOperate(menuid, roleid);
		return list;
	}

}
