package com.cjmei.module.system.sys.pojo;

import java.util.Date;

public class SysUserRole {

	private String userid;
	private String roleid;
	private Date createtime;
	private Date updatetime;
	private String creator;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
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
	public boolean equals(Object obj) {
		if (obj instanceof SysUserRole)
			return userid.equals(((SysUserRole) obj).userid) && roleid==((SysUserRole) obj).roleid;
		else
			return false;
	}
}