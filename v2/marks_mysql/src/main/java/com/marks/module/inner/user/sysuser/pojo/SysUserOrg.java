package com.marks.module.inner.user.sysuser.pojo;

import java.util.Date;

public class SysUserOrg {

	private String userid;
	private String orgid;
	private Date createtime;
	private Date updatetime;
	private String creator;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
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
		if (obj instanceof SysUserOrg)
			return userid.equals(((SysUserOrg) obj).userid) && orgid==((SysUserOrg) obj).orgid;
		else
			return false;
	}
}
