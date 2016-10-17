package com.cjmei.module.autocode.web.pojo;

import java.io.Serializable;
import java.util.List;

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

    private int is_createtable;//是否生成表 1：不生产  0：生成
    
    List<AutoCodeAttr> attrList=null;

    public String getTableName(){
        return tableName;
    }
    public void setTableName(String tableName){
        this.tableName = tableName;
    }

    public String getBeanName(){
        return beanName;
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
}