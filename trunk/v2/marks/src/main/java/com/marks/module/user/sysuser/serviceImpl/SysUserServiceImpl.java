package com.marks.module.user.sysuser.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.enums.Enums;
import com.marks.common.enums.UserEnums;
import com.marks.common.util.Code;
import com.marks.module.acct.base.service.UserExtService;
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
	private static Logger logger = Logger.getLogger(SysUserServiceImpl.class);
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private OrgInfoDao orgInfoDao;
	@Autowired
	private UserExtService userExtService;

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

	/**
	 * 保存用户管理
	 */
	@Override
	public Result save(SysUser sysUser) {
		Result result = new Result();
		if (null != sysUser.getBind_mobile() && sysUser.getBind_mobile().length() > 4) {
			SysUser mobileUser = sysUserDao.findByMobile(sysUser.getCompanyId(), sysUser.getBind_mobile());
			if (mobileUser != null) {
				result.setCode("2001");
				result.setMessage("此手机号已注册");
				return result;
			}
		}

		String userCode = getUserCode(sysUser.getCompanyId());
		String userid = sysUser.getCompanyId() + userCode;
		if (UserEnums.RoleYwType.defaultSys.getValue() == sysUser.getRoleYwType()) {
			userid = sysUser.getUserid();
			sysUser.setRoleYwType(UserEnums.RoleYwType.sys.getValue());
		}
		sysUser.setUserid(userid);
		sysUser.setUserCode(userCode);
		saveSysUserOrgRole(sysUser);
		sysUserDao.save(sysUser);
		saveUserExt(sysUser);
		result.getData().put("userid", userid);
		return result;
	}

	private void saveUserExt(SysUser sysUser) {
		userExtService.saveOrUpdate(sysUser);
	}

	public String getUserCode(String companyId) {
		String userCode = "";
		long initcode = 0;
		String maxCode = sysUserDao.getMaxCode(companyId);
		if (null == maxCode || "".equals(maxCode)) {
			maxCode = "100000";
		}
		initcode = Long.parseLong(maxCode);
		userCode = String.valueOf(initcode + 1);
		return userCode;
	}

	/**
	 * 更新用户管理
	 */
	@Override
	public Result update(SysUser sysUser) {
		Result result = new Result();
		SysUser mobileUser = this.findByMobile(sysUser.getCompanyId(), sysUser.getBind_mobile());
		if (mobileUser != null && !sysUser.getUserid().equals(mobileUser.getUserid())) {
			result.setMessage("此手机号已被注册!");
			result.setCode(Code.CODE_FAIL);
			return result;
		}
		saveSysUserOrgRole(sysUser);
		sysUserDao.update(sysUser);
		saveUserExt(sysUser);
		result.getData().put("userid", sysUser.getUserid());
		return result;
	}

	private void saveSysUserOrgRole(SysUser sysUser) {
		sysUserDao.deleteSysUserOrgRoleByUserid(sysUser.getUserid());
		// 默认角色
		SysRole role = sysRoleDao.findById(sysUser.getRoleId());
		SysUserOrgRole su = new SysUserOrgRole();
		su.setSort(0);
		su.setUserRoleOrgId(sysUser.getUserid() + su.getSort());
		su.setUserid(sysUser.getUserid());
		su.setCompanyId(sysUser.getCompanyId());
		sysUser.setUserRoleOrgId(su.getUserRoleOrgId());
		if (role != null) {
			sysUser.setRoleId(role.getRoleid());
			sysUser.setRoleLvl(role.getLvl());
			sysUser.setRoleName(role.getRolename());
			sysUser.setRoleType(role.getRoleType());
			su.setRoleId(role.getRoleid());
			su.setRoleLvl(role.getLvl());
			su.setRoleName(role.getRolename());
			su.setRoleType(role.getRoleType());
		}
		logger.info("saveSysUserOrgRole >>" + sysUser.getOrgId() + " - " + role.getOrgId());
		OrgInfo info = null;
		if (null != sysUser.getOrgId() && !"".equals(sysUser.getOrgId())) {

			info = orgInfoDao.findById(sysUser.getOrgId());
		}
		if (info == null && null != role.getOrgId() && !"".equals(role.getOrgId())) {

			info = orgInfoDao.findById(role.getOrgId());
		}
		if (info != null) {
			sysUser.setParentOrgId(info.getParentId());
			sysUser.setParentOrgName(info.getParentName());
			sysUser.setOrgCategory(info.getOrgCategory());
			sysUser.setOrgId(info.getOrgid());
			sysUser.setOrgName(info.getOrgname());
			sysUser.setOrgType(info.getOrgType());
			su.setOrgCategory(info.getOrgCategory());
			su.setOrgId(info.getOrgid());
			su.setOrgName(info.getOrgname());
			su.setOrgType(info.getOrgType());
			su.setParentOrgId(info.getParentId());
			su.setParentOrgName(info.getParentName());
		}

		sysUserDao.saveSysUserOrgRole(su);
		// 其他角色
		if (null != sysUser.getRoleId1() && !"".equals(sysUser.getRoleId1())) {
			saveSysUserOrgRole2(sysUser.getRoleId1(), 1, sysUser.getUserid(), sysUser.getCompanyId());
		}
		if (null != sysUser.getRoleId2() && !"".equals(sysUser.getRoleId2())) {
			saveSysUserOrgRole2(sysUser.getRoleId1(), 2, sysUser.getUserid(), sysUser.getCompanyId());
		}
	}

	private void saveSysUserOrgRole2(String roleId, int sort, String userid, String companyId) {
		SysRole role = sysRoleDao.findById(roleId);
		SysUserOrgRole su = new SysUserOrgRole();
		su.setUserid(userid);
		su.setCompanyId(companyId);
		su.setSort(sort);
		su.setUserRoleOrgId(su.getUserid() + su.getSort());
		if (role != null) {
			su.setRoleId(role.getRoleid());
			su.setRoleLvl(role.getLvl());
			su.setRoleName(role.getRolename());
			su.setRoleType(role.getRoleType());
		}
		if (null != role.getOrgId()) {
			OrgInfo info = orgInfoDao.findById(role.getOrgId());
			if (info != null) {
				su.setOrgCategory(info.getOrgCategory());
				su.setOrgId(info.getOrgid());
				su.setOrgName(info.getOrgname());
				su.setOrgType(info.getOrgType());
				su.setParentOrgId(info.getParentId());
				su.setParentOrgName(info.getParentName());
			}
		}
		sysUserDao.saveSysUserOrgRole(su);
	}

	@Override
	public void updatePwd(String userid, String pwd) {
		sysUserDao.updatePwd(userid, pwd);
	}

	@Override
	public void updateActiveFlag(SysUser su) {
		if (Enums.Status.Enable.getValue() == su.getActiveFlag()) {
			String mobile = su.getBind_mobile() == null ? "AAA" : su.getBind_mobile();
			String openid = su.getOpenid() == null ? "AAA" : su.getOpenid();
			sysUserDao.updateforbidOrder(su.getCompanyId(), su.getUserid(), mobile, openid);

		}
		sysUserDao.updateActiveFlag(su.getUserid(), su.getActiveFlag());
	}

	/**
	 * 删除用户管理
	 */
	@Override
	public void delete(String userid) {
		sysUserDao.deleteSysUserOrgRoleByUserid(userid);
		sysUserDao.delete(userid);
		userExtService.delete(userid);
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
		if (null != list && list.size() > 0) {
			List<String> userids = new ArrayList<String>();
			for (SysUser user : list) {
				userids.add(user.getUserid());
			}
			List<SysUserOrgRole> roleList = sysUserDao.findUserRoleByUserids(userids);
			if (null != roleList && roleList.size() > 0) {
				for (SysUser user : list) {
					for (SysUserOrgRole role : roleList) {
						if (user.getUserid().equals(role.getUserid()) && role.getSort() == 1) {
							user.setRoleId1(role.getRoleId());
						} else if (user.getUserid().equals(role.getUserid()) && role.getSort() == 2) {
							user.setRoleId2(role.getRoleId());
						}
					}
				}
			}
		}
		PageList<SysUser> pageList = (PageList<SysUser>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public void updateUnMobile(String companyId, String mobile) {
		sysUserDao.updateUnMobile(companyId, mobile);
	}

	@Override
	public void updateMobile(String userid, String newPhone) {
		sysUserDao.updateMobile(userid, newPhone);
	}

	@Override
	public void updateSkin(String userid, int skin) {
		sysUserDao.updateSkin(userid, skin);
	}

	@Override
	public void updateUnbinding(String accountId, String openid) {
		sysUserDao.updateUnbinding(accountId, openid);
	}

	@Override
	public void updateBinding(SysUser user) {
		sysUserDao.updateBinding(user);
	}

	@Override
	public Result saveOrUpdate(SysUser sysUser) {
		Result result = new Result();
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyId", sysUser.getCompanyId());
		param.put("userid", sysUser.getUserid());
		param.put("mobile", sysUser.getBind_mobile());
		List<SysUser> ori = sysUserDao.findByParams(param);
		if (null != ori && ori.size() > 1) {
			result.setCode("2001");
			result.setMessage("数据错误");
			return result;
		}
		if (null != ori && ori.size() == 1) {
			result = this.update(sysUser);
		} else {
			result = this.save(sysUser);
		}
		return result;
	}

}