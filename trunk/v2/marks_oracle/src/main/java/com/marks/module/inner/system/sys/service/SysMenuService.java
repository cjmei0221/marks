package com.marks.module.inner.system.sys.service;

import java.util.List;

import com.marks.common.domain.Result;
import com.marks.module.inner.system.sys.pojo.SysFunc;
import com.marks.module.inner.system.sys.pojo.SysMenu;
import com.marks.module.inner.system.sys.pojo.SysOperate;

public interface SysMenuService {

	/**
	 * 查询菜单
	 * @return
	 */
	List<SysMenu> getSysMenuList();

	/**
	 * 查询父菜单
	 * @return
	 */
	List<SysMenu> getParentSysMenuList();

	/**
	 * 保存菜单
	 * @param sm
	 */
	void save(SysMenu sm);

	/**
	 * 通过主键获取菜单
	 * @param menuid
	 * @return
	 */
	SysMenu getSysMenuByMenuid(String menuid);

	/**
	 * 更新菜单
	 * @param sm
	 */
	void update(SysMenu sm);

	/**
	 * 删除菜单
	 * @param menuid
	 * @param result
	 */
	void delete(String menuid,Result result);
	
	/**
	 * 删除菜单功能
	 * @param funcid
	 */
	void deleteFunc(String funcid);

	/**
	 * 保存菜单功能
	 * @param operid
	 * @param menuid
	 * @param url
	 * @return
	 */
	SysOperate saveFunc(String operid, String menuid,String url);
	
	/**
	 * 获取菜单功能列表
	 * @param menuid
	 * @return
	 */
	List<SysOperate> getSysOperateListByMenuid(String menuid);
	
	/**
	 * 通过菜单ID和操作ID查找功能
	 * @param menuid
	 * @param operid
	 * @return
	 */
	SysFunc getSysFuncByOperIdAndMenuid(String menuid, String operid);

	/**
	 * 获取所有的操作列表
	 * @return
	 */
	List<SysOperate> getSysOperateList();

}
