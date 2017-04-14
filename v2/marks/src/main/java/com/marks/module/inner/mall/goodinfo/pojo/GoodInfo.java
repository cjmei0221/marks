package com.marks.module.inner.mall.goodinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class GoodInfo implements Serializable{

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

    private String brand;//品牌
    
    private String madeIn;//产地
    
    
    private String material;//材质
    
    private String  description;//特色描述
    
    private String remark;//备注
    
    private String sku_num;//sku编码
    
    private int onsale_status;//上架状态  1：上架  2：未上架  3：下架
    
    private Date onsale_time;//上架时间
    
    private String weight;
    private String weight_unit="Kg";
    
    private String orgid;
    
    
    
    public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getSku_num() {
		return sku_num;
	}
	public void setSku_num(String sku_num) {
		this.sku_num = sku_num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGoodId(){
        return goodId;
    }
    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getGoodName(){
        return goodName;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }

    public int getGoodPrice(){
        return goodPrice;
    }
    public void setGoodPrice(int goodPrice){
        this.goodPrice = goodPrice;
    }

    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
	
	public int getOnsale_status() {
		return onsale_status;
	}
	public void setOnsale_status(int onsale_status) {
		this.onsale_status = onsale_status;
	}
	public Date getOnsale_time() {
		return onsale_time;
	}
	public void setOnsale_time(Date onsale_time) {
		this.onsale_time = onsale_time;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeight_unit() {
		return weight_unit;
	}
	public void setWeight_unit(String weight_unit) {
		this.weight_unit = weight_unit;
	}
}