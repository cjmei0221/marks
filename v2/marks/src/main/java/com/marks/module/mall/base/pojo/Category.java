package com.marks.module.mall.base.pojo;

import java.io.Serializable;

public class Category implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *品类ID
    *
    */
	private String typeId;
    /**
    *品类
    *
    */
	private String typeName;
    /**
    *创建时间
    *
    */
	private String createtime;
    /**
    *上一级编号
    *
    */
	private String parentId;
    /**
    *上一级姓名
    *
    */
	private String parentName;
    /**
    *更新时间
    *
    */
	private String updatetime;
    /**
    *图片
    *
    */
    private String picUrl;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *级别1ID
    *
    */
    private String lvl1Id;
    /**
    *级别1姓名
    *
    */
    private String lvl1Name;
    /**
    *级别2ID
    *
    */
    private String lvl2Id;
    /**
    *级别2姓名
    *
    */
    private String lvl2Name;
    /**
    *级别3ID
    *
    */
    private String lvl3Id;
    /**
    *级别3姓名
    *
    */
    private String lvl3Name;
    /**
    *级别4ID
    *
    */
    private String lvl4Id;
    /**
    *级别4姓名
    *
    */
    private String lvl4Name;
    /**
    *级别5ID
    *
    */
    private String lvl5Id;
    /**
    *级别5姓名
    *
    */
    private String lvl5Name;
    /**
    *级别
    *
    */
    private int lvl;
    /**
    *状态
    *
    */
    private int status;


	private String state = "open";


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeId() {
		return typeId;
	}

	public String getId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getText() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public String getCreatetime() {
        return createtime;
    }

	public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


	public String getUpdatetime() {
        return updatetime;
    }

	public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getPicUrl(){
        return picUrl;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getLvl1Id(){
        return lvl1Id;
    }
    public void setLvl1Id(String lvl1Id){
        this.lvl1Id = lvl1Id;
    }

    public String getLvl1Name(){
        return lvl1Name;
    }
    public void setLvl1Name(String lvl1Name){
        this.lvl1Name = lvl1Name;
    }

    public String getLvl2Id(){
        return lvl2Id;
    }
    public void setLvl2Id(String lvl2Id){
        this.lvl2Id = lvl2Id;
    }

    public String getLvl2Name(){
        return lvl2Name;
    }
    public void setLvl2Name(String lvl2Name){
        this.lvl2Name = lvl2Name;
    }

    public String getLvl3Id(){
        return lvl3Id;
    }
    public void setLvl3Id(String lvl3Id){
        this.lvl3Id = lvl3Id;
    }

    public String getLvl3Name(){
        return lvl3Name;
    }
    public void setLvl3Name(String lvl3Name){
        this.lvl3Name = lvl3Name;
    }

    public String getLvl4Id(){
        return lvl4Id;
    }
    public void setLvl4Id(String lvl4Id){
        this.lvl4Id = lvl4Id;
    }

    public String getLvl4Name(){
        return lvl4Name;
    }
    public void setLvl4Name(String lvl4Name){
        this.lvl4Name = lvl4Name;
    }

    public String getLvl5Id(){
        return lvl5Id;
    }
    public void setLvl5Id(String lvl5Id){
        this.lvl5Id = lvl5Id;
    }

    public String getLvl5Name(){
        return lvl5Name;
    }
    public void setLvl5Name(String lvl5Name){
        this.lvl5Name = lvl5Name;
    }

    public int getLvl(){
        return lvl;
    }
    public void setLvl(int lvl){
        this.lvl = lvl;
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }


	public String toLog(){
		return " - cId:" + String.valueOf(typeId) + " - cName:" + String.valueOf(typeName) + " - createtime:"
				+ String.valueOf(createtime) + " - pId:" + String.valueOf(parentId) + " - pName:"
				+ String.valueOf(parentName) + " - updatetime:" + String.valueOf(updatetime) + " - picUrl:"
				+ String.valueOf(picUrl) + " - companyId:" + String.valueOf(companyId) + " - lvl1Id:"
				+ String.valueOf(lvl1Id) + " - lvl1Name:" + String.valueOf(lvl1Name) + " - lvl2Id:"
				+ String.valueOf(lvl2Id) + " - lvl2Name:" + String.valueOf(lvl2Name) + " - lvl3Id:"
				+ String.valueOf(lvl3Id) + " - lvl3Name:" + String.valueOf(lvl3Name) + " - lvl4Id:"
				+ String.valueOf(lvl4Id) + " - lvl4Name:" + String.valueOf(lvl4Name) + " - lvl5Id:"
				+ String.valueOf(lvl5Id) + " - lvl5Name:" + String.valueOf(lvl5Name) + " - lvl:" + String.valueOf(lvl)
				+ " - status:" + String.valueOf(status);
	}
}