package com.marks.module.user.sysrole.pojo;

import java.io.Serializable;
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
    private Date updatetime;
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
    
    /**
     * 级别
     */
    private int lvl;
    /**
     * 用户类型
     */
	private String roleType;
    /**
     * 是否用户下拉组件 显示  0：不显示 1：显示
     */
    private int showFlag=1;

	private int delFlag = 1;

	private String orgId;

	private String orgName;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public int getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(int showFlag) {
		this.showFlag = showFlag;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
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

    public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
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
	
	public String getRoleFullName() {
		return this.getRolename();
	}
}