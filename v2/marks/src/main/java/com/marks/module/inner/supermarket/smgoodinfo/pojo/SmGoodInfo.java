package com.marks.module.inner.supermarket.smgoodinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class SmGoodInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *商品ID
    */
    private String goodId;
    /**
    *商品名称
    */
    private String goodName;
    /**
    *商品单价
    */
    private int goodPrice;
    /**
    *商品单位
    */
    private String unit;
    /**
    *商品主图
    */
    private String imageUrl;
    /**
    *创建时间
    */
    private Date createtime;
    /**
    *更新时间
    */
    private Date updatetime;
    /**
    *创建者
    */
    private String creator;
    
    private String remark;//备注
    
    private String sku_num;//sku编码
    
    private int onsale_status=1;//上架状态  1：上架  2：未上架  3：下架
   
    
    private String orgid;

    private String updator;

    public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(int goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSku_num() {
		return sku_num;
	}
	public void setSku_num(String sku_num) {
		this.sku_num = sku_num;
	}
	public int getOnsale_status() {
		return onsale_status;
	}
	public void setOnsale_status(int onsale_status) {
		this.onsale_status = onsale_status;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public String toLog(){
		return " - goodId:" +String.valueOf(goodId)+" - barCode:" +String.valueOf(sku_num)+" - goodName:" +String.valueOf(goodName)+" - goodPrice:" +String.valueOf(goodPrice)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - creator:" +String.valueOf(creator)+" - updator:" +String.valueOf(updator)+" - smId:" +String.valueOf(orgid);
	}
}