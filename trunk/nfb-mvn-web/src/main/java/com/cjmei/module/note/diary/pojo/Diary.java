package com.cjmei.module.note.diary.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Diary implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private String ID;
    /**
    *更新时间
    */
    private Date updatetime;
    /**
    *正文
    */
    private String content;
    /**
    *创建者
    */
    private String creator;
    /**
    *标题
    */
    private String title;
    /**
    *创建时间
    */
    private Date createtime;



    public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
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

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }



}