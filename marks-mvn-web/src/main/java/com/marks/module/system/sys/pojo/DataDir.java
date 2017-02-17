package com.marks.module.system.sys.pojo;

import java.util.ArrayList;
import java.util.List;

public class DataDir {

	private String ckey;
	private String parentkey;
	private String cvalue;
	private int sort;
	private List<DataDir> children=new ArrayList<DataDir>();

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
	public List<DataDir> getChildren() {
		return children;
	}
	public void addChildren(DataDir children) {
		this.children.add(children);
	}
	public String getCid() {
		return ckey+parentkey;
	}
	
}
