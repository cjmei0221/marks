package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class AdjustGood implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 *
	 */
	private String orderGoodId;
	/**
	 * 单号
	 *
	 */
	private String orderId;
	/**
	 * 商品编号
	 *
	 */
	private String goodId;
	/**
	 * 商品编号
	 *
	 */
	private String goodNo;
	/**
	 * 商品名称
	 *
	 */
	private String goodName;
	/**
	 * 商品条码
	 *
	 */
	private String barNo;
	/**
	 * 助记码
	 *
	 */
	private String helpCode;
	/**
	 * 单位
	 *
	 */
	private String unit;
	/**
	 * 规格
	 *
	 */
	private String rank;
	/**
	 * 型号
	 *
	 */
	private String model;
	/**
	 * 类别
	 *
	 */
	private String typeId;
	/**
	 * 类别
	 *
	 */
	private String typeName;
	/**
	 * 品牌
	 *
	 */
	private String brandId;
	/**
	 * 品牌
	 *
	 */
	private String brandName;
	/**
	 * 数量
	 *
	 */
	private int nums;
	/**
	 * 进价
	 *
	 */
	private String costPrice;
	/**
	 * 库存管理方式
	 *
	 */
	private int stockType;
	/**
	 * 库存管理方式
	 *
	 */
	private String stockTypeName;
	/**
	 * 配送价
	 *
	 */
	private String dispatchPrice;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;

	private String companyId;

	public AdjustGood() {
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrderGoodId() {
		return orderGoodId;
	}

	public void setOrderGoodId(String orderGoodId) {
		this.orderGoodId = orderGoodId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodNo() {
		return goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getBarNo() {
		return barNo;
	}

	public void setBarNo(String barNo) {
		this.barNo = barNo;
	}

	public String getHelpCode() {
		return helpCode;
	}

	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getDispatchPrice() {
		return dispatchPrice;
	}

	public void setDispatchPrice(String dispatchPrice) {
		this.dispatchPrice = dispatchPrice;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String toLog() {
		return " - orderGoodId:" + String.valueOf(orderGoodId) + " - orderId:" + String.valueOf(orderId) + " - goodId:"
				+ String.valueOf(goodId) + " - goodNo:" + String.valueOf(goodNo) + " - goodName:"
				+ String.valueOf(goodName) + " - barNo:" + String.valueOf(barNo) + " - helpCode:"
				+ String.valueOf(helpCode) + " - unit:" + String.valueOf(unit) + " - rank:" + String.valueOf(rank)
				+ " - model:" + String.valueOf(model) + " - typeId:" + String.valueOf(typeId) + " - typeName:"
				+ String.valueOf(typeName) + " - brandId:" + String.valueOf(brandId) + " - brandName:"
				+ String.valueOf(brandName) + " - nums:" + String.valueOf(nums) + " - costPrice:"
				+ String.valueOf(costPrice) + " - stockType:" + String.valueOf(stockType) + " - stockTypeName:"
				+ String.valueOf(stockTypeName) + " - dispatchPrice:" + String.valueOf(dispatchPrice) + " - updatetime:"
				+ String.valueOf(updatetime);
	}
}