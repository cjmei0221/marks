package com.cjmei.module.wx.wxautoreplay.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxAutoReplay implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *父ID
    */
    private String cparentType;
    /**
    *关键字
    */
    private String ckey;
    /**
    *回复内容
    */
    private String creplay;
    /**
    *ID
    */
    private String ctype;
    /**
    *名称
    */
    private String ctypeName;
    /**
    *公众号ID
    */
    private String accountid;
    /**
    *回复方式
    */
    private String replayType;
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



    public String getCparentType(){
        return cparentType;
    }
    public void setCparentType(String cparentType){
        this.cparentType = cparentType;
    }

    public String getCkey(){
        return ckey;
    }
    public void setCkey(String ckey){
        this.ckey = ckey;
    }

    public String getCreplay(){
        return creplay;
    }
    public void setCreplay(String creplay){
        this.creplay = creplay;
    }

    public String getCtype(){
        return ctype;
    }
    public void setCtype(String ctype){
        this.ctype = ctype;
    }

    public String getCtypeName(){
        return ctypeName;
    }
    public void setCtypeName(String ctypeName){
        this.ctypeName = ctypeName;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public String getReplayType(){
        return replayType;
    }
    public void setReplayType(String replayType){
        this.replayType = replayType;
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


}