package com.marks.smart.market.mall.dispatch.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class DispatchGood implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品单号
	 *
	 */
	private String orderGoodId;
	/**
	 * 订单编号
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
	 * 品类编号
	 *
	 */
	private String typeId;
	/**
	 * 品类
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
	 * 赠送数量
	 *
	 */
	private int sendNums;
	/**
	 * 采购数量
	 *
	 */
	private int purchaseNums;
	/**
	 * 采购价
	 *
	 */
	private String costPrice;
	/**
	 * 实购价
	 *
	 */
	private String payPrice;
	/**
	 * 小计
	 *
	 */
	private String amt;
	/**
	 * 应付金额
	 *
	 */
	private String payableAmt;
	/**
	 * 实付金额
	 *
	 */
	private String payAmt;
	/**
	 * 未付金额
	 *
	 */
	private String unpayAmt;
	/**
	 * 创建时间
	 *
	 */
	private String createtime;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
	/**
	 * 配送数量
	 *
	 */
	private int dispatchNums;
	// 已配送数量
	private int hadDispatchNums;
	/**
	 * 收货数量
	 *
	 */
	private int receiveNums;

	// 已收数量
	private int hadReceiveNums;
	/**
	 * 库存方式
	 *
	 */
	private int stockType;
	/**
	 * 库存方式
	 *
	 */
	private String stockTypeName;

	private int taxRate;// 税率

	private String taxAmt;// 税额

	private String salePrice;// 零售价

	private String saleAmt;// 零售金额

	private String remarks;// 备注；

	private int hadRefundNums;// 退货数量

	private int refundNums;// 退货数量

	private String dispatchPrice;// 配送价

	private String companyId;
	
	private int stockNums;//库存数量

	public DispatchGood() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}
	public int getStockNums() {
		return stockNums;
	}



	public void setStockNums(int stockNums) {
		this.stockNums = stockNums;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDispatchPrice() {
		return dispatchPrice;
	}

	public void setDispatchPrice(String dispatchPrice) {
		this.dispatchPrice = dispatchPrice;
	}

	public int getHadRefundNums() {
		return hadRefundNums;
	}

	public void setHadRefundNums(int hadRefundNums) {
		this.hadRefundNums = hadRefundNums;
	}

	public int getRefundNums() {
		return refundNums;
	}

	public void setRefundNums(int refundNums) {
		this.refundNums = refundNums;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getHadDispatchNums() {
		return hadDispatchNums;
	}

	public void setHadDispatchNums(int hadDispatchNums) {
		this.hadDispatchNums = hadDispatchNums;
	}

	public int getHadReceiveNums() {
		return hadReceiveNums;
	}

	public void setHadReceiveNums(int hadReceiveNums) {
		this.hadReceiveNums = hadReceiveNums;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getSaleAmt() {
		return saleAmt;
	}

	public void setSaleAmt(String saleAmt) {
		this.saleAmt = saleAmt;
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

	public int getSendNums() {
		return sendNums;
	}

	public void setSendNums(int sendNums) {
		this.sendNums = sendNums;
	}

	public int getPurchaseNums() {
		return purchaseNums;
	}

	public void setPurchaseNums(int purchaseNums) {
		this.purchaseNums = purchaseNums;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(String payableAmt) {
		this.payableAmt = payableAmt;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getUnpayAmt() {
		return unpayAmt;
	}

	public void setUnpayAmt(String unpayAmt) {
		this.unpayAmt = unpayAmt;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getDispatchNums() {
		return dispatchNums;
	}

	public void setDispatchNums(int dispatchNums) {
		this.dispatchNums = dispatchNums;
	}

	public int getReceiveNums() {
		return receiveNums;
	}

	public void setReceiveNums(int receiveNums) {
		this.receiveNums = receiveNums;
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

	public String toLog() {
		return " - orderGoodId:" + String.valueOf(orderGoodId) + " - orderId:" + String.valueOf(orderId) + " - goodId:"
				+ String.valueOf(goodId) + " - goodCode:" + String.valueOf(goodNo) + " - goodName:"
				+ String.valueOf(goodName) + " - barNo:" + String.valueOf(barNo) + " - unit:" + String.valueOf(unit)
				+ " - rank:" + String.valueOf(rank) + " - fzSize:" + " - model:" + String.valueOf(model) + " - typeId:"
				+ String.valueOf(typeId)
				+ " - typeName:" + String.valueOf(typeName) + " - brandId:" + String.valueOf(brandId) + " - brandName:"
				+ String.valueOf(brandName) + " - nums:" + String.valueOf(nums) + " - sendNums:"
				+ String.valueOf(sendNums) + " - purchaseNums:" + String.valueOf(purchaseNums) + " - purchasePrice:"
				+ String.valueOf(costPrice) + " - payPrice:" + String.valueOf(payPrice) + " - amt:"
				+ String.valueOf(amt) + " - payableAmt:" + String.valueOf(payableAmt) + " - payAmt:"
				+ String.valueOf(payAmt) + " - unpayAmt:" + String.valueOf(unpayAmt) + " - createtime:"
				+ String.valueOf(createtime) + " - updatetime:" + String.valueOf(updatetime) + " - dispatchNums:"
				+ String.valueOf(dispatchNums) + " - receiveNums:" + String.valueOf(receiveNums) + " - stockType:"
				+ String.valueOf(stockType) + " - stockTypeName:" + String.valueOf(stockTypeName);
	}
}