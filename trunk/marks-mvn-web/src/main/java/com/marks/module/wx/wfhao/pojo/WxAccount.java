package com.marks.module.wx.wfhao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信服务号对象
 * 
 * @author lwgang
 * @createTime 2015-01-22
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WxAccount implements Serializable {

	private static final long serialVersionUID = -3783293808632853486L;

	private String accountid;
	private String appid;//应用id
	private String appsecret;//应用密钥
	private String name;//服务号名称
	private String authdomain;//应用域名
	private String url;//回调URL
	private String token;//令牌
	private String aeskey;//密钥
	private String creator;//创建者
	private Date createtime;//创建时间
	private String userid;//用户账号
	
	private int is_service;//是否提供服务，1：提供，0：不提供
	
	private String wx_acctno;//微信号
	private String server_context;
	private int accttype;//是否是企业号  0：服务号 1:企业号 2:订阅号

	private int isSafe;//是否为安全模式  1：是
	
	public int getIsSafe() {
		return isSafe;
	}

	public void setIsSafe(int isSafe) {
		this.isSafe = isSafe;
	}

	/**
	 * 设置属性：唯一标识
	 * @param id
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	/**
	 * 获取属性：唯一标识
	 * @return
	 */
	public String getAccountid() {
		return accountid;
	}

	/**
	 * 设置属性：应用ID
	 * @param appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * 获取属性：应用ID
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * 设置属性：应用秘钥
	 * @param appsecret
	 */
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	/**
	 * 获取属性：应用秘钥
	 * @return
	 */
	public String getAppsecret() {
		return appsecret;
	}

	/**
	 * 获取属性：应用名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置属性：应用名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置属性：授权域名
	 * 
	 * @param
	 */
	public void setAuthdomain(String authdomain) {
		this.authdomain = authdomain;
	}

	/**
	 * 获取属性：授权域名
	 * 
	 * @return
	 */
	public String getAuthdomain() {
		return authdomain;
	}

	/**
	 * 设置属性：回调URL
	 * 
	 * @param
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取属性：回调URL
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置属性：令牌
	 * 
	 * @param
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 获取属性：令牌
	 * 
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置属性：密钥
	 * 
	 * @param
	 */
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}

	/**
	 * 获取属性：密钥
	 * 
	 * @return
	 */
	public String getAeskey() {
		return aeskey;
	}

	/**
	 * 设置属性：创建者
	 * 
	 * @param
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 获取属性：创建者
	 * 
	 * @return
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 设置属性：创建时间
	 * 
	 * @param
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取属性：创建时间
	 * 
	 * @return
	 */
	public Date getCreatetime() {
		return createtime;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getIs_service() {
		return is_service;
	}

	public void setIs_service(int is_service) {
		this.is_service = is_service;
	}

	public String getWx_acctno() {
		return wx_acctno;
	}

	public void setWx_acctno(String wx_acctno) {
		this.wx_acctno = wx_acctno;
	}

	public String getServer_context() {
		return server_context;
	}

	public void setServer_context(String server_context) {
		this.server_context = server_context;
	}

	public int getAccttype() {
		return accttype;
	}

	public void setAccttype(int accttype) {
		this.accttype = accttype;
	}
}
