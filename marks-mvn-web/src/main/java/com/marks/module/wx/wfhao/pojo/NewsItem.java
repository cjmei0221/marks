package com.marks.module.wx.wfhao.pojo;

import java.io.Serializable;

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



    public String getId(){
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


}