package com.cjmei.module.system.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.system.sys.pojo.SysMenu;

public interface SysMenuDao {

	List<SysMenu> getChildSysMenuList();

	List<SysMenu> getParentSysMenuList();

	void save(@Param("sm") SysMenu sm);

	SysMenu getSysMenuByMenuid(@Param("menuid") String menuid);

	void update(@Param("sm") SysMenu sm);

	List<SysMenu> getChildListByParentid(@Param("menuid") String menuid);

	void delete(@Param("menuid") String menuid);

}
