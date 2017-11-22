package com.marks.module.asset.base.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class AssetLog implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *主键
    *
    */
    private String id;
    /**
    *用户ID
    *
    */
    private String userid;
    /**
    *用户名称
    *
    */
    private String username;
    /**
    *手机号码
    *
    */
    private String mobile;
    /**
    *交易类型
    *0:支出 1:收入
    */
    private int tranType;
    /**
    *交易项目编号
    *
    */
    private String itemType;
    /**
    *交易名称
    *
    */
    private String itemName;
    /**
    *支付方
    *
    */
    private String fromer;
    /**
    *收款方
    *
    */
    private String toer;
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
    *交易时间
    *
    */
    private String tranTime;
    /**
    *年份
    *
    */
    private String tranYear;
    /**
    *月份
    *
    */
    private String tranMonth;
    /**
    *账号
    *
    */
    private String idNo;
    /**
    *账户名称
    *
    */
    private String idName;


 public AssetLog(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
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

    public int getTranType(){
        return tranType;
    }
    public void setTranType(int tranType){
        this.tranType = tranType;
    }

    public String getItemType(){
        return itemType;
    }
    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getFromer(){
        return fromer;
    }
    public void setFromer(String fromer){
        this.fromer = fromer;
    }

    public String getToer(){
        return toer;
    }
    public void setToer(String toer){
        this.toer = toer;
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

    public String getTranTime(){
        return tranTime;
    }
    public void setTranTime(String tranTime){
        this.tranTime = tranTime;
    }

    public String getTranYear(){
        return tranYear;
    }
    public void setTranYear(String tranYear){
        this.tranYear = tranYear;
    }

    public String getTranMonth(){
        return tranMonth;
    }
    public void setTranMonth(String tranMonth){
        this.tranMonth = tranMonth;
    }

    public String getIdNo(){
        return idNo;
    }
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }

    public String getIdName(){
        return idName;
    }
    public void setIdName(String idName){
        this.idName = idName;
    }


	public String toLog(){
		return " - id:" +String.valueOf(id)+" - userid:" +String.valueOf(userid)+" - username:" +String.valueOf(username)+" - mobile:" +String.valueOf(mobile)+" - tranType:" +String.valueOf(tranType)+" - itemType:" +String.valueOf(itemType)+" - itemName:" +String.valueOf(itemName)+" - fromer:" +String.valueOf(fromer)+" - toer:" +String.valueOf(toer)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - tranTime:" +String.valueOf(tranTime)+" - tranYear:" +String.valueOf(tranYear)+" - tranMonth:" +String.valueOf(tranMonth)+" - idNo:" +String.valueOf(idNo)+" - idName:" +String.valueOf(idName);
	}
}