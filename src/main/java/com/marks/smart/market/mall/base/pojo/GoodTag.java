package com.marks.smart.market.mall.base.pojo;

import java.io.Serializable;

public class GoodTag implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *标签ID
    *
    */
    private String tagId;
    /**
    *标签
    *
    */
    private String tagName;
    /**
    *图片
    *
    */
    private String picUrl;
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
    *更新时间
    *
    */
    private String updatetime;
    /**
    *logo
    *
    */
    private String logo;
    /**
    *创建者
    *
    */
    private String creator;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *启禁用
    *0:禁用。1启动
    */
    private int status;
    /**
    *标签类别
    *0:价格 1:年龄段
    */
    private int tagType;



    public String getTagId(){
        return tagId;
    }
    public void setTagId(String tagId){
        this.tagId = tagId;
    }

    public String getTagName(){
        return tagName;
    }
    public void setTagName(String tagName){
        this.tagName = tagName;
    }

    public String getPicUrl(){
        return picUrl;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }

    public String getTypeId(){
        return typeId;
    }
    public void setTypeId(String typeId){
        this.typeId = typeId;
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getLogo(){
        return logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }

    public int getTagType(){
        return tagType;
    }
    public void setTagType(int tagType){
        this.tagType = tagType;
    }


	public String toLog(){
		return " - tagId:" +String.valueOf(tagId)+" - tagName:" +String.valueOf(tagName)+" - picUrl:" +String.valueOf(picUrl)+" - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - logo:" +String.valueOf(logo)+" - creator:" +String.valueOf(creator)+" - companyId:" +String.valueOf(companyId)+" - status:" +String.valueOf(status)+" - tagType:" +String.valueOf(tagType);
	}
}