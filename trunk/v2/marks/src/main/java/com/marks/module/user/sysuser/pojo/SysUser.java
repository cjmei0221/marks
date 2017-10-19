package com.marks.module.user.sysuser.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	private String openid;
	private String accountid;
	
	private int skin;

	private int hideFlag = 0;// 隐藏标识 1:隐藏

	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;

	private List<String> userUrlList = new ArrayList<String>();

	private Date loginTime;

	private String companyId;
	/**
	 * 用户ID
	 */
	private String roleid;
	private String rolename;
	private int roleLvl;
	
	private String defaultOrgid;
	private String defaultOrgname;

	private String orgidsStr;
	private String orgidNamesStr;

	private String queryOrgid;// 查询字段

	public int getHideFlag() {
		return hideFlag;
	}

	public void setHideFlag(int hideFlag) {
		this.hideFlag = hideFlag;
	}

	public String getOrgidsStr() {
		return orgidsStr;
	}

	public void setOrgidsStr(String orgidsStr) {
		this.orgidsStr = orgidsStr;
	}

	public String getOrgidNamesStr() {
		return orgidNamesStr;
	}

	public void setOrgidNamesStr(String orgidNamesStr) {
		this.orgidNamesStr = orgidNamesStr;
	}

	public int getRoleLvl() {
		return roleLvl;
	}

	public void setRoleLvl(int roleLvl) {
		this.roleLvl = roleLvl;
	}

	public String getQueryOrgid() {
		return queryOrgid;
	}

	public void setQueryOrgid(String queryOrgid) {
		this.queryOrgid = queryOrgid;
	}

	public String getDefaultOrgid() {
		return defaultOrgid;
	}

	public void setDefaultOrgid(String defaultOrgid) {
		this.defaultOrgid = defaultOrgid;
	}

	public String getDefaultOrgname() {
		return defaultOrgname;
	}

	public void setDefaultOrgname(String defaultOrgname) {
		this.defaultOrgname = defaultOrgname;
	}
	

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(int bindFlag) {
		this.bindFlag = bindFlag;
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