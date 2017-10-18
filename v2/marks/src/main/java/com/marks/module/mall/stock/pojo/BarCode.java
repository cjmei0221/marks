package com.marks.module.mall.stock.pojo;

import java.io.Serializable;
import java.util.Date;

public class BarCode implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *条码
    *
    */
    private String barcode;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *商品编码
    *
    */
    private String goodId;
    /**
    *商品条码
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
    *更新时间
    *
    */
    private String updatetime;
    /**
    *追踪码
    *
    */
    private String traceId;
    /**
    *激活状态
    *0:未使用 1:使用中
    */
    private int activeStatus;
    /**
    *库存状态
    *
    */
    private int stockStatus;
    /**
    *类别ID
    *
    */
    private String typeId;
    /**
    *类别
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



    public String getBarcode(){
        return barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
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

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getTraceId(){
        return traceId;
    }
    public void setTraceId(String traceId){
        this.traceId = traceId;
    }

    public int getActiveStatus(){
        return activeStatus;
    }
    public void setActiveStatus(int activeStatus){
        this.activeStatus = activeStatus;
    }

    public int getStockStatus(){
        return stockStatus;
    }
    public void setStockStatus(int stockStatus){
        this.stockStatus = stockStatus;
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


	public String toLog(){
		return " - barcode:" +String.valueOf(barcode)+" - companyId:" +String.valueOf(companyId)+" - goodId:" +String.valueOf(goodId)+" - goodNo:" +String.valueOf(goodNo)+" - barNo:" +String.valueOf(barNo)+" - goodName:" +String.valueOf(goodName)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - traceId:" +String.valueOf(traceId)+" - activeStatus:" +String.valueOf(activeStatus)+" - stockStatus:" +String.valueOf(stockStatus)+" - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - brandId:" +String.valueOf(brandId)+" - brandName:" +String.valueOf(brandName);
	}
}