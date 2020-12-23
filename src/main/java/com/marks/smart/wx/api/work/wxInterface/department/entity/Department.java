package com.marks.smart.wx.api.work.wxInterface.department.entity;
//部门
public class Department {
	/**
	 * 部门名称。长度限制为1~64个字节，字符不能包括\:*?"<>｜
	 * */
	private String name;
	/**
	 * 父亲部门id。根部门id为1
	 * */
	private String parentid;
	/**
	 * 在父部门中的次序值。order值小的排序靠前。
	 * */
	private String order;
	/**
	 * 部门id，整型。指定时必须大于1，不指定时则自动生成
	 * */
	private String id;
	
	public String getName() {
		return name;
	}
	public Department(String name, String parentid, String order, String id) {
		this.name = name;
		this.parentid = parentid;
		this.order = order;
		this.id = id;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
