package com.marks.smart.system.user.sysuser.pojo;

public class SysUserOrgRole {

	private String userRoleOrgId;// 主键

	private String userid;
	private String companyId;
	/**
	 * 用户ID
	 */
	private String roleId;
	private String roleName;
	private String roleType;
	private int roleLvl;

	private String orgId;
	private String orgName;
	private int orgType;
	private int orgCategory;
	private String updatetime;
	private String parentOrgId;
	private String parentOrgName;
	private int sort;

	public String getUserRoleOrgId() {
		return userRoleOrgId;
	}

	public void setUserRoleOrgId(String userRoleOrgId) {
		this.userRoleOrgId = userRoleOrgId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public int getRoleLvl() {
		return roleLvl;
	}

	public void setRoleLvl(int roleLvl) {
		this.roleLvl = roleLvl;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public int getOrgCategory() {
		return orgCategory;
	}

	public void setOrgCategory(int orgCategory) {
		this.orgCategory = orgCategory;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

	public String getShowName() {
		String str = "";
		if (this.getOrgName() != null && !"".equals(this.getOrgName())
				&& !this.getOrgId().equals(this.getCompanyId())) {
			str = this.getOrgName() + " / ";
		}
		return str = str + this.getRoleName();
	}
}
