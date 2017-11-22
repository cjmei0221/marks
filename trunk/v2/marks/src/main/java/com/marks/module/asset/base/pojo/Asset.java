package com.marks.module.asset.base.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class Asset implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *账号
    *
    */
    private String idNo;
    /**
    *账户类型
    *
    */
    private String idType;
    /**
    *金额
    *
    */
    private String amount;
    /**
    *用户编号
    *
    */
    private String userid;
    /**
    *用户姓名
    *
    */
    private String username;
    /**
    *手机号
    *
    */
    private String mobile;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *支付优先级
    *
    */
    private int paySort;
    /**
    *账户名称
    *
    */
    private String idName;


 public Asset(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getIdNo(){
        return idNo;
    }
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }

    public String getIdType(){
        return idType;
    }
    public void setIdType(String idType){
        this.idType = idType;
    }

    public String getAmount(){
        return amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
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

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public int getPaySort(){
        return paySort;
    }
    public void setPaySort(int paySort){
        this.paySort = paySort;
    }

    public String getIdName(){
        return idName;
    }
    public void setIdName(String idName){
        this.idName = idName;
    }


	public String toLog(){
		return " - idNo:" +String.valueOf(idNo)+" - idType:" +String.valueOf(idType)+" - amount:" +String.valueOf(amount)+" - userid:" +String.valueOf(userid)+" - username:" +String.valueOf(username)+" - mobile:" +String.valueOf(mobile)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - paySort:" +String.valueOf(paySort)+" - idName:" +String.valueOf(idName);
	}
}