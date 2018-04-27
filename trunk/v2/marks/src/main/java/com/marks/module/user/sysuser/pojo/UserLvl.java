package com.marks.module.user.sysuser.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class UserLvl implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *等级编号
    *
    */
    private String lvlId;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *等级名称
    *
    */
    private String lvlName;
    /**
    *等级
    *
    */
    private int lvl;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *创建者
    *
    */
    private String creator;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *更新者
    *
    */
    private String updater;
    /**
    *是否可以删除标识
    *内部使用
    */
    private int delFlag;
    /**
    *是否积分升级
    *
    */
	private int upPointFlag;
    /**
    *升级积分
    *
    */
    private int upPoint;
    /**
    *是否金额升级
    *
    */
    private int upAmtFlag;
    /**
    *升级金额
    *
    */
    private String upAmt;


 public UserLvl(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getLvlId(){
        return lvlId;
    }
    public void setLvlId(String lvlId){
        this.lvlId = lvlId;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getLvlName(){
        return lvlName;
    }
    public void setLvlName(String lvlName){
        this.lvlName = lvlName;
    }

    public int getLvl(){
        return lvl;
    }
    public void setLvl(int lvl){
        this.lvl = lvl;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getUpdater(){
        return updater;
    }
    public void setUpdater(String updater){
        this.updater = updater;
    }

    public int getDelFlag(){
        return delFlag;
    }
    public void setDelFlag(int delFlag){
        this.delFlag = delFlag;
    }

    public int getUpPointFlag(){
        return upPointFlag;
    }
    public void setUpPointFlag(int upPointFlag){
        this.upPointFlag = upPointFlag;
    }

    public int getUpPoint(){
        return upPoint;
    }
    public void setUpPoint(int upPoint){
        this.upPoint = upPoint;
    }

    public int getUpAmtFlag(){
        return upAmtFlag;
    }
    public void setUpAmtFlag(int upAmtFlag){
        this.upAmtFlag = upAmtFlag;
    }

    public String getUpAmt(){
        return upAmt;
    }
    public void setUpAmt(String upAmt){
        this.upAmt = upAmt;
    }


	public String toLog(){
		return " - lvlId:" +String.valueOf(lvlId)+" - companyId:" +String.valueOf(companyId)+" - lvlName:" +String.valueOf(lvlName)+" - lvl:" +String.valueOf(lvl)+" - createtime:" +String.valueOf(createtime)+" - creator:" +String.valueOf(creator)+" - updatetime:" +String.valueOf(updatetime)+" - updater:" +String.valueOf(updater)+" - delFlag:" +String.valueOf(delFlag)+" - upPointFlag:" +String.valueOf(upPointFlag)+" - upPoint:" +String.valueOf(upPoint)+" - upAmtFlag:" +String.valueOf(upAmtFlag)+" - upAmt:" +String.valueOf(upAmt);
	}
}