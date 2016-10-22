package com.cjmei.module.cell.orginfo.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrgInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *机构ID
    */
    private String orgid;
    /**
    *创建者
    */
    private String creator;
    /**
    *机构名称
    */
    private String orgname;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *更新时间
    */
    private Timestamp updatetime;
    /**
    *启用标识
    */
    private Integer useflag=1;
    
    private String parentId="0";//
    
    private int lvl=1;//级别


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

    public String getOrgname(){
        return orgname;
    }
    public void setOrgname(String orgname){
        this.orgname = orgname;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime){
        this.updatetime = updatetime;
    }

    public Integer getUseflag(){
        return useflag;
    }
    public void setUseflag(Integer useflag){
        this.useflag = useflag;
    }
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

    
}