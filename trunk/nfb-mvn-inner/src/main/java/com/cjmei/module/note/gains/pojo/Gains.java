package com.cjmei.module.note.gains.pojo;

import java.io.Serializable;
import java.util.Date;

public class Gains implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *级别
    */
    private String lvl;
    /**
    *级别名称
    */
    private String lvlName;
    /**
    *标题
    */
    private String title;
    /**
    *内容
    */
    private String content;
    /**
    *标签
    */
    private String labels;
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
    *更新者
    */
    private String updater;

    private String mobile;
    
    public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getLvl(){
        return lvl;
    }
    public void setLvl(String lvl){
        this.lvl = lvl;
    }

    public String getLvlName(){
        return lvlName;
    }
    public void setLvlName(String lvlName){
        this.lvlName = lvlName;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getLabels(){
        return labels;
    }
    public void setLabels(String labels){
        this.labels = labels;
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

    public String getUpdater(){
        return updater;
    }
    public void setUpdater(String updater){
        this.updater = updater;
    }


}