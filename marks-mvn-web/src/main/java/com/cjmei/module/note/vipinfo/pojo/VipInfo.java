package com.cjmei.module.note.vipinfo.pojo;

import java.util.Date;

import com.cjmei.module.system.login.pojo.SysUser;

public class VipInfo extends SysUser{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 生日
	 */
	private String birthdate;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 签名
	 */
	private String signature;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

}