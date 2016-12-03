package com.cjmei.module.wx.wxuser.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxUser implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *OPENID
    */
    private String openid;
    /**
    *昵称
    */
    private String nickname;
    /**
    *分组ID
    */
    private int groupid;
    /**
    *国家
    */
    private String country;
    /**
    *省
    */
    private String province;
    /**
    *市
    */
    private String city;
    /**
    *性别
    */
    private int sex;
    /**
    *头像路径
    */
    private String imageUrl;
    /**
    *语言
    */
    private String language;
    /**
    *关注
    */
    private int issubscribe;
    /**
    *关注时间
    */
    private Timestamp subscribetime;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *公众号ID
    */
    private String accountid;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *启用标识
    */
    private int useflag;
    /**
    *二维码标识
    */
    private String qrNo;
    
    private String qrName;//来源
    /**
    *备注
    */
    private String remark;

    private int dairyFlag;//日记推送标识 0不推送 1 推送
    
    

    public int getDairyFlag() {
		return dairyFlag;
	}
	public void setDairyFlag(int dairyFlag) {
		this.dairyFlag = dairyFlag;
	}
	public String getOpenid(){
        return openid;
    }
    public void setOpenid(String openid){
        this.openid = openid;
    }

    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public int getGroupid(){
        return groupid;
    }
    public void setGroupid(int groupid){
        this.groupid = groupid;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String getProvince(){
        return province;
    }
    public void setProvince(String province){
        this.province = province;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public int getSex(){
        return sex;
    }
    public void setSex(int sex){
        this.sex = sex;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getLanguage(){
        return language;
    }
    public void setLanguage(String language){
        this.language = language;
    }

    public int getIssubscribe(){
        return issubscribe;
    }
    public void setIssubscribe(int issubscribe){
        this.issubscribe = issubscribe;
    }

    public String getQrName() {
		return qrName;
	}
	public void setQrName(String qrName) {
		this.qrName = qrName;
	}
	public Timestamp getSubscribetime(){
        return subscribetime;
    }
    public void setSubscribetime(Timestamp subscribetime){
        this.subscribetime = subscribetime;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public int getUseflag(){
        return useflag;
    }
    public void setUseflag(int useflag){
        this.useflag = useflag;
    }

    public String getQrNo(){
        return qrNo;
    }
    public void setQrNo(String qrNo){
        this.qrNo = qrNo;
    }

    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }


}