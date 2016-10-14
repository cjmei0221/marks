package com.cjmei.module.system.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.domain.Result;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.system.sys.dao.LoginDao;
import com.cjmei.module.system.sys.dao.SysRoleDao;
import com.cjmei.module.system.sys.pojo.SysFunc;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysOperate;
import com.cjmei.module.system.sys.pojo.SysRole;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sys.service.SysRoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class SysRoleServiceImpl implements SysRoleService {

	private SysRoleDao sysRoleDao;
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	@Override
	public PojoDomain<SysRole> querySysRoleList(SysUser user, int page_number, int page_size,String keyword) {
		PojoDomain<SysRole> pojoDomain = new PojoDomain<SysRole>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysRole> list = sysRoleDao.querySysRoleList(pageBounds,user.getShopList(),keyword);
		PageList<SysRole> pageList = (PageList<SysRole>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	

	@Override
	public void saveSysRole(SysRole sysRole) {
		sysRoleDao.saveSysRole(sysRole);
	}
	
	

	@Override
	public void updateSysRole(SysRole sysRole) {
		sysRoleDao.updateSysRole(sysRole);
	}

	@Override
	public SysRole getNeedDeleteSysRoleByRoleid(String roleId) {
		return sysRoleDao.getNeedDeleteSysRoleByRoleid(roleId);
	}

	@Override
	public void deleteSysRole(String roleId) {
		sysRoleDao.deleteSysRole(roleId);
		sysRoleDao.deleteSysFuncByRoleId(roleId);
	}

	@Override
	public List<SysMenu> getSysFuncTree(String userroleid, String roleid) {
		List<String> roleid_check = sysRoleDao.getSysFuncIdListByRoleId(roleid);
		List<SysFunc> sysfunc_list = sysRoleDao.getSysFuncListByUserId(userroleid);
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();
		List<SysMenu> returnChildMenu = new ArrayList<SysMenu>();
		List<SysMenu> child = sysRoleDao.getChildMenuList();
		List<SysMenu> parentlist = loginDao.getParentSysMenu();
		if (null != child && child.size() > 0) {
		//添加功能
			for(SysMenu childm:child){
				for (SysFunc sysFunc : sysfunc_list) {
					if(childm.getMenuid().equals(sysFunc.getMenuid())){
						if (roleid_check.contains(sysFunc.getFuncid()))
							sysFunc.setIsset(1);
						else {
							sysFunc.setIsset(0);
						}
						childm.addOper(sysFunc);
					}
				}
				//判断是否有功能
				if(childm.getOper_list().size()>0){
					returnChildMenu.add(childm);
				}
			}
			List<SysMenu> childMenu = null;
			for (SysMenu pm : parentlist) {
				childMenu = new ArrayList<SysMenu>();
				for (SysMenu cm : returnChildMenu) {
					if (pm.getMenuid().equals(cm.getParentid())) {
						childMenu.add(cm);
					}
				}
				if (childMenu.size() > 0) {
					pm.setChildren(childMenu);
					returnMenu.add(pm);
				}
			}
		}
		return returnMenu;
	}

	@Override
	public void saveSysFuncByRoleId(String roleId, List<String> funcIds) {
		sysRoleDao.deleteSysFuncByRoleId(roleId);
		for (String funcId : funcIds) {
			sysRoleDao.saveSysFuncByRoleId(roleId, funcId);
		}
	}


}
