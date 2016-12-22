package com.cjmei.module.system.sysrole.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class SysRole implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *角色ID
    */
    private String roleid;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *创建者
    */
    private String creator;
    /**
    *角色名称
    */
    private String rolename;
    /**
    *创建时间
    */
    private Date createtime;


    private String companyId;
    
    
    private String companyName;
    /**
     * 级别
     */
    private int lvl;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 是否用户下拉组件 显示  0：不显示 1：显示
     */
    private int showFlag=1;

    public int getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(int showFlag) {
		this.showFlag = showFlag;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getRoleid(){
        return roleid;
    }
    public void setRoleid(String roleid){
        this.roleid = roleid;
    }

    public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getRolename(){
        return rolename;
    }
    public void setRolename(String rolename){
        this.rolename = rolename;
    }

   
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}