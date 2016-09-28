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
	private String roleid;//角色
	private Date loginTime;
	private String shopid;
	private List<String> userUrlList = new ArrayList<String>();

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

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
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
