package com.marks.module.system.myimage.pojo;

import java.io.Serializable;
import java.util.Date;

public class MyImage implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    *
    */
    private String picId;
    /**
    *名称
    *
    */
    private String picName;
    /**
    *路径
    *
    */
    private String picUrl;
    /**
    *创建时间
    *
    */
    private Date createtime;
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

	public String getPicId() {
        return picId;
    }
    public void setPicId(String picId){
        this.picId = picId;
    }

    public String getPicName(){
        return picName;
    }
    public void setPicName(String picName){
        this.picName = picName;
    }

    public String getPicUrl(){
        return picUrl;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }


	public String toLog(){
		return " - picId:" +String.valueOf(picId)+" - picName:" +String.valueOf(picName)+" - picUrl:" +String.valueOf(picUrl)+" - createtime:" +String.valueOf(createtime)+" - creator:" +String.valueOf(creator);
	}
}