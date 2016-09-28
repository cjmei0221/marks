package com.cjmei.module.system.sys.pojo;

import java.util.Date;

public class SysRole {
	
	private String roleid;
	private String rolename;
	private Date createtime;
	private Date updatetime;
	private String creator;
	private String orgid;//所属商铺
	private int lvl;//级别，默认1 超级管理员为0
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
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	@Override
	public int hashCode() {
		return roleid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysRole)
			return roleid==((SysRole) obj).roleid;
		else
			return false;
	}
}
