package com.marks.smart.system.user.sysuser.pojo;

import com.marks.common.annotation.IsNeeded;

public class SysUserExcel {

	@IsNeeded
	private String mobile;
	@IsNeeded
	private String username;
	@IsNeeded
	private String birthday;

	private String companyId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
