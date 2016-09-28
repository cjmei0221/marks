package com.cjmei.module.system.sys.pojo;

import java.util.Date;

public class SysOperate {

	private String operid;
	private String opername;
	private String operkey;
	private Date createtime;
	private Date updatetime;
	private String creator;
	private String picicon;

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public String getOperkey() {
		return operkey;
	}

	public void setOperkey(String operkey) {
		this.operkey = operkey;
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

	public String getPicicon() {
		return picicon;
	}

	public void setPicicon(String picicon) {
		this.picicon = picicon;
	}

	@Override
	public int hashCode() {
		return operid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysOperate)
			return operid.equals(((SysOperate) obj).operid);
		else
			return false;
	}
}
