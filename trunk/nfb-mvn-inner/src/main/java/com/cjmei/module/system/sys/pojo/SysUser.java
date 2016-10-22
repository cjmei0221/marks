package com.cjmei.module.system.sys.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userid;// 用户账号
	private String username;// 用户昵称
	private String password;// 密码
	private String tel;// 用户手机号
	private int activeflag;// 状态 0:启用 1：禁用
	private Date createtime;
	private Date updatetime;
	private String userType;//角色ID
	private Date loginTime;
	private List<String> orgIds=new ArrayList<String>();
	
	private List<String> userUrlList = new ArrayList<String>();

	private List<String> roleIds=new ArrayList<String>();
	
	private String companyId;
	
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(int activeflag) {
		this.activeflag = activeflag;
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

	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public List<String> getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(List<String> orgIds) {
		this.orgIds = orgIds;
	}

	@Override
	public int hashCode() {
		return userid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysUser)
			return userid.equals(((SysUser) obj).userid);
		else
			return false;
	}


}
