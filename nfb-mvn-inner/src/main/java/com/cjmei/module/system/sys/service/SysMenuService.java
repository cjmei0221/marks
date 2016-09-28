package com.cjmei.module.system.sys.service;

import java.util.List;

import com.cjmei.common.domain.Result;
import com.cjmei.module.system.sys.pojo.SysMenu;

public interface SysMenuService {

	List<SysMenu> getSysMenuList();

	List<SysMenu> getParentSysMenuList();

	void save(SysMenu sm);

	SysMenu getSysMenuByMenuid(String menuid);

	void update(SysMenu sm);

	Result delete(String menuid,Result result);

}
