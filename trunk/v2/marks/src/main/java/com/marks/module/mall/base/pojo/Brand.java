package com.marks.module.mall.base.pojo;

import java.io.Serializable;

public class Brand implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *编号
    *
    */
    private String brandId;
    /**
    *名称
    *
    */
    private String brandName;
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
    *Logo
    *
    */
    private String logo;
    /**
    *创建者
    *
    */
    private String creator;


    private String companyId;
    
    
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getBrandId() {
        return brandId;
    }
    public void setBrandId(String brandId){
        this.brandId = brandId;
    }

    public String getBrandName(){
        return brandName;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
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


	public String toLog(){
		return " - brandId:" +String.valueOf(brandId)+" - brandName:" +String.valueOf(brandName)+" - picUrl:" +String.valueOf(picUrl)+" - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - logo:" +String.valueOf(logo)+" - creator:" +String.valueOf(creator);
	}
}