package com.grgbanking.inner.po.sys;

import java.util.Date;

public class SysRole {
	
	private int roleid;
	private String rolename;
	private Date createtime;
	private Date updatetime;
	private String creator;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
	@Override
	public int hashCode() {
		return roleid;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysRole)
			return roleid==((SysRole) obj).roleid;
		else
			return false;
	}
}
