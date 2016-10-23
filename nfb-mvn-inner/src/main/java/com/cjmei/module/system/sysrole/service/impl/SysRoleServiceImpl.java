package com.cjmei.module.system.sysrole.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.enums.Enums;
import com.cjmei.module.system.sys.dao.LoginDao;
import com.cjmei.module.system.sys.pojo.SysFunc;
import com.cjmei.module.system.sys.pojo.SysMenu;
import com.cjmei.module.system.sys.pojo.SysRoleFunc;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.cjmei.module.system.sysrole.dao.SysRoleDao;
import com.cjmei.module.system.sysrole.pojo.SysRole;
import com.cjmei.module.system.sysrole.service.SysRoleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class SysRoleServiceImpl implements SysRoleService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	private SysRoleDao sysRoleDao;

	public SysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	/**
	 * 根据ID查找角色管理
	 */
	@Override
	public SysRole findById(String roleid) {
		return sysRoleDao.findById(roleid);
	}

	/**
	 * 保存角色管理
	 */
	@Override
	public void save(SysRole sysRole) {
		sysRoleDao.save(sysRole);
	}

	/**
	 * 更新角色管理
	 */
	@Override
	public void update(SysRole sysRole) {
		sysRoleDao.update(sysRole);
	}

	/**
	 * 删除角色管理
	 */
	@Override
	public void delete(String roleid) {
		sysRoleDao.delete(roleid);
	}

	/**
	 * 查找所有角色管理
	 */
	@Override
	public List<SysRole> findAll() {
		return sysRoleDao.findAll();
	}

	/**
	 * 删除多个角色管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		sysRoleDao.deleteBatch(ids);
	}

	public PojoDomain<SysRole> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<SysRole> pojoDomain = new PojoDomain<SysRole>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysRole> list = sysRoleDao.list(pageBounds, param);
		PageList<SysRole> pageList = (PageList<SysRole>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void addSysFuncByRoleId(String role_id, List<String> funcIds) {
		sysRoleDao.deleteFuncByRoleid(role_id);
		SysRoleFunc srf = null;
		if (null != funcIds && funcIds.size() > 0) {
			for (String funcid : funcIds) {
				srf = new SysRoleFunc();
				srf.setCreatetime(new Date());
				srf.setFuncid(funcid);
				srf.setRoleid(role_id);
				srf.setUpdatetime(new Date());
				sysRoleDao.saveRoleFunc(srf);
			}

		}

	}

	@Override
	public List<SysMenu> funcList(SysUser admin,String roleId) {
		List<String> roleIds = admin.getRoleIds();
		boolean getflag = false;// 请求数据标识
		List<SysMenu> returnMenu = new ArrayList<SysMenu>();

		// 未指定用户角色不可查看任何菜单
		if (null != roleIds && roleIds.size() > 0) {
			getflag = true;
			if (Enums.UserType.admin.getValue().equals(admin.getUserType())) {
				roleIds = null;
			}
		}
		
		if (getflag) {
			List<SysFunc> funcList=sysRoleDao.getFuncList(roleIds,roleId);
			List<SysMenu> child = loginDao.getChildMenu(roleIds);
			
		
			if (null != child && child.size() > 0) {
				//子菜单添加功能
				for (SysMenu cm : child) {
					for(SysFunc sf:funcList){
						if(cm.getMenuid().equals(sf.getMenuid())){
							cm.addOper(sf);
						}
					}
				}
				//封装成树
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

}