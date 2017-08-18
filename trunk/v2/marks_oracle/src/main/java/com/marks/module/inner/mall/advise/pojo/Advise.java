package com.marks.module.inner.mall.advise.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Advise implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String ID;
    /**
    *商品描述
    */
    private String content;
    /**
    *标签
    */
    private String label;
    /**
    *定制数量
    */
    private int num;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *用户ID
    */
    private String userid;
    /**
    *手机号码
    */
    private String mobile;



    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label = label;
    }

    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
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

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }


}