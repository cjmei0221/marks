package com.marks.module.wx.manage.base.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxMenuUrl implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *菜单名称
    */
    private String menuName;
    /**
    *菜单URL
    */
    private String menuUrl;
    /**
    *公众号ID
    */
    private String accountid;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getMenuName(){
        return menuName;
    }
    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getMenuUrl(){
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl){
        this.menuUrl = menuUrl;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }


}