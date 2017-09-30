package com.marks.module.autocode.web.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.marks.module.autocode.core.produced.util.StringUtil;

public class AutoCode implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *表名称
    */
    private String tableName;
    /**
    *实体类名称
    */
    private String beanName;
    /**
    *实体类名称
    */
    private String moduleDesc;

    private int is_createtable;//是否生成表 1：生产  0：不生成
    
    private int is_auth;//是否授权 0：否  1：是
    
    private String parentPackage="cell";
    
    private Date createtime;
   
    List<AutoCodeAttr> attrList=null;
    
    private String description;
    
    private int isAuto;//是否可再生成代码 0：可以 1：不可以

    public int getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(int isAuto) {
		this.isAuto = isAuto;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTableName(){
        return tableName;
    }
    public void setTableName(String tableName){
        this.tableName = tableName;
    }

    public String getBeanName(){
        return beanName;
    }
    public String getFactBeanName(){
		return StringUtil.getLowerCaseChar(this.getBeanName());
	}
    public void setBeanName(String beanName){
        this.beanName = beanName;
    }

    public String getModuleDesc(){
        return moduleDesc;
    }
    public void setModuleDesc(String moduleDesc){
        this.moduleDesc = moduleDesc;
    }
	public int getIs_createtable() {
		return is_createtable;
	}
	public void setIs_createtable(int is_createtable) {
		this.is_createtable = is_createtable;
	}
	public List<AutoCodeAttr> getAttrList() {
		return attrList;
	}
	public void setAttrList(List<AutoCodeAttr> attrList) {
		this.attrList = attrList;
	}
	public int getIs_auth() {
		return is_auth;
	}
	public void setIs_auth(int is_auth) {
		this.is_auth = is_auth;
	}
	public String getParentPackage() {
		return parentPackage;
	}
	public void setParentPackage(String parentPackage) {
		this.parentPackage = parentPackage;
	}
	
	
}