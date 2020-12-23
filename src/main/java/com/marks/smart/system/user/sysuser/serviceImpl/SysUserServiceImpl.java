package com.marks.smart.system.user.sysuser.serviceImpl;

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
import com.marks.common.enums.UserEnums;
import com.marks.smart.count.acct.base.service.UserExtService;
import com.marks.smart.system.org.orginfo.dao.OrgInfoDao;
import com.marks.smart.system.org.orginfo.pojo.OrgInfo;
import com.marks.smart.system.user.sysrole.dao.SysRoleDao;
import com.marks.smart.system.user.sysrole.pojo.SysRole;
import com.marks.smart.system.user.sysuser.dao.SysUserDao;
import com.marks.smart.system.user.sysuser.dao.UserLogDao;
import com.marks.smart.system.user.sysuser.pojo.SysUser;
import com.marks.smart.system.user.sysuser.pojo.SysUserOrgRole;
import com.marks.smart.system.user.sysuser.service.SysUserService;

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
	@Autowired
	private UserLogDao userLogDao;

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
	public SysUser findById(String companyId, String id) {
		return sysUserDao.findById(companyId, id);
	}

	@Override
	public Result saveOrUpdate(SysUser user) {
		Result result = new Result();
		String userid = "";
		// 判断userid
		Map<String, String> params = new HashMap<String, String>();
		params.put("companyId", user.getCompanyId());
		// 若userid不为空，则更新
		if (null != user.getUserid() && user.getUserid().length() > 4) {
			params.put("userid", user.getUserid());
		} else {
			params.put("openid", user.getOpenid());
			params.put("mobile", user.getBind_mobile());
			params.put("activeFlag", "1");
		}
		List<SysUser> oldList = sysUserDao.findByParams(params);
		if (null != oldList && oldList.size() > 0) {
			SysUser old = oldList.get(0);
			if (UserEnums.RoleYwType.defaultUser.getValue() == old.getRoleYwType()) {
				result.setCode("2001");
				result.setMessage("默认用户不可修改");
				return result;
			}
			if (!UserEnums.UserType.VIP.getValue().equals(old.getRoleType())
					&& UserEnums.UserType.VIP.getValue().equals(user.getRoleType())) {
				result.setCode("2002");
				result.setMessage("此手机号码已被员工注册");
				return result;
			}
			// 如果原会员，而新为其他角色，则禁用原来的会员
			if (UserEnums.UserType.VIP.getValue().equals(old.getRoleType())
					&& !UserEnums.UserType.VIP.getValue().equals(user.getRoleType())) {
				userid = this.save(user);
				result.getData().put("userid", userid);
				return result;
			}
			userid = old.getUserid();
			user.setUserid(userid);
			this.update(old, user);
			result.getData().put("userid", userid);
			return result;
		}
		// 如果没有用户，则可恢复旧会员身份
		if (UserEnums.UserType.VIP.getValue().equals(user.getRoleType())) {
			params.put("activeFlag", "");
			params.put("roleType", UserEnums.UserType.VIP.getValue());
			oldList = sysUserDao.findByParams(params);
			if (null != oldList && oldList.size() > 0) {
				SysUser old = oldList.get(0);
				userid = old.getUserid();
				user.setUserid(userid);
				this.update(old, user);
				result.getData().put("userid", userid);
				return result;
			}
		}
		userid = this.save(user);
		result.getData().put("userid", userid);
		return result;

	}

	/**
	 * 保存用户管理
	 */
	private String save(SysUser sysUser) {
		boolean unbindFlag = false;
		if (null != sysUser.getBind_mobile() && sysUser.getBind_mobile().length() > 4) {
			unbindFlag = true;
		}
		if (null != sysUser.getOpenid() && sysUser.getOpenid().length() > 4) {
			unbindFlag = true;
		}
		if (unbindFlag) {
			Map<String, String> param = new HashMap<String, String>();
			param.put("companyId", sysUser.getCompanyId());
			param.put("mobile", sysUser.getBind_mobile());
			param.put("openid", sysUser.getOpenid());
			sysUserDao.undateUnbindByTelOrOpenid(param);
		}
		String userCode = getUserCode(sysUser.getCompanyId(), sysUser.getRoleYwType());
//		String userid = sysUser.getCompanyId() + userCode;
		String userid = this.getUserId(sysUser.getCompanyId());
		if (UserEnums.RoleYwType.defaultUser.getValue() == sysUser.getRoleYwType()) {
			userid = sysUser.getUserid();
		}
		if (UserEnums.RoleYwType.sysUser.getValue() == sysUser.getRoleYwType()) {
			sysUser.setOrgId(sysUser.getCompanyId());
		}
		OrgInfo company = orgInfoDao.findById(sysUser.getCompanyId());
		if (company != null) {
			sysUser.setCompanyName(company.getOrgname());
		}
		sysUser.setUserid(userid);
		sysUser.setUserCode(userCode);

		if (null == sysUser.getUsername() || "".equals(sysUser.getUsername())) {
			sysUser.setUsername(sysUser.getBind_mobile());
		}
		saveSysUserOrgRole(sysUser);
		sysUserDao.save(sysUser);
		saveUserExt(sysUser);
		saveUserLog(sysUser);
		return userid;
	}

	private void saveUserExt(SysUser sysUser) {
		userExtService.saveOrUpdate(sysUser);
	}

	private void saveUserLog(SysUser sysUser) {
		userLogDao.save(sysUser);
	}

	public synchronized String getUserId(String companyId) {
		String num = companyId + "100000";
		String maxCode = sysUserDao.getUserId(companyId);
		if (null != maxCode && maxCode.length() > 4) {
			num = maxCode;
		}
		return String.valueOf(Integer.parseInt(num) + 1);
	}

	public String getUserCode(String companyId, int roleYwType) {
		String userCode = "";
		long initcode = 0;
		String maxCode = "";
		logger.info(companyId + " - " + roleYwType);
		if (roleYwType == UserEnums.RoleYwType.vip.getValue()) {
			maxCode = sysUserDao.getMaxCode(companyId, roleYwType);
			if (null == maxCode || "".equals(maxCode)) {
				maxCode = "100000";
			}
		} else {
			maxCode = sysUserDao.getMaxCode(companyId, roleYwType);
			if (null == maxCode || "".equals(maxCode)) {
				maxCode = "0";
			}
		}

		initcode = Long.parseLong(maxCode);
		userCode = String.valueOf(initcode + 1);
		if (userCode.length() == 1) {
			userCode = "0" + userCode;
		}
		return userCode;
	}

	/**
	 * 更新用户管理
	 */
	public void update(SysUser old, SysUser user) {
		boolean unbindFlag = false;
		if (null != user.getBind_mobile() && user.getBind_mobile().length() > 4) {
			unbindFlag = true;
		}
		if (null != user.getOpenid() && user.getOpenid().length() > 4) {
			unbindFlag = true;
		}
		if (unbindFlag) {
			Map<String, String> param = new HashMap<String, String>();
			param.put("companyId", user.getCompanyId());
			param.put("mobile", user.getBind_mobile());
			param.put("openid", user.getOpenid());
			sysUserDao.undateUnbindByTelOrOpenid(param);
		}
		if (null == user.getOpenid() || "".equals(user.getOpenid())) {
			user.setOpenid(old.getOpenid());
			user.setAccountid(old.getAccountid());
			user.setBindFlag(old.getBindFlag());
		}
		if (null == user.getBind_mobile() || "".equals(user.getBind_mobile())) {
			user.setBind_mobile(old.getBind_mobile());
		}
		if (null == user.getLabels() || "".equals(user.getLabels())) {
			user.setLabels(old.getLabels());
		}
		if (UserEnums.UserType.VIP.getValue().equals(user.getRoleType())) {
			if (null == user.getOrgId() || "".equals(user.getOrgId())) {
				user.setOrgId(old.getOrgId());
			}
		}
		saveSysUserOrgRole(user);
		if (null == user.getUsername() || "".equals(user.getUsername())) {
			user.setUsername(user.getBind_mobile());
		}
		sysUserDao.update(user);
		saveUserExt(user);
		saveUserLog(user);
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
		logger.info("saveSysUserOrgRole >>" + sysUser.getRoleType() + " - " + role.getOrgId());
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

	public PojoDomain<SysUser> listActive(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<SysUser> pojoDomain = new PojoDomain<SysUser>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SysUser> list = sysUserDao.listActive(pageBounds, param);
		PageList<SysUser> pageList = (PageList<SysUser>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
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
	public void updateSkin(String userid, int skin) {
		sysUserDao.updateSkin(userid, skin);
	}

	@Override
	public void updateUnbinding(String accountId, String openid) {
		sysUserDao.updateUnbinding(accountId, openid);
	}

	@Override
	public void updateOrgName(String orgId, String orgName) {
		sysUserDao.updateOrgName(orgId, orgName);
		sysUserDao.updateCompanyName(orgId, orgName);
		sysUserDao.updateUserRoleOrg(orgId, orgName);
	}

}