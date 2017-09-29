package com.marks.module.system.sysmenu.pojo;

import java.util.Date;

public class SysOperate {
	private String opername;
	private String operid;
	private Date createtime;
	private Date updatetime;
	private String creator;
	private String picicon;
	private int sort;
	
	private String funcid;
	private String url;

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
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

	public String getPicicon() {
		return picicon;
	}

	public void setPicicon(String picicon) {
		this.picicon = picicon;
	}
	

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	

	public String getFuncid() {
		return funcid;
	}

	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
