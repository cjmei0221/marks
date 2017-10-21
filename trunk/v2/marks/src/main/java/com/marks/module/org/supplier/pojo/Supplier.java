package com.marks.module.org.supplier.pojo;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *供应商编号
    *
    */
    private String orgid;
    /**
    *供应商
    *
    */
    private String orgname;
    /**
    *区域编号
    *
    */
    private String areaId;
    /**
    *区域
    *
    */
    private String areaName;
    /**
    *公司编号
    *
    */
    private String companyId;
    /**
    *联系人
    *
    */
    private String linkman;
    /**
    *联系电话
    *
    */
    private String linkTel;
    /**
    *地址
    *
    */
    private String address;
    /**
    *启用标识
    *
    */
    private int status;



    public String getOrgid(){
        return orgid;
    }
    public void setOrgid(String orgid){
        this.orgid = orgid;
    }

    public String getOrgname(){
        return orgname;
    }
    public void setOrgname(String orgname){
        this.orgname = orgname;
    }

    public String getAreaId(){
        return areaId;
    }
    public void setAreaId(String areaId){
        this.areaId = areaId;
    }

    public String getAreaName(){
        return areaName;
    }
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getLinkman(){
        return linkman;
    }
    public void setLinkman(String linkman){
        this.linkman = linkman;
    }

    public String getLinkTel(){
        return linkTel;
    }
    public void setLinkTel(String linkTel){
        this.linkTel = linkTel;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }


	public String toLog(){
		return " - orgid:" +String.valueOf(orgid)+" - orgname:" +String.valueOf(orgname)+" - areaId:" +String.valueOf(areaId)+" - areaName:" +String.valueOf(areaName)+" - companyId:" +String.valueOf(companyId)+" - linkman:" +String.valueOf(linkman)+" - linkTel:" +String.valueOf(linkTel)+" - address:" +String.valueOf(address)+" - status:" +String.valueOf(status);
	}
}