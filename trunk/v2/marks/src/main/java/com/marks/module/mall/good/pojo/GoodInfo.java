package com.marks.module.mall.good.pojo;

import java.io.Serializable;
import java.util.Date;

public class GoodInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	private String goodId;
	/**
	 * 商品名称 品牌+商品名称+规格+单位
	 */
	private String goodName;

	/**
	 * 商品单位
	 */
	private String unit;
	/**
	 * 商品主图
	 */
	private String imageUrl;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 创建者
	 */
	private String creator;

	private String brandId;// 品牌

	private String brandName;// 品牌

	private String madeIn;// 产地

	private String material;// 材质

	private String description;// 特色描述

	private String remark;// 备注

	private int onsale_status;// 上架状态 1：上架 2：未上架 3：下架

	private Date onsale_time;// 上架时间

	private String weight;
	private String weight_unit = "Kg";

	private String companyId;

	private String updater;

	private String goodNo;// 自编吗

	private String barNo;// 条码
	/**
	 * 商品原价
	 */
	private String price;

	private String salePrice;// 售价

	private String minPrice;// 最低价


	private String stockPrice;// 进货价
	private String rank;

	private String model;

	private String typeId;

	private String typeName;

	private int goodType;// 商品类型 0:商品 1:赠品和商品 2:赠品

	private int stockManageType;// 商品库存管理方式 0:一瓶一码 1:数量管理
	private String supplierId;
	private String supplier;

	private int validDays;// 保质期 天

	private int isWarnDays = 0;// 是否提醒保质期到期

	private int beforeWarnDays = 15;// 提前天数



	public int getValidDays() {
		return validDays;
	}

	public void setValidDays(int validDays) {
		this.validDays = validDays;
	}

	public int getIsWarnDays() {
		return isWarnDays;
	}

	public void setIsWarnDays(int isWarnDays) {
		this.isWarnDays = isWarnDays;
	}

	public int getBeforeWarnDays() {
		return beforeWarnDays;
	}

	public void setBeforeWarnDays(int beforeWarnDays) {
		this.beforeWarnDays = beforeWarnDays;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getGoodType() {
		return goodType;
	}

	public void setGoodType(int goodType) {
		this.goodType = goodType;
	}

	public int getStockManageType() {
		return stockManageType;
	}

	public void setStockManageType(int stockManageType) {
		this.stockManageType = stockManageType;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getGoodNo() {
		return goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public String getBarNo() {
		return barNo;
	}

	public void setBarNo(String barNo) {
		this.barNo = barNo;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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