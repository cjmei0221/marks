package com.grgbanking.infra.pojo;

import java.io.Serializable;
import java.util.Date;

public class WxAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String appid;
	private String appsecret;
	private String authdomain;
	private String url;
	private String token;
	private String aeskey;
	private String picurl;
	private int enable;
	private String creator;
	private Date createtime;
	private String server_context;
	private String wx_acctno;
	private int is_service;
	private int acctype;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getAuthdomain() {
		return authdomain;
	}
	public void setAuthdomain(String authdomain) {
		this.authdomain = authdomain;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAeskey() {
		return aeskey;
	}
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getServer_context() {
		return server_context;
	}
	public void setServer_context(String server_context) {
		this.server_context = server_context;
	}
	public String getWx_acctno() {
		return wx_acctno;
	}
	public void setWx_acctno(String wx_acctno) {
		this.wx_acctno = wx_acctno;
	}
	public int getIs_service() {
		return is_service;
	}
	public void setIs_service(int is_service) {
		this.is_service = is_service;
	}
	public int getAcctype() {
		return acctype;
	}
	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SysConf)
			return id.equals(((WxAccount) obj).id);
		else
			return false;
	}
}
