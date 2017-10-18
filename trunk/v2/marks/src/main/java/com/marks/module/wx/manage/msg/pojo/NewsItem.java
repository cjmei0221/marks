package com.marks.module.wx.manage.msg.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class NewsItem implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *标题
    */
    private String title;
    /**
    *描述
    */
    private String description;
    /**
    *图片路径
    */
    private String picUrl;
    /**
    *链接
    */
    private String url;
    /**
    *排序
    */
    private int sort;
    /**
    *服务号ID
    */
    private String accountid;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *创建者
    */
    private String creator;


    private String text;

	private String companyId;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getPicUrl(){
        return picUrl;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public int getSort(){
        return sort;
    }
    public void setSort(int sort){
        this.sort = sort;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
	public String getText() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return this.getTitle()+"("+sdf.format(this.getUpdatetime())+")";
	}
	public void setText(String text) {
		this.text = text;
	}
}