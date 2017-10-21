package com.marks.module.mall.stock.pojo;

import java.io.Serializable;
import java.util.Date;

public class TraceLog implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *ID
    *
    */
    private String id;
    /**
    *追踪码
    *
    */
    private String traceId;
    /**
    *条码
    *
    */
    private String barCode;
    /**
    *商品编码
    *
    */
    private String goodId;
    /**
    *商品编号
    *
    */
    private String goodNo;
    /**
    *国际条码
    *
    */
    private String barNo;
    /**
    *商品名称
    *
    */
    private String goodName;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *品类ID
    *
    */
    private String typeId;
    /**
    *品类
    *
    */
    private String typeName;
    /**
    *品牌ID
    *
    */
    private String brandId;
    /**
    *品牌
    *
    */
    private String brandName;
    /**
    *库存状态
    *
    */
    private int stockStatus;
    /**
    *操作者
    *
    */
    private String operator;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *机构ID
    *
    */
    private String orgid;
    /**
    *机构名称
    *
    */
    private String orgname;
    /**
    *备注
    *
    */
    private String remarks;



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getTraceId(){
        return traceId;
    }
    public void setTraceId(String traceId){
        this.traceId = traceId;
    }

    public String getBarCode(){
        return barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }

    public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getGoodNo(){
        return goodNo;
    }
    public void setGoodNo(String goodNo){
        this.goodNo = goodNo;
    }

    public String getBarNo(){
        return barNo;
    }
    public void setBarNo(String barNo){
        this.barNo = barNo;
    }

    public String getGoodName(){
        return goodName;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
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

    public String getBrandId(){
        return brandId;
    }
    public void setBrandId(String brandId){
        this.brandId = brandId;
    }

    public String getBrandName(){
        return brandName;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }

    public int getStockStatus(){
        return stockStatus;
    }
    public void setStockStatus(int stockStatus){
        this.stockStatus = stockStatus;
    }

    public String getOperator(){
        return operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

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

    public String getRemarks(){
        return remarks;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }


	public String toLog(){
		return " - id:" +String.valueOf(id)+" - traceId:" +String.valueOf(traceId)+" - barCode:" +String.valueOf(barCode)+" - goodId:" +String.valueOf(goodId)+" - goodNo:" +String.valueOf(goodNo)+" - barNo:" +String.valueOf(barNo)+" - goodName:" +String.valueOf(goodName)+" - createtime:" +String.valueOf(createtime)+" - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - brandId:" +String.valueOf(brandId)+" - brandName:" +String.valueOf(brandName)+" - stockStatus:" +String.valueOf(stockStatus)+" - operator:" +String.valueOf(operator)+" - companyId:" +String.valueOf(companyId)+" - orgid:" +String.valueOf(orgid)+" - orgname:" +String.valueOf(orgname)+" - remarks:" +String.valueOf(remarks);
	}
}