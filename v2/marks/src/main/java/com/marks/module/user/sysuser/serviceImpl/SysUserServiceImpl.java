package com.marks.module.user.sysuser.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.IDUtil;
import com.marks.module.org.orginfo.dao.OrgInfoDao;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.user.sysrole.dao.SysRoleDao;
import com.marks.module.user.sysrole.pojo.SysRole;
import com.marks.module.user.sysuser.dao.SysUserDao;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.pojo.SysUserOrgRole;
import com.marks.module.user.sysuser.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private OrgInfoDao orgInfoDao;

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
	public String save(SysUser sysUser) {
		String userCode = IDUtil.getID(6);
		String userid = IDUtil.getDateID().substring(0, 6) + userCode;
		sysUser.setUserid(userid);
		sysUser.setUserCode(userCode);
		saveSysUserOrgRole(sysUser);
		sysUserDao.save(sysUser);
		return userid;
	}

	/**
	 * 更新用户管理
	 */
	@Override
	public void update(SysUser sysUser) {
		saveSysUserOrgRole(sysUser);
		sysUserDao.update(sysUser);
	}

	private void saveSysUserOrgRole(SysUser sysUser) {
		sysUserDao.deleteSysUserOrgRoleByUserid(sysUser.getUserid());
		SysRole role = sysRoleDao.findById(sysUser.getRoleId());
		SysUserOrgRole su = new SysUserOrgRole();
		su.setUserid(sysUser.getUserid());
		su.setCompanyId(sysUser.getCompanyId());
		if (role != null) {
			sysUser.setRoleId(role.getRoleid());
			sysUser.setRoleLvl(role.getLvl());
			sysUser.setRoleName(role.getRolename());
			sysUser.setRoleType(role.getRoleType());
			su.setRoleId(sysUser.getRoleId());
			su.setRoleLvl(sysUser.getRoleLvl());
			su.setRoleName(sysUser.getRoleName());
			su.setRoleType(sysUser.getRoleType());
		}
		if (null != sysUser.getOrgId()) {
			OrgInfo info = orgInfoDao.findById(sysUser.getOrgId());
			if (info != null) {
				sysUser.setParentOrgId(info.getParentId());
				sysUser.setParentOrgName(info.getParentName());
				sysUser.setOrgCategory(info.getOrgCategory());
				sysUser.setOrgId(info.getOrgid());
				sysUser.setOrgName(info.getOrgname());
				sysUser.setOrgType(info.getOrgType());
				su.setOrgCategory(sysUser.getOrgCategory());
				su.setOrgId(sysUser.getOrgId());
				su.setOrgName(sysUser.getOrgName());
				su.setOrgType(sysUser.getOrgType());
				su.setParentOrgId(sysUser.getParentOrgId());
				su.setParentOrgName(sysUser.getParentOrgName());
			}
		}
		sysUserDao.saveSysUserOrgRole(su);
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
		sysUserDao.deleteSysUserOrgRoleByUserid(userid);
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