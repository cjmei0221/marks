package com.marks.module.org.area.pojo;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 区域编号
	 *
	 */
	private String areaId;
	/**
	 * 区域名称
	 *
	 */
	private String areaName;
	/**
	 * 公司ID
	 *
	 */
	private String companyId;
	/**
	 * 级别
	 *
	 */
	private int lvl;
	/**
	 * 创建时间
	 *
	 */
	private Date createtime;
	/**
	 * 更新时间
	 *
	 */
	private Date updatetime;
	/**
	 * 上级编号
	 *
	 */
	private String parentId;
	/**
	 * 上级名称
	 *
	 */
	private String parentName;

	private String state = "open";

	/**
	 * 级别1编号
	 *
	 */
	private String lvl1Id;
	/**
	 * 级别1名称
	 *
	 */
	private String lvl1Name;
	/**
	 * 级别2编号
	 *
	 */
	private String lvl2Id;
	/**
	 * 级别2名称
	 *
	 */
	private String lvl2Name;
	/**
	 * 级别3编号
	 *
	 */
	private String lvl3Id;
	/**
	 * 级别3名称
	 *
	 */
	private String lvl3Name;
	/**
	 * 级别4编号
	 *
	 */
	private String lvl4Id;
	/**
	 * 级别4名称
	 *
	 */
	private String lvl4Name;
	/**
	 * 级别5编号
	 *
	 */
	private String lvl5Id;
	/**
	 * 级别5名称
	 *
	 */
	private String lvl5Name;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return areaId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getText() {
		return areaName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getLvl1Id() {
		return lvl1Id;
	}

	public void setLvl1Id(String lvl1Id) {
		this.lvl1Id = lvl1Id;
	}

	public String getLvl1Name() {
		return lvl1Name;
	}

	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
	}

	public String getLvl2Id() {
		return lvl2Id;
	}

	public void setLvl2Id(String lvl2Id) {
		this.lvl2Id = lvl2Id;
	}

	public String getLvl2Name() {
		return lvl2Name;
	}

	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}

	public String getLvl3Id() {
		return lvl3Id;
	}

	public void setLvl3Id(String lvl3Id) {
		this.lvl3Id = lvl3Id;
	}

	public String getLvl3Name() {
		return lvl3Name;
	}

	public void setLvl3Name(String lvl3Name) {
		this.lvl3Name = lvl3Name;
	}

	public String getLvl4Id() {
		return lvl4Id;
	}

	public void setLvl4Id(String lvl4Id) {
		this.lvl4Id = lvl4Id;
	}

	public String getLvl4Name() {
		return lvl4Name;
	}

	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
	}

	public String getLvl5Id() {
		return lvl5Id;
	}

	public void setLvl5Id(String lvl5Id) {
		this.lvl5Id = lvl5Id;
	}

	public String getLvl5Name() {
		return lvl5Name;
	}

	public void setLvl5Name(String lvl5Name) {
		this.lvl5Name = lvl5Name;
	}

	public String toLog() {
		return " - areaId:" + String.valueOf(areaId) + " - areaName:" + String.valueOf(areaName) + " - companyId:"
				+ String.valueOf(companyId) + " - lvl:" + String.valueOf(lvl) + " - createtime:"
				+ String.valueOf(createtime) + " - updatetime:" + String.valueOf(updatetime) + " - parentId:"
				+ String.valueOf(parentId) + " - parentName:" + String.valueOf(parentName) + " - lvl1Id:"
				+ String.valueOf(lvl1Id) + " - lvl1Name:" + String.valueOf(lvl1Name) + " - lvl2Id:"
				+ String.valueOf(lvl2Id) + " - lvl2Name:" + String.valueOf(lvl2Name) + " - lvl3Id:"
				+ String.valueOf(lvl3Id) + " - lvl3Name:" + String.valueOf(lvl3Name) + " - lvl4Id:"
				+ String.valueOf(lvl4Id) + " - lvl4Name:" + String.valueOf(lvl4Name) + " - lvl5Id:"
				+ String.valueOf(lvl5Id) + " - lvl5Name:" + String.valueOf(lvl5Name);
	}
}