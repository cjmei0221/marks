package com.grgbanking.inner.service;

import java.util.List;

import com.grgbanking.inner.po.domain.Result;
import com.grgbanking.inner.po.sys.SysMenu;

public interface SysMenuService {

	List<SysMenu> getSysMenuList();

	List<SysMenu> getParentSysMenuList();

	void save(SysMenu sm);

	SysMenu getSysMenuByMenuid(String menuid);

	void update(SysMenu sm);

	Result delete(String menuid,Result result);

}
