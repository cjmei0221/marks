package com.cjmei.module.wx.wxmenu.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxMenu implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *父ID
    */
    private String parent_id;
    /**
    *菜单名称
    */
    private String name;
    /**
    *菜单类型
    */
    private String type;
    /**
    *访问内容
    */
    private String content;
    /**
    *排序
    */
    private int sort;
    /**
    *公众ID
    */
    private String accountid;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getParent_id(){
        return parent_id;
    }
    public void setParent_id(String parent_id){
        this.parent_id = parent_id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
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