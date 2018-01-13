package com.marks.module.user.login.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.system.sysmenu.pojo.SysMenu;
import com.marks.module.system.sysmenu.pojo.SysOperate;
import com.marks.module.user.login.dao.LoginDao;
import com.marks.module.user.login.service.LoginService;
import com.marks.module.user.sysuser.pojo.SysUser;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	/*
	 * public void setLoginDao(LoginDao loginDao) { this.loginDao = loginDao; }
	 */

	@Override
	public SysUser findById(String companyId, String userid) {
		List<SysUser> userList = loginDao.listById(userid);
		if (null != userList && userList.size() == 1) {
			return userList.get(0);
		} else if (null != userList && userList.size() > 1) {
			for (SysUser u : userList) {
				if (u.getCompanyId().equals(companyId)) {
					return u;
				}
			}
		}
		return null;
	}

	@Override
	public List<String> getUrlByUserid(String userid) {
		return loginDao.getUrlByUserid(userid);
	}

	@Override
	public SysUser findSysUserByUserid(String userid) {
		return loginDao.getSysUserByUserid(userid);
	}

	@Override
	public List<SysMenu> getSysMenuOfSysUser(SysUser user) {
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();
		List<SysMenu> lvl2Menu = new ArrayList<SysMenu>();
		List<SysMenu> child = loginDao.getChildMenu(user.getRoleId());
		if (null != child && child.size() > 0) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -3);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String before3Month = sdf.format(c.getTime());
			// 常用菜单
			List<SysMenu> useMenuList = loginDao.getMenuListByLog(user.getUserid(), before3Month);
			if (null != useMenuList && useMenuList.size() > 0) {
				if (useMenuList.size() > 8) {
					useMenuList = useMenuList.subList(0, 8);
				}

				// 常用一级菜单
				SysMenu useLvl1 = new SysMenu();
				useLvl1.setLvl(1);
				useLvl1.setMenuid("userlvl1");
				useLvl1.setMenuitem("个人");
				useLvl1.setParentid("0");
				useLvl1.setUrl("#");
				// 常用二级菜单
				SysMenu useLvl2 = new SysMenu();
				useLvl2.setLvl(2);
				useLvl2.setMenuid("userlvl2");
				useLvl2.setMenuitem("常用");
				useLvl2.setParentid(useLvl1.getMenuid());
				useLvl2.setUrl("#");
				useLvl1.addChildren(useLvl2);
				// 常用三级菜单
				for (SysMenu sm : useMenuList) {
					sm.setParentid(useLvl2.getMenuid());
				}
				useLvl2.setChildren(useMenuList);
				returnMenu.add(useLvl1);
			}

			List<SysMenu> lvl1List = new ArrayList<SysMenu>();
			List<SysMenu> lvl2List = new ArrayList<SysMenu>();
			List<SysMenu> parentMenu = loginDao.getParentSysMenu();
			for (SysMenu pm : parentMenu) {
				if (pm.getLvl() == 1) {
					lvl1List.add(pm);
				} else if (pm.getLvl() == 2) {
					lvl2List.add(pm);
				}
			}
			for (SysMenu pm : lvl2List) {
				for (SysMenu cm : child) {
					if (pm.getMenuid().equals(cm.getParentid())) {
						pm.addChildren(cm);
					}
				}
				if (pm.getChildren().size() > 0) {
					lvl2Menu.add(pm);
				}
			}
			// 封装一级菜单
			if (lvl2Menu.size() > 0) {
				for (SysMenu pm : lvl1List) {
					for (SysMenu cm : lvl2Menu) {
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
		List<SysOperate> list = loginDao.getSysOperate(menuid, user.getRoleId());
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

	@Override
	public SysUser getSysUserByOpenidAndAccountid(String accountid, String openid) {
		return loginDao.getSysUserByOpenidAndAccountid(accountid, openid);
	}

}
