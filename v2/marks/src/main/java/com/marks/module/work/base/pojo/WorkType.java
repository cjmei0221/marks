package com.marks.module.work.base.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class WorkType implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *工作主键
    *
    */
    private String typeId;
    /**
    *工作名称
    *
    */
    private String typeName;
    /**
    *公司编号
    *
    */
    private String companyId;
    /**
    *工作编号
    *
    */
    private String typeCode;
    /**
    *数据库用户
    *
    */
    private String dbscheme;
    /**
    *数据库表名
    *
    */
    private String tbName;
    /**
    *主键字段名
    *
    */
    private String idField;
    /**
    *审核状态字段
    *
    */
    private String checkField;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *更新人
    *
    */
    private String updater;
    /**
    *链接
    *
    */
    private String linkUrl;
    /**
    *是否需要审核
    *
    */
    private int isCheck;


 public WorkType(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getTypeId(){
        return typeId;
    }
    public void setTypeId(String typeId){
        this.typeId = typeId;
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getTypeCode(){
        return typeCode;
    }
    public void setTypeCode(String typeCode){
        this.typeCode = typeCode;
    }

    public String getDbscheme(){
        return dbscheme;
    }
    public void setDbscheme(String dbscheme){
        this.dbscheme = dbscheme;
    }

    public String getTbName(){
        return tbName;
    }
    public void setTbName(String tbName){
        this.tbName = tbName;
    }

    public String getIdField(){
        return idField;
    }
    public void setIdField(String idField){
        this.idField = idField;
    }

    public String getCheckField(){
        return checkField;
    }
    public void setCheckField(String checkField){
        this.checkField = checkField;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getUpdater(){
        return updater;
    }
    public void setUpdater(String updater){
        this.updater = updater;
    }

    public String getLinkUrl(){
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl){
        this.linkUrl = linkUrl;
    }

    public int getIsCheck(){
        return isCheck;
    }
    public void setIsCheck(int isCheck){
        this.isCheck = isCheck;
    }


	public String toLog(){
		return " - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - companyId:" +String.valueOf(companyId)+" - typeCode:" +String.valueOf(typeCode)+" - dbscheme:" +String.valueOf(dbscheme)+" - tbName:" +String.valueOf(tbName)+" - idField:" +String.valueOf(idField)+" - checkField:" +String.valueOf(checkField)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - updater:" +String.valueOf(updater)+" - linkUrl:" +String.valueOf(linkUrl)+" - isCheck:" +String.valueOf(isCheck);
	}
}