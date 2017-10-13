package com.marks.module.user.vipinfo.pojo;

import java.io.Serializable;

import com.marks.module.core.data.CacheData;
import com.marks.module.user.sysuser.pojo.SysUser;

public class VipInfo extends SysUser implements Serializable {

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
	
	private String companyName;
	

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

	public String getCompanyName() {
		if(this.getCompanyId()==null){
			return "";
		}
		return CacheData.getOrgInfo(this.getCompanyId()).getOrgname();
	}
}