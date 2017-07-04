package com.marks.module.inner.system.sysuser.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marks.module.inner.system.orginfo.pojo.OrgInfo;
import com.marks.module.inner.system.sysrole.pojo.SysRole;

public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userid;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 绑定手机号码
	 */
	private String bind_mobile;
	/**
	 * 激活标识
	 */
	private int activeFlag;
	/**
	 * 激活标识
	 */
	private int bindFlag;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 口令
	 */
	private String token;
	
	private String fanId;
	
	private int skin;

	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;

	private List<String> userUrlList = new ArrayList<String>();

	private SysRole role;
	/**
	 * 用户管辖下所属机构ID集合
	 */
	private List<String> orgids = new ArrayList<String>();

	private List<String> accountids;

	private Date loginTime;

	private String companyId;
	private String companyNo;
	/**
	 * 用户ID
	 */
	private String roleid;
	private String rolename;
	private String orgidsStr;
	private String orgidNamesStr;
	/**
	 * 用户所属机构集合
	 */
	private List<OrgInfo> orgInfoList;
	
	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getFanId() {
		return fanId;
	}

	public void setFanId(String fanId) {
		this.fanId = fanId;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public String getOrgidNamesStr() {
		return orgidNamesStr;
	}

	public void setOrgidNamesStr(String orgidNamesStr) {
		this.orgidNamesStr = orgidNamesStr;
	}

	public List<OrgInfo> getOrgInfoList() {
		return orgInfoList;
	}

	public void setOrgInfoList(List<OrgInfo> orgInfoList) {
		this.orgInfoList = orgInfoList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBind_mobile() {
		return bind_mobile;
	}

	public void setBind_mobile(String bind_mobile) {
		this.bind_mobile = bind_mobile;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public List<String> getUserUrlList() {
		return userUrlList;
	}

	public void setUserUrlList(List<String> userUrlList) {
		this.userUrlList = userUrlList;
	}


	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public List<String> getOrgids() {
		return orgids;
	}

	public void setOrgids(List<String> orgids) {
		this.orgids = orgids;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrgidsStr() {
		return orgidsStr;
	}

	public void setOrgidsStr(String orgidsStr) {
		this.orgidsStr = orgidsStr;
	}

	public List<String> getAccountids() {
		return accountids;
	}

	public void setAccountids(List<String> accountids) {
		this.accountids = accountids;
	}

	public int getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(int bindFlag) {
		this.bindFlag = bindFlag;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}