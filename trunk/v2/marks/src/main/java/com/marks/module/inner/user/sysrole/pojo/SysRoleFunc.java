package com.marks.module.inner.user.sysrole.pojo;

import java.util.Date;

public class SysRoleFunc {

	private String roleid;
	private String funcid;
	private Date createtime;
	private Date updatetime;
	private String creator;
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getFuncid() {
		return funcid;
	}
	public void setFuncid(String funcid) {
		this.funcid = funcid;
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
		if (obj instanceof SysRoleFunc)
			return funcid.equals(((SysRoleFunc) obj).funcid) && roleid==((SysRoleFunc) obj).roleid;
		else
			return false;
	}
}
