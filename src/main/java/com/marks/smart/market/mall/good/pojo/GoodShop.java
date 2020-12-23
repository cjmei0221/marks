package com.marks.smart.market.mall.good.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class GoodShop implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *主键
    *
    */
    private String goodShopId;
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
    *上下架
    *
    */
    private int onsale_status;
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
    *更新时间
    *
    */
    private String updatetime;
    
    private String updater;
    private String updaterCode;


 public GoodShop(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getUpdater() {
	return updater;
}


public void setUpdater(String updater) {
	this.updater = updater;
}


public String getUpdaterCode() {
	return updaterCode;
}


public void setUpdaterCode(String updaterCode) {
	this.updaterCode = updaterCode;
}


	public String getGoodShopId(){
        return goodShopId;
    }
    public void setGoodShopId(String goodShopId){
        this.goodShopId = goodShopId;
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

    public int getOnsale_status(){
        return onsale_status;
    }
    public void setOnsale_status(int onsale_status){
        this.onsale_status = onsale_status;
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

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }


}