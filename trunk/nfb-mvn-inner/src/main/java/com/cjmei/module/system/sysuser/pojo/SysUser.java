package com.cjmei.module.system.sysuser.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *用户ID
    */
    private String userid;
    /**
    *上次登录时间
    */
    private Timestamp lastLoginTime;
    /**
    *用户类型
    */
    private String userType;
    /**
    *openid
    */
    private String openid;
    /**
    *口令
    */
    private String token;
    /**
    *公司ID
    */
    private String companyId;
    /**
    *组织ID
    */
    private String orgid;
    /**
    *创建者
    */
    private String creator;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *激活标识
    */
    private int activeFlag;
    /**
    *绑定手机号码
    */
    private String bind_mobile;
    /**
    *用户密码
    */
    private String password;
    /**
    *用户名称
    */
    private String username;
	
	private List<String> userUrlList = new ArrayList<String>();

	private List<String> roleIds=new ArrayList<String>();
	
	private Date loginTime;
	
    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public Timestamp getLastLoginTime(){
        return lastLoginTime;
    }
    public void setLastLoginTime(Timestamp lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getOpenid(){
        return openid;
    }
    public void setOpenid(String openid){
        this.openid = openid;
    }

    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getOrgid(){
        return orgid;
    }
    public void setOrgid(String orgid){
        this.orgid = orgid;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public Integer getActiveFlag(){
        return activeFlag;
    }
    public void setActiveFlag(Integer activeFlag){
        this.activeFlag = activeFlag;
    }

    public String getBind_mobile(){
        return bind_mobile;
    }
    public void setBind_mobile(String bind_mobile){
        this.bind_mobile = bind_mobile;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
	public List<String> getUserUrlList() {
		return userUrlList;
	}
	public void setUserUrlList(List<String> userUrlList) {
		this.userUrlList = userUrlList;
	}
	public List<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
    
}