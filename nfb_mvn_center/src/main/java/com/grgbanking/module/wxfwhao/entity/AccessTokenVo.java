package com.grgbanking.module.wxfwhao.entity;

import java.io.Serializable;

public class AccessTokenVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String accountid;
	private String accesstoken;
	private String puttime;
	private String expires_in;
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	public String getPuttime() {
		return puttime;
	}
	public void setPuttime(String puttime) {
		this.puttime = puttime;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expiresIn) {
		expires_in = expiresIn;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
}
