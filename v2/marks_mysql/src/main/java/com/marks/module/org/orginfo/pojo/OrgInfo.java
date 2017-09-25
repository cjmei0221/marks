package com.marks.module.org.orginfo.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    private String parentName;
    
    private int lvl=1;//级别

    private String state="open";
    
    private String companyId;
    
    private int orgType;//0:普通 1：公司
    
    private int isMain;//0:非 1：主公司
    
    private List<OrgInfo> children=new ArrayList<OrgInfo>();
    private int childnum;
    private String logoId;//logo的名称
    
    
    public String getLogoId() {
		return logoId;
	}

	public void setLogoId(String logoId) {
		this.logoId = logoId;
	}

	public int getChildnum() {
		return childnum;
	}

	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public int getIsMain() {
		return isMain;
	}

	public void setIsMain(int isMain) {
		this.isMain = isMain;
	}

	public String getOrgid(){
        return orgid;
    }
    
    public String getId(){
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
    public String getText(){
        return orgname;
    }
    public void setOrgname(String orgname){
        this.orgname = orgname;
    }

    public String getCreatetime(){
        return createtime==null?"":createtime.toLocaleString();
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public String getUpdatetime(){
        return updatetime==null?"":updatetime.toLocaleString();
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<OrgInfo> getChildren() {
		return children;
	}

	public void setChildren(List<OrgInfo> children) {
		this.children = children;
	}

	public void addChildren(OrgInfo child) {
		this.children.add(child);
	}
}