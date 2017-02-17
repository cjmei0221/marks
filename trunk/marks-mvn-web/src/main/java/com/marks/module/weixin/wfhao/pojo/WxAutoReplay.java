package com.marks.module.weixin.wfhao.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxAutoReplay implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *父ID
    */
    private String parentType;
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

}