package com.marks.module.wx.manage.base.pojo;

import java.io.Serializable;
import java.util.Date;

import com.marks.module.wx.api.wxfwhao.wxmenu.pojo.WxMenu;

public class MyWxMenu extends WxMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 排序
	 */
	private int sort;

	private int lvl = 0;

	private int childnum = 0;
	private String tagname;// 标签名称
	private String state = "open";

	private String updater;

	private Date updatetime;

	private int delflag;// 是否可以删除标识

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getChildnum() {
		return childnum;
	}

	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}
}