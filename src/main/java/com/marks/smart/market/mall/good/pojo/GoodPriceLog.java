package com.marks.smart.market.mall.good.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class GoodPriceLog implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *主键
    *
    */
    private String id;
    /**
    *商品编号
    *
    */
    private String goodNo;
    /**
    *售价
    *
    */
    private String salePrice;
    /**
    *会员价
    *
    */
    private String vipPrice;
    /**
    *配送价
    *
    */
    private String dispatchPrice;
    /**
    *公司编号
    *
    */
    private String companyId;
    /**
    *门店编号
    *
    */
    private String shopId;
    /**
    *门店名称
    *
    */
    private String shopName;
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
    *商品ID
    *
    */
    private String goodId;
    /**
    *批发价
    *
    */
    private String tradePrice;
    /**
    *最低价
    *
    */
    private String minPrice;
    /**
    *进货价
    *
    */
    private String costPrice;
    /**
    *批次编号
    *
    */
    private String batchId;
    /**
    *创建者
    *
    */
    private String creator;
    /**
    *创建编号
    *
    */
    private String creatorCode;
    /**
    *备注
    *
    */
    private String remarks;
    /**
    *审核状态
    *
    */
    private int checkStatus;
    /**
    *审核人编号
    *
    */
    private String checkerCode;
    /**
    *审核人
    *
    */
    private String checker;
    /**
    *审核时间
    *
    */
    private String checkTime;
    /**
    *类型编号
    *
    */
    private int typeCode;
    /**
    *类型
    *
    */
    private String typeName;
    /**
    *上下架
    *
    */
    private int onsale_status;


 public GoodPriceLog(){
    this.createtime=DateUtil.getCurrDateStr();

    }


    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getGoodNo(){
        return goodNo;
    }
    public void setGoodNo(String goodNo){
        this.goodNo = goodNo;
    }

    public String getSalePrice(){
        return salePrice;
    }
    public void setSalePrice(String salePrice){
        this.salePrice = salePrice;
    }

    public String getVipPrice(){
        return vipPrice;
    }
    public void setVipPrice(String vipPrice){
        this.vipPrice = vipPrice;
    }

    public String getDispatchPrice(){
        return dispatchPrice;
    }
    public void setDispatchPrice(String dispatchPrice){
        this.dispatchPrice = dispatchPrice;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getShopId(){
        return shopId;
    }
    public void setShopId(String shopId){
        this.shopId = shopId;
    }

    public String getShopName(){
        return shopName;
    }
    public void setShopName(String shopName){
        this.shopName = shopName;
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

    public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getTradePrice(){
        return tradePrice;
    }
    public void setTradePrice(String tradePrice){
        this.tradePrice = tradePrice;
    }

    public String getMinPrice(){
        return minPrice;
    }
    public void setMinPrice(String minPrice){
        this.minPrice = minPrice;
    }

    public String getCostPrice(){
        return costPrice;
    }
    public void setCostPrice(String costPrice){
        this.costPrice = costPrice;
    }

    public String getBatchId(){
        return batchId;
    }
    public void setBatchId(String batchId){
        this.batchId = batchId;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }

    public String getCreatorCode(){
        return creatorCode;
    }
    public void setCreatorCode(String creatorCode){
        this.creatorCode = creatorCode;
    }

    public String getRemarks(){
        return remarks;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public int getCheckStatus(){
        return checkStatus;
    }
    public void setCheckStatus(int checkStatus){
        this.checkStatus = checkStatus;
    }

    public String getCheckerCode(){
        return checkerCode;
    }
    public void setCheckerCode(String checkerCode){
        this.checkerCode = checkerCode;
    }

    public String getChecker(){
        return checker;
    }
    public void setChecker(String checker){
        this.checker = checker;
    }

    public String getCheckTime(){
        return checkTime;
    }
    public void setCheckTime(String checkTime){
        this.checkTime = checkTime;
    }

    public int getTypeCode(){
        return typeCode;
    }
    public void setTypeCode(int typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public int getOnsale_status(){
        return onsale_status;
    }
    public void setOnsale_status(int onsale_status){
        this.onsale_status = onsale_status;
    }


}