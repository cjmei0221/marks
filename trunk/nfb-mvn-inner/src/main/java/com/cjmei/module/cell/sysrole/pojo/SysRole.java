package com.cjmei.module.cell.sysrole.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysRole implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *角色ID
    */
    private String roleid;
    /**
    *公司ID
    */
    private String orgid;
    
    private String orgname;
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
    private Timestamp createtime;


    private String companyId;

    public String getRoleid(){
        return roleid;
    }
    public void setRoleid(String roleid){
        this.roleid = roleid;
    }

    public String getOrgid(){
        return orgid;
    }
    public void setOrgid(String orgid){
        this.orgid = orgid;
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

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}