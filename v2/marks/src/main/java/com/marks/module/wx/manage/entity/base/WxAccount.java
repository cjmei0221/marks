package com.marks.module.wx.manage.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxAccount implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *公众号ID
    */
    private String accountId;
    /**
    *回调路径
    */
    private String url;
    /**
    *令牌
    */
    private String token;
    /**
    *加密秘钥
    */
    private String aeskey;
    /**
    *创建者
    */
    private String creator;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *上下文
    */
    private String server_context;
    /**
    *微信号
    */
    private String wx_acctno;
    /**
    *是否提供服务
    */
    private int is_service;
    /**
    *公众号类型
    */
    private int accttype;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *公众号名称
    */
    private String accountname;
    /**
    *机构ID
    */
    private String orgid;
    
    private String orgname;
    /**
    *APPID
    */
    private String appid;
    /**
    *APPSECRET
    */
    private String appsecret;
    /**
    *授权域名
    */
    private String authdomain;

    private String companyId;

    public String getAccountId(){
        return accountId;
    }
    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }

    public String getAeskey(){
        return aeskey;
    }
    public void setAeskey(String aeskey){
        this.aeskey = aeskey;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public String getServer_context(){
    	if(server_context==null){
    		return "/";
    	}
        return server_context;
    }
    public void setServer_context(String server_context){
        this.server_context = server_context;
    }

    public String getWx_acctno(){
        return wx_acctno;
    }
    public void setWx_acctno(String wx_acctno){
        this.wx_acctno = wx_acctno;
    }

    public Integer getIs_service(){
        return is_service;
    }
    public void setIs_service(Integer is_service){
        this.is_service = is_service;
    }

    public Integer getAccttype(){
        return accttype;
    }
    public void setAccttype(Integer accttype){
        this.accttype = accttype;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getAccountname(){
        return accountname;
    }
    public void setAccountname(String accountname){
        this.accountname = accountname;
    }

    public String getOrgid(){
        return orgid;
    }
    public void setOrgid(String orgid){
        this.orgid = orgid;
    }

    public String getAppid(){
        return appid;
    }
    public void setAppid(String appid){
        this.appid = appid;
    }

    public String getAppsecret(){
        return appsecret;
    }
    public void setAppsecret(String appsecret){
        this.appsecret = appsecret;
    }
	public String getAuthdomain() {
		return authdomain;
	}
	public void setAuthdomain(String authdomain) {
		this.authdomain = authdomain;
	}
	public void setIs_service(int is_service) {
		this.is_service = is_service;
	}
	public void setAccttype(int accttype) {
		this.accttype = accttype;
	}
	public String getOrgname() {
		return orgname;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}