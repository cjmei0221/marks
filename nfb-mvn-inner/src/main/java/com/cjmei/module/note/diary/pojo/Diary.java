package com.cjmei.module.note.diary.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Diary implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private String ID;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *正文
    */
    private String content;
    /**
    *创建者
    */
    private String creator;
    /**
    *日记时间
    */
    private Timestamp time;
    /**
    *标题
    */
    private String title;
    /**
    *创建时间
    */
    private Timestamp createtime;



    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time = time;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }


}