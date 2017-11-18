package com.marks.module.asset.manage.pojo;

import java.io.Serializable;
import java.util.Date;

public class AssetPlan implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *编号
    *
    */
    private String planId;
    /**
    *名称
    *
    */
    private String planName;
    /**
    *用户编号
    *
    */
    private String userid;
    /**
    *用户名称
    *
    */
    private String username;
    /**
    *手机号
    *
    */
    private String mobile;
    /**
    *投入金额
    *
    */
    private String investAmount;
    /**
    *状态
    *0:未执行 1：执行中 2:结束
    */
    private int status;
    /**
    *现有金额
    *
    */
    private String nowAmount;
    /**
    *差额
    *
    */
    private String differ;



    public String getPlanId(){
        return planId;
    }
    public void setPlanId(String planId){
        this.planId = planId;
    }

    public String getPlanName(){
        return planName;
    }
    public void setPlanName(String planName){
        this.planName = planName;
    }

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getInvestAmount(){
        return investAmount;
    }
    public void setInvestAmount(String investAmount){
        this.investAmount = investAmount;
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }

    public String getNowAmount(){
        return nowAmount;
    }
    public void setNowAmount(String nowAmount){
        this.nowAmount = nowAmount;
    }

    public String getDiffer(){
        return differ;
    }
    public void setDiffer(String differ){
        this.differ = differ;
    }


	public String toLog(){
		return " - planId:" +String.valueOf(planId)+" - planName:" +String.valueOf(planName)+" - userid:" +String.valueOf(userid)+" - username:" +String.valueOf(username)+" - mobile:" +String.valueOf(mobile)+" - investAmount:" +String.valueOf(investAmount)+" - status:" +String.valueOf(status)+" - nowAmount:" +String.valueOf(nowAmount)+" - differ:" +String.valueOf(differ);
	}
}