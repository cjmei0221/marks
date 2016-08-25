package com.grgbanking.inner.po.sys;

import java.util.Date;

public class SysFunc {

	private String funcid;
	private String menuid;
	private String operid;
	private Date createtime;
	private Date updatetime;
	private String creator;
	private String url;
	public String getFuncid() {
		return funcid;
	}
	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getOperid() {
		return operid;
	}
	public void setOperid(String operid) {
		this.operid = operid;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		return funcid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysMenu)
			return funcid.equals(((SysFunc) obj).funcid);
		else
			return false;
	}
}
