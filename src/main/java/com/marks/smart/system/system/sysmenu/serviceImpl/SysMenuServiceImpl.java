package com.marks.smart.system.system.sysmenu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.common.domain.Result;
import com.marks.common.util.IDUtil;
import com.marks.smart.system.system.sysmenu.dao.SysMenuDao;
import com.marks.smart.system.system.sysmenu.pojo.SysFunc;
import com.marks.smart.system.system.sysmenu.pojo.SysMenu;
import com.marks.smart.system.system.sysmenu.pojo.SysOperate;
import com.marks.smart.system.system.sysmenu.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService{
	@Autowired
	private SysMenuDao sysMenuDao;

	/*public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}*/

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
	public void delete(String menuid,Result result) {
		List<SysMenu> list=sysMenuDao.getChildListByParentid(menuid);
		if(null !=list && list.size()>0){
			result.setCode("4001");
			result.setMessage("含子菜单，不能删除");
		}else{
			sysMenuDao.deleteRoleFunc(menuid);
			sysMenuDao.deleteFunc(menuid);
			sysMenuDao.delete(menuid);
		}
	}

	@Override
	public void deleteFunc(String funcid) {
		sysMenuDao.deletSysRolecUrlByFuncid(funcid);
		sysMenuDao.deletSysFuncByFuncid(funcid);
	}

	@Override
	public SysOperate saveFunc(String operid, String menuid, String url) {
		SysFunc sf=new SysFunc();
		sf.setFuncid(IDUtil.getUUID());
		sf.setMenuid(menuid);
		sf.setOperid(operid);
		sf.setUrl(url);
		sysMenuDao.saveSysFunc(sf);
		
		
		SysOperate oper=sysMenuDao.getSysOperateByOperid(operid);
		oper.setFuncid(sf.getFuncid());
		oper.setUrl(url);
		return oper;
	}

	@Override
	public List<SysOperate> getSysOperateListByMenuid(String menuid) {
		return sysMenuDao.getSysOperateListByMenuid(menuid);
	}

	@Override
	public SysFunc getSysFuncByOperIdAndMenuid(String menuid, String operid) {
		return sysMenuDao.getSysFuncByOperIdAndMenuid(menuid,operid);
	}

	@Override
	public List<SysOperate> getSysOperateList() {
		return sysMenuDao.getSysOperateList();
	}

	@Override
	public List<SysMenu> getChildListByParentid(String parentId) {
		List<SysMenu> list = sysMenuDao.getChildListByParentid(parentId);
		return list;
	}

	@Override
	public List<SysMenu> listTree(String parentId) {
		return sysMenuDao.listTree(parentId);
	}

}
