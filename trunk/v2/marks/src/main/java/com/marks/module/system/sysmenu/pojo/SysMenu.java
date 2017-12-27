package com.marks.module.system.sysmenu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenu {

	private String menuid;
	private String parentid;
	private String menuitem;
	private String url;
	private int sort;
	private Date createtime;
	private Date updatetime;
	private String creator;
	private List<SysMenu> children=new ArrayList<SysMenu>();
	
	private List<SysFunc> oper_list=new ArrayList<SysFunc>();
	
	private int lvl;// 级别
	private String lvl1Menuid;
	private String lvl2Menuid;
	private String state = "open";

	private int status = 1;// 禁用 1:启用 2:禁用

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getLvl1Menuid() {
		return lvl1Menuid;
	}

	public void setLvl1Menuid(String lvl1Menuid) {
		this.lvl1Menuid = lvl1Menuid;
	}

	public String getLvl2Menuid() {
		return lvl2Menuid;
	}

	public void setLvl2Menuid(String lvl2Menuid) {
		this.lvl2Menuid = lvl2Menuid;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
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
	public List<SysMenu> getChildren() {
		return children;
	}
	public void addChildren(SysMenu childMenu) {
		this.children.add(childMenu);
	}
	
	public List<SysFunc> getOper_list() {
		return oper_list;
	}

	public void addOper(SysFunc sysFunc) {
		oper_list.add(sysFunc);
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}
	@Override
	public int hashCode() {
		return menuid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysMenu)
			return menuid.equals(((SysMenu) obj).menuid);
		else
			return false;
	}
}
