package com.grgbanking.inner.service.impl;

import java.util.List;

import com.grgbanking.inner.dao.SysMenuDao;
import com.grgbanking.inner.po.domain.Result;
import com.grgbanking.inner.po.sys.SysMenu;
import com.grgbanking.inner.service.SysMenuService;

public class SysMenuServiceImpl implements SysMenuService{

	private SysMenuDao sysMenuDao;

	public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}

	@Override
	public List<SysMenu> getSysMenuList() {
		List<SysMenu> list=sysMenuDao.getChildSysMenuList();
		List<SysMenu> parentMenu =sysMenuDao.getParentSysMenuList();
		for(SysMenu pm:parentMenu){
			for(SysMenu sm:list){
				if(pm.getMenuid().equals(sm.getParentid())){
					pm.addChildren(sm);
				}
			}
		}
		return parentMenu; 
	}

	@Override
	public List<SysMenu> getParentSysMenuList() {
		return sysMenuDao.getParentSysMenuList();
	}

	@Override
	public void save(SysMenu sm) {
		sysMenuDao.save(sm);
	}

	@Override
	public SysMenu getSysMenuByMenuid(String menuid) {
		return sysMenuDao.getSysMenuByMenuid(menuid);
	}

	@Override
	public void update(SysMenu sm) {
		sysMenuDao.update(sm);
	}

	@Override
	public Result delete(String menuid,Result result) {
		List<SysMenu> list=sysMenuDao.getChildListByParentid(menuid);
		if(null !=list && list.size()>0){
			result.setCode(4001);
			result.setMessage("含子菜单，不能删除");
		}else{
			sysMenuDao.delete(menuid);
		}
		return result;
	}
}
