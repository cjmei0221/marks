package com.cjmei.module.system.login.pojo;

import java.io.Serializable;

public class SysUser implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *用户ID
    */
    private String userid;
    /**
    *用户名称
    */
    private String username;
    /**
    *用户密码
    */
    private String password;
    /**
    *绑定手机号码
    */
    private String bind_mobile;
    /**
    *激活标识
    */
    private int activeFlag;
     
    /**
    *口令
    */
    private String token;
    /**
    *用户类型
    */
    private String userType;
	
	private String companyId;
	
	private String openid;
	

	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getBind_mobile(){
        return bind_mobile;
    }
    public void setBind_mobile(String bind_mobile){
        this.bind_mobile = bind_mobile;
    }

    public int getActiveFlag(){
        return activeFlag;
    }
    public void setActiveFlag(int activeFlag){
        this.activeFlag = activeFlag;
    }

   
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }

    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }

  
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}