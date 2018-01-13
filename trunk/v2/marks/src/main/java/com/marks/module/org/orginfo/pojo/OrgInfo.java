package com.marks.module.org.orginfo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.marks.common.enums.OrgEnums;

public class OrgInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *机构ID
    */
    private String orgid;

	private int orgCategory;// 机构类型
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
	private String createtime;
    /**
    *更新时间
    */
	private String updatetime;
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
	private String linkman;// 联系人
	private String linkTel;// 联系电话
    
   
    
    private String lvl2Id;//級別2编号  lvl1为公司 公司不计入
    private String lvl2Name;//级别2名称;
    
    private String lvl3Id;//級別3编号 lvl1为公司 公司不计入
    private String lvl3Name;//级别3名称;
    
    private String lvl4Id;//級別3编号
    private String lvl4Name;//级别3名称;
    
    private String lvl5Id;//級別3编号
    private String lvl5Name;//级别3名称;
    
    private String lvl6Id;//級別6编号
    private String lvl6Name;//级别6名称;
    
	private int isDefault;

	private String areaId;
	private String areaName;
	private String address;


    
	public int getOrgCategory() {
		return orgCategory;
	}

	public void setOrgCategory(int orgCategory) {
		this.orgCategory = orgCategory;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public String getLvl2Id() {
		return lvl2Id;
	}

	public void setLvl2Id(String lvl2Id) {
		this.lvl2Id = lvl2Id;
	}

	public String getLvl2Name() {
		return lvl2Name;
	}

	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}

	public String getLvl3Id() {
		return lvl3Id;
	}

	public void setLvl3Id(String lvl3Id) {
		this.lvl3Id = lvl3Id;
	}

	public String getLvl3Name() {
		return lvl3Name;
	}

	public void setLvl3Name(String lvl3Name) {
		this.lvl3Name = lvl3Name;
	}

	public String getLvl4Id() {
		return lvl4Id;
	}

	public void setLvl4Id(String lvl4Id) {
		this.lvl4Id = lvl4Id;
	}

	public String getLvl4Name() {
		return lvl4Name;
	}

	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
	}

	public String getLvl5Id() {
		return lvl5Id;
	}

	public void setLvl5Id(String lvl5Id) {
		this.lvl5Id = lvl5Id;
	}

	public String getLvl5Name() {
		return lvl5Name;
	}

	public void setLvl5Name(String lvl5Name) {
		this.lvl5Name = lvl5Name;
	}

	public String getLvl6Id() {
		return lvl6Id;
	}

	public void setLvl6Id(String lvl6Id) {
		this.lvl6Id = lvl6Id;
	}

	public String getLvl6Name() {
		return lvl6Name;
	}

	public void setLvl6Name(String lvl6Name) {
		this.lvl6Name = lvl6Name;
	}

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

	public String getOrgTypeName() {
		return OrgEnums.OrgType.getByKey(orgType);
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
		return createtime;
    }

	public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime(){
		return updatetime;
    }

	public void setUpdatetime(String updatetime) {
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