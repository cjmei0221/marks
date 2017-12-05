package com.marks.module.user.sysuser.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.user.sysrole.dao.SysRoleDao;
import com.marks.module.user.sysuser.dao.SysUserDao;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserOrg;
import com.marks.module.user.sysuser.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Autowired
	private SysRoleDao sysRoleDao;

	public SysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	/**
	 * 根据ID查找用户管理
	 */
	@Override
	public SysUser findByUserid(String userid) {
		return sysUserDao.findByUserid(userid);
	}

	/**
	 * 根據手機號查詢用戶信息
	 */
	@Override
	public SysUser findByMobile(String companyId, String bind_mobile) {
		return sysUserDao.findByMobile(companyId, bind_mobile);
	}

	@Override
	public SysUser findById(String userid) {
		return sysUserDao.findById(userid);
	}

	/**
	 * 保存用户管理
	 */
	@Override
	public String save(SysUser sysUser, String orgIdsPut, String orgNamesPut) {
		String userid = "U" + IDUtil.getDateID() + "_" + IDUtil.getRandom(100, 999) + IDUtil.getRandom(100, 999);
		sysUser.setUserid(userid);
		if (null != orgIdsPut && !"".equals(orgIdsPut)) {
			SysUserOrg uorg = saveSysUserOrg(sysUser.getUserid(), orgIdsPut, orgNamesPut, sysUser.getCreator());
			if (null != uorg) {
				sysUser.setDefaultOrgid(uorg.getOrgid());
				sysUser.setDefaultOrgname(uorg.getOrgname());
			}
		}
		sysUserDao.save(sysUser);
		return userid;
	}

	/**
	 * 更新用户管理
	 */
	@Override
	public void update(SysUser sysUser, String orgIdsPut, String orgNamesPut) {
		if (null != orgIdsPut && !"".equals(orgIdsPut)) {
			SysUserOrg uorg = saveSysUserOrg(sysUser.getUserid(), orgIdsPut, orgNamesPut, sysUser.getCreator());
			if (null != uorg) {
				sysUser.setDefaultOrgid(uorg.getOrgid());
				sysUser.setDefaultOrgname(uorg.getOrgname());
			}
		}
		sysUserDao.update(sysUser);
	}

	@Override
	public String save(SysUser user) {
		String userid = save(user, user.getDefaultOrgid(), user.getDefaultOrgname());
		return userid;
	}

	@Override
	public void update(SysUser user) {
		update(user, user.getDefaultOrgid(), user.getDefaultOrgname());
	}

	private SysUserOrg saveSysUserOrg(String userid, String orgIdsPut, String orgNamesPut, String creator) {
    	sysUserDao.deleteSysUserOrg(userid);
    	SysUserOrg su=null;
    	String[] arr=orgIdsPut.split(",");
		String[] nameArr = orgNamesPut.split(",");
		int count = 0;
		SysUserOrg returnOrg=null;
		for (int i = 0; i < arr.length; i++) {
			String id = arr[i];
			String name = nameArr[i];
    		if(id !=null && !"".equals(id)){
				count++;
				
    			su=new SysUserOrg();
        		su.setOrgid(id);
        		su.setUserid(userid);
        		su.setCreator(creator);
				su.setOrgname(name);
        		if (count == 1) {
					su.setIsDefault(1);
        			returnOrg=su;
				}
				sysUserDao.saveSysUserOrg(su);
    		}
    	}
		return returnOrg;
    }

	@Override
	public void updatePwd(String userid, String pwd) {
		sysUserDao.updatePwd(userid, pwd);
	}

	@Override
	public void updateActiveFlag(String userid, int flag) {
		sysUserDao.updateActiveFlag(userid, flag);
	}

	/**
	 * 删除用户管理
	 */
	@Override
	public void delete(String userid) {
		sysUserDao.deleteSysUserOrg(userid);
		sysUserDao.delete(userid);
	}

	/**
	 * 查找所有用户管理
	 */
	@Override
	public List<SysUser> findAll() {
		return sysUserDao.findAll();
	}

	/**
	 * 删除多个用户管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		sysUserDao.deleteBatch(ids);
	}

	public PojoDomain<SysUser> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<SysUser> pojoDomain = new PojoDomain<SysUser>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysUser> list = sysUserDao.list(pageBounds, param);
		PageList<SysUser> pageList = (PageList<SysUser>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void updateMobile(String userid, String newPhone) {
		sysUserDao.updateMobile(userid, newPhone);
	}

	@Override
	public void updateSkin(String userid, int skin) {
		sysUserDao.updateSkin(userid, skin);
	}
}