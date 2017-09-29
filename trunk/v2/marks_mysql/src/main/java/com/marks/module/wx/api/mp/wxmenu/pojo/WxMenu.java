package com.marks.module.wx.api.mp.wxmenu.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WxMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String id;
	/**
	 * 父ID
	 */
	private String parent_id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单类型
	 */
	private String type;
	/**
	 * 访问内容
	 */
	private String content;

	/**
	 * 公众ID
	 */
	private String accountid;



	private List<WxMenu> children = new ArrayList<WxMenu>();
	private String menuid;// 微信个性化菜单ID
	private int menutype;// 菜单类型 0:普通菜单 1:个性化菜单
	private String tagid;// 标签ID


	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public int getMenutype() {
		return menutype;
	}

	public void setMenutype(int menutype) {
		this.menutype = menutype;
	}

	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}


	public List<WxMenu> getChildren() {
		return children;
	}

	public void setChildren(List<WxMenu> children) {
		this.children = children;
	}

	public void addChildren(WxMenu wx) {
		this.children.add(wx);
	}


}