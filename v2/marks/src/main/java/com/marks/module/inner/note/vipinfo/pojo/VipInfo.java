package com.marks.module.inner.note.vipinfo.pojo;

import java.io.Serializable;
import java.util.Date;

import com.marks.module.sys.system.core.data.StaticData;

public class VipInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * USERID
	 */
	private String userid;
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
	/**
	 * 绑定手机号码
	 */
	private String bind_mobile;
	/**
	 * 激活标识
	 */
	private int activeFlag;
	/**
	 * 激活标识
	 */
	private int bindFlag;

	private String companyId;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

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

	public String getBind_mobile() {
		return bind_mobile;
	}

	public void setBind_mobile(String bind_mobile) {
		this.bind_mobile = bind_mobile;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public int getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(int bindFlag) {
		this.bindFlag = bindFlag;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return StaticData.getOrgInfo(companyId).getOrgname();
	}
}