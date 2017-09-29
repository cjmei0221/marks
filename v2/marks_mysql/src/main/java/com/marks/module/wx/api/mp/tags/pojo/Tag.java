package com.marks.module.wx.api.mp.tags.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户标签
 * @author cjmei
 *
 */
public class Tag {
	
	private int id;//标签id
	private String name;//标签名
	private int count;//此标签下的粉丝数
	private List<String> openidList=new ArrayList<String>();
	private String next_openid;
	
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	public List<String> getOpenidList() {
		return openidList;
	}
	public void setOpenidList(List<String> openidList) {
		this.openidList = openidList;
	}
	public void addOpenid(String openid) {
		this.openidList.add(openid);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
