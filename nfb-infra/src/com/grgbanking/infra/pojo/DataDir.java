package com.grgbanking.infra.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDir implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ckey;
	private String parentkey;
	private String cvalue;
	private int sort;
	private String typename;
	private Date creattime;
	private Date updatetime;
	private String creator;
	private List<DataDir> children = new ArrayList<DataDir>();

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public String getParentkey() {
		return parentkey;
	}

	public void setParentkey(String parentkey) {
		this.parentkey = parentkey;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
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

	public List<DataDir> getChildren() {
		return children;
	}

	public void addChildren(DataDir children) {
		this.children.add(children);
	}

	@Override
	public int hashCode() {
		return ckey.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DataDir)
			return ckey.equals(((DataDir) obj).ckey) && parentkey.equals(((DataDir) obj).parentkey);
		else
			return false;
	}
}
