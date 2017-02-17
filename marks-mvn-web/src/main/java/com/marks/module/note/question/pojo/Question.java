package com.marks.module.note.question.pojo;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable{

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
    *问题
    */
    private String question;
    /**
    *解决方案
    */
    private String solution;
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

    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }

    public String getSolution(){
        return solution;
    }
    public void setSolution(String solution){
        this.solution = solution;
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