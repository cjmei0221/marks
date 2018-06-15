package com.marks.module.mall.dispatch.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class DispatchLog implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *记录编号
    *
    */
    private String logId;
    /**
    *商品单号
    *
    */
    private String orderGoodId;
    /**
    *订单号
    *
    */
    private String orderId;
    /**
    *条目类别
    *
    */
    private String typeCode;
    /**
    *条目类别
    *
    */
    private String typeCodeName;
    /**
    *操作人
    *
    */
    private String operator;
    /**
    *机构
    *
    */
    private String orgId;
    /**
    *机构
    *
    */
    private String orgName;
    /**
    *商品编号
    *
    */
    private String goodId;
    /**
    *商品编号
    *
    */
    private String goodNo;
    /**
    *商品名称
    *
    */
    private String goodName;
    /**
    *商品码
    *
    */
    private String barNo;
    /**
    *单位
    *
    */
    private String unit;
    /**
    *规格
    *
    */
    private String rank;
    /**
    *型号
    *
    */
    private String model;
    /**
    *类别
    *
    */
    private String typeId;
    /**
    *品类
    *
    */
    private String typeName;
    /**
    *品牌
    *
    */
    private String brandId;
    /**
    *品牌
    *
    */
    private String brandName;
    /**
    *数量
    *
    */
    private int nums;
    /**
    *金额
    *
    */
    private String amt;
    /**
    *创建时间
    *
    */
    private String createtime;


 public DispatchLog(){
    this.createtime=DateUtil.getCurrDateStr();

    }


    public String getLogId(){
        return logId;
    }
    public void setLogId(String logId){
        this.logId = logId;
    }

    public String getOrderGoodId(){
        return orderGoodId;
    }
    public void setOrderGoodId(String orderGoodId){
        this.orderGoodId = orderGoodId;
    }

    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getTypeCode(){
        return typeCode;
    }
    public void setTypeCode(String typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeCodeName(){
        return typeCodeName;
    }
    public void setTypeCodeName(String typeCodeName){
        this.typeCodeName = typeCodeName;
    }

    public String getOperator(){
        return operator;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }

    public String getOrgId(){
        return orgId;
    }
    public void setOrgId(String orgId){
        this.orgId = orgId;
    }

    public String getOrgName(){
        return orgName;
    }
    public void setOrgName(String orgName){
        this.orgName = orgName;
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

    public String getGoodName(){
        return goodName;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }

    public String getBarNo(){
        return barNo;
    }
    public void setBarNo(String barNo){
        this.barNo = barNo;
    }

    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getRank(){
        return rank;
    }
    public void setRank(String rank){
        this.rank = rank;
    }

    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
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

    public int getNums(){
        return nums;
    }
    public void setNums(int nums){
        this.nums = nums;
    }

    public String getAmt(){
        return amt;
    }
    public void setAmt(String amt){
        this.amt = amt;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }


	public String toLog(){
		return " - logId:" +String.valueOf(logId)+" - orderGoodId:" +String.valueOf(orderGoodId)+" - orderId:" +String.valueOf(orderId)+" - typeCode:" +String.valueOf(typeCode)+" - typeCodeName:" +String.valueOf(typeCodeName)+" - operator:" +String.valueOf(operator)+" - orgId:" +String.valueOf(orgId)+" - orgName:" +String.valueOf(orgName)+" - goodId:" +String.valueOf(goodId)+" - goodNo:" +String.valueOf(goodNo)+" - goodName:" +String.valueOf(goodName)+" - barNo:" +String.valueOf(barNo)+" - unit:" +String.valueOf(unit)+" - rank:" +String.valueOf(rank)+" - model:" +String.valueOf(model)+" - typeId:" +String.valueOf(typeId)+" - typeName:" +String.valueOf(typeName)+" - brandId:" +String.valueOf(brandId)+" - brandName:" +String.valueOf(brandName)+" - nums:" +String.valueOf(nums)+" - amt:" +String.valueOf(amt)+" - createtime:" +String.valueOf(createtime);
	}
}