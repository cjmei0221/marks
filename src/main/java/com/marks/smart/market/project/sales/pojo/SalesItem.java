package com.marks.smart.market.project.sales.pojo;

import java.io.Serializable;

import com.marks.common.enums.SalesEnums;
import com.marks.common.util.date.DateUtil;

public class SalesItem implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *系统编号
    *
    */
    private String itemId;
    /**
    *条目编号
    *
    */
    private String itemCode;
    /**
    *条目名称
    *
    */
    private String itemName;
    /**
    *限制数量
    *
    */
    private String limitNums;
    /**
    *类型编号
    *0:折扣 1:赠送
    */
    private int itemTypeCode;
    /**
    *类型
    *
    */
    private String itemTypeName;
    /**
    *条目值1
    *
    */
    private String itemVal1;
    /**
    *条目值2
    *
    */
    private String itemVal2;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *排序
    *
    */
    private int sort;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *方案编号
    *
    */
    private String projectCode;
    /**
    *方案名称
    *
    */
    private String projectName;
    /**
    *公司编号
    *
    */
    private String companyId;


 public SalesItem(){
    this.updatetime=DateUtil.getCurrDateStr();
    this.createtime=DateUtil.getCurrDateStr();

    }


    public String getItemId(){
        return itemId;
    }
    public void setItemId(String itemId){
        this.itemId = itemId;
    }

    public String getItemCode(){
        return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode = itemCode;
    }

    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getLimitNums(){
        return limitNums;
    }
    public void setLimitNums(String limitNums){
        this.limitNums = limitNums;
    }

    public int getItemTypeCode(){
        return itemTypeCode;
    }
    public void setItemTypeCode(int itemTypeCode){
        this.itemTypeCode = itemTypeCode;
    }

    public String getItemTypeName(){
        return SalesEnums.AwardTypeCode.getByKey(itemTypeCode);
    }
    public void setItemTypeName(String itemTypeName){
        this.itemTypeName = itemTypeName;
    }

    public String getItemVal1(){
        return itemVal1;
    }
    public void setItemVal1(String itemVal1){
        this.itemVal1 = itemVal1;
    }

    public String getItemVal2(){
        return itemVal2;
    }
    public void setItemVal2(String itemVal2){
        this.itemVal2 = itemVal2;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public int getSort(){
        return sort;
    }
    public void setSort(int sort){
        this.sort = sort;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getProjectCode(){
        return projectCode;
    }
    public void setProjectCode(String projectCode){
        this.projectCode = projectCode;
    }

    public String getProjectName(){
        return projectName;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }


}