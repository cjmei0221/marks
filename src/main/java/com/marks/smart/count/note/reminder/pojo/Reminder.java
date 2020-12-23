package com.marks.smart.count.note.reminder.pojo;

import java.io.Serializable;

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
	private String createtime;
    /**
    *更新时间
    */
	private String updatetime;
    /**
    *创建者
    */
    private String creator;
    /**
    *日历类型
    */
    private int calendar_type;
    
    private String openid;
    
    private String nickname;
    
    private String accountid;
    
    private int holiday_type;
    
    private int needFlag=1;
    
    

	public int getNeedFlag() {
		return needFlag;
	}
	public void setNeedFlag(int needFlag) {
		this.needFlag = needFlag;
	}
	public int getHoliday_type() {
		return holiday_type;
	}
	public void setHoliday_type(int holiday_type) {
		this.holiday_type = holiday_type;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
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

	public String getCreatetime() {
        return createtime;
    }

	public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

	public String getUpdatetime() {
        return updatetime;
    }

	public void setUpdatetime(String updatetime) {
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
		return " - id:" +String.valueOf(id)+" - remind_type:" +String.valueOf(remind_type)+" - remind_date:" +String.valueOf(remind_date)+" - is_repeat:" +String.valueOf(is_repeat)+" - remind_content:" +String.valueOf(remind_content)+" - before_days:" +String.valueOf(before_days)+" - remind_time:" +String.valueOf(remind_time)+" - is_before:" +String.valueOf(is_before)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - creator:" +String.valueOf(creator)+" - calendar_type:" +String.valueOf(calendar_type);
	}
}