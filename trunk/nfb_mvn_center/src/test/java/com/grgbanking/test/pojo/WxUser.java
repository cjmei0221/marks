package com.grgbanking.test.pojo;

import java.util.Date;

public class WxUser {

	private String openid;
	private String nickname;
	private int groupid;
	private String country;
	private String province;
	private String city;
	private int sex;
	private String imageurl;
	private int issubscribe;
	private Date subscribetime;
	private String language;
    private String unionid;//
    private String remark;//备注
    private String tagid_list;//标签列表 

	private Date createtime;
	private Date updatetime;
	private String accountid;
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
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public int getIssubscribe() {
		return issubscribe;
	}
	public void setIssubscribe(int issubscribe) {
		this.issubscribe = issubscribe;
	}
	public Date getSubscribetime() {
		return subscribetime;
	}
	public void setSubscribetime(Date subscribetime) {
		this.subscribetime = subscribetime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(String tagid_list) {
		this.tagid_list = tagid_list;
	}
}
