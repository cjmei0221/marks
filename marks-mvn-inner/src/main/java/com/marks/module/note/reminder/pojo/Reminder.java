package com.marks.module.note.reminder.pojo;

import java.io.Serializable;
import java.util.Date;

public class Reminder implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    */
    private String id;
    /**
    *事务类型
    */
    private int remind_type;
    /**
    *特殊日期
    */
    private String remind_date;
    /**
    *是否重复
    */
    private int is_repeat;
    /**
    *提醒内容
    */
    private String remind_content;
    /**
    *提前天数
    */
    private int before_days;
    /**
    *提醒时间
    */
    private String remind_time;
    /**
    *是否提前提醒
    */
    private int is_before;
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
    *日历类型
    */
    private int calendar_type;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getRemind_type(){
        return remind_type;
    }
    public void setRemind_type(int remind_type){
        this.remind_type = remind_type;
    }

    public String getRemind_date(){
        return remind_date;
    }
    public void setRemind_date(String remind_date){
        this.remind_date = remind_date;
    }

    public int getIs_repeat(){
        return is_repeat;
    }
    public void setIs_repeat(int is_repeat){
        this.is_repeat = is_repeat;
    }

    public String getRemind_content(){
        return remind_content;
    }
    public void setRemind_content(String remind_content){
        this.remind_content = remind_content;
    }

    public int getBefore_days(){
        return before_days;
    }
    public void setBefore_days(int before_days){
        this.before_days = before_days;
    }

    public String getRemind_time(){
        return remind_time;
    }
    public void setRemind_time(String remind_time){
        this.remind_time = remind_time;
    }

    public int getIs_before(){
        return is_before;
    }
    public void setIs_before(int is_before){
        this.is_before = is_before;
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

    public int getCalendar_type(){
        return calendar_type;
    }
    public void setCalendar_type(int calendar_type){
        this.calendar_type = calendar_type;
    }


	public String toLog(){
		return " - " +String.valueOf(id)+" - " +String.valueOf(remind_type)+" - " +String.valueOf(remind_date)+" - " +String.valueOf(is_repeat)+" - " +String.valueOf(remind_content)+" - " +String.valueOf(before_days)+" - " +String.valueOf(remind_time)+" - " +String.valueOf(is_before)+" - " +String.valueOf(createtime)+" - " +String.valueOf(updatetime)+" - " +String.valueOf(creator)+" - " +String.valueOf(calendar_type);
	}
}