package com.marks.module.note.transaction.pojo;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *事务类型
    */
    private int tranType;
    /**
    *特殊日期
    */
    private Date tranDate;
    /**
    *是否重复
    */
    private int isRepeat;
    /**
    *提醒内容
    */
    private String tranContent;
    /**
    *提前天数
    */
    private int aheadDays;
    /**
    *提醒时间
    */
    private String tranTime;
    /**
    *是否提前提醒
    */
    private int isAhead;
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



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getTranType(){
        return tranType;
    }
    public void setTranType(int tranType){
        this.tranType = tranType;
    }

    public Date getTranDate(){
        return tranDate;
    }
    public void setTranDate(Date tranDate){
        this.tranDate = tranDate;
    }

    public int getIsRepeat(){
        return isRepeat;
    }
    public void setIsRepeat(int isRepeat){
        this.isRepeat = isRepeat;
    }

    public String getTranContent(){
        return tranContent;
    }
    public void setTranContent(String tranContent){
        this.tranContent = tranContent;
    }

    public int getAheadDays(){
        return aheadDays;
    }
    public void setAheadDays(int aheadDays){
        this.aheadDays = aheadDays;
    }

    public String getTranTime(){
        return tranTime;
    }
    public void setTranTime(String tranTime){
        this.tranTime = tranTime;
    }

    public int getIsAhead(){
        return isAhead;
    }
    public void setIsAhead(int isAhead){
        this.isAhead = isAhead;
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


}