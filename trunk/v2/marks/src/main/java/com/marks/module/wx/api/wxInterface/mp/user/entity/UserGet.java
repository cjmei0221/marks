package com.marks.module.wx.api.wxInterface.mp.user.entity;

import java.util.ArrayList;
import java.util.List;

public class UserGet {

	private String next_openid;
	
	private List<String> openid_list=new ArrayList<String>();

	private int total;// 总个数

	private int count;// 总个数

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getNext_openid() {
		return next_openid;
	}

	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	
	public List<String> getOpenid_list() {
		return openid_list;
	}

	public void setOpenid_list(List<String> openid_list) {
		this.openid_list = openid_list;
	}

	public void addOpenid(String openid){
		openid_list.add(openid);
	}
}
