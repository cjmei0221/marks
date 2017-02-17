package com.cjmei.module.system.syslogparam.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysLogParam implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private String id;
    /**
    *来源
    */
    private int source;
    /**
    *功能名称
    */
    private String menuName;
    /**
    *操作名称
    */
    private String operName;
    /**
    *创建时间
    */
    private Date createtime;
    /**
    *更新时间
    */
    private Date updatetime;
    /**
    *创建者
    */
    private String creator;
    /**
    *访问链接
    */
    private String url;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getSource(){
        return source;
    }
    public void setSource(int source){
        this.source = source;
    }

    public String getMenuName(){
        return menuName;
    }
    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getOperName(){
        return operName;
    }
    public void setOperName(String operName){
        this.operName = operName;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }


}