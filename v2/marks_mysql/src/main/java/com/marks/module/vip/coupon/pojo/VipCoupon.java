package com.marks.module.vip.coupon.pojo;

import java.io.Serializable;
import java.util.Date;

public class VipCoupon implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *卷号
    *
    */
    private String idNo;
    /**
    *卷类型
    *
    */
    private String couponType;
    /**
    *会员ID
    *
    */
    private String userid;
    /**
    *平台ID
    *
    */
    private String i_unionid;
    /**
    *手机号
    *
    */
    private String mobile;
    /**
    *会员姓名
    *
    */
    private String username;
    /**
    *卷ID
    *
    */
    private String couponId;
    /**
    *卷名称
    *
    */
    private String couponName;
    /**
    *发卷机构编号
    *
    */
    private String orgid;
    /**
    *发卷机构名称
    *
    */
    private String orgName;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *值类型
    *
    */
    private String type;
    /**
    *金额
    *
    */
    private String amount;
    /**
    *折扣
    *
    */
    private String disaccount;
    /**
    *状态
    *1:有效 0无效
    */
    private String status;
    /**
    *背景色
    *
    */
    private String bgcolor;
    /**
    *是否转让
    *
    */
    private String isTransfer;
    /**
    *是否积分
    *
    */
    private String isCredit;
    /**
    *是否叠加
    *
    */
    private String isOverlay;
    /**
    *是否累计
    *
    */
    private String isAddup;
    /**
    *领卷时间
    *
    */
    private Date createtime;
    /**
    *使用渠道
    *
    */
    private String useChannel;
    /**
    *使用时间
    *
    */
    private Date useDate;
    /**
    *失效日期
    *
    */
    private String passDate;
    /**
    *更新时间
    *
    */
    private Date updatetime;
    /**
    *使用机构
    *
    */
    private String useOrgid;
    /**
    *使用机构名称
    *
    */
    private String useOrgName;
    /**
    *设备编号
    *
    */
    private String deviceId;
    /**
    *设备名称
    *
    */
    private String deviceName;
    /**
    *收银员编号
    *
    */
    private String cashierId;
    /**
    *收银员
    *
    */
    private String cashier;
    /**
    *订单单号
    *
    */
    private String orderId;



    public String getIdNo(){
        return idNo;
    }
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }

    public String getCouponType(){
        return couponType;
    }
    public void setCouponType(String couponType){
        this.couponType = couponType;
    }

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getI_unionid(){
        return i_unionid;
    }
    public void setI_unionid(String i_unionid){
        this.i_unionid = i_unionid;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getCouponId(){
        return couponId;
    }
    public void setCouponId(String couponId){
        this.couponId = couponId;
    }

    public String getCouponName(){
        return couponName;
    }
    public void setCouponName(String couponName){
        this.couponName = couponName;
    }

    public String getOrgid(){
        return orgid;
    }
    public void setOrgid(String orgid){
        this.orgid = orgid;
    }

    public String getOrgName(){
        return orgName;
    }
    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getAmount(){
        return amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }

    public String getDisaccount(){
        return disaccount;
    }
    public void setDisaccount(String disaccount){
        this.disaccount = disaccount;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getBgcolor(){
        return bgcolor;
    }
    public void setBgcolor(String bgcolor){
        this.bgcolor = bgcolor;
    }

    public String getIsTransfer(){
        return isTransfer;
    }
    public void setIsTransfer(String isTransfer){
        this.isTransfer = isTransfer;
    }

    public String getIsCredit(){
        return isCredit;
    }
    public void setIsCredit(String isCredit){
        this.isCredit = isCredit;
    }

    public String getIsOverlay(){
        return isOverlay;
    }
    public void setIsOverlay(String isOverlay){
        this.isOverlay = isOverlay;
    }

    public String getIsAddup(){
        return isAddup;
    }
    public void setIsAddup(String isAddup){
        this.isAddup = isAddup;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public String getUseChannel(){
        return useChannel;
    }
    public void setUseChannel(String useChannel){
        this.useChannel = useChannel;
    }

    public Date getUseDate(){
        return useDate;
    }
    public void setUseDate(Date useDate){
        this.useDate = useDate;
    }

    public String getPassDate(){
        return passDate;
    }
    public void setPassDate(String passDate){
        this.passDate = passDate;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getUseOrgid(){
        return useOrgid;
    }
    public void setUseOrgid(String useOrgid){
        this.useOrgid = useOrgid;
    }

    public String getUseOrgName(){
        return useOrgName;
    }
    public void setUseOrgName(String useOrgName){
        this.useOrgName = useOrgName;
    }

    public String getDeviceId(){
        return deviceId;
    }
    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }

    public String getDeviceName(){
        return deviceName;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }

    public String getCashierId(){
        return cashierId;
    }
    public void setCashierId(String cashierId){
        this.cashierId = cashierId;
    }

    public String getCashier(){
        return cashier;
    }
    public void setCashier(String cashier){
        this.cashier = cashier;
    }

    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }


	public String toLog(){
		return " - idNo:" +String.valueOf(idNo)+" - couponType:" +String.valueOf(couponType)+" - userid:" +String.valueOf(userid)+" - i_unionid:" +String.valueOf(i_unionid)+" - mobile:" +String.valueOf(mobile)+" - username:" +String.valueOf(username)+" - couponId:" +String.valueOf(couponId)+" - couponName:" +String.valueOf(couponName)+" - orgid:" +String.valueOf(orgid)+" - orgName:" +String.valueOf(orgName)+" - companyId:" +String.valueOf(companyId)+" - type:" +String.valueOf(type)+" - amount:" +String.valueOf(amount)+" - disaccount:" +String.valueOf(disaccount)+" - status:" +String.valueOf(status)+" - bgcolor:" +String.valueOf(bgcolor)+" - isTransfer:" +String.valueOf(isTransfer)+" - isCredit:" +String.valueOf(isCredit)+" - isOverlay:" +String.valueOf(isOverlay)+" - isAddup:" +String.valueOf(isAddup)+" - createtime:" +String.valueOf(createtime)+" - useChannel:" +String.valueOf(useChannel)+" - useDate:" +String.valueOf(useDate)+" - passDate:" +String.valueOf(passDate)+" - updatetime:" +String.valueOf(updatetime)+" - useOrgid:" +String.valueOf(useOrgid)+" - useOrgName:" +String.valueOf(useOrgName)+" - deviceId:" +String.valueOf(deviceId)+" - deviceName:" +String.valueOf(deviceName)+" - cashierId:" +String.valueOf(cashierId)+" - cashier:" +String.valueOf(cashier)+" - orderId:" +String.valueOf(orderId);
	}
}