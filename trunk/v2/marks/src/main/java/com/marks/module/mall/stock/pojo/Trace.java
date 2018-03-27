package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.enums.StockEnums;

public class Trace implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 追踪码
	 *
	 */
	private String traceId;
	/**
	 * 条码
	 *
	 */
	private String barcode;
	/**
	 * 商品编码
	 *
	 */
	private String goodId;
	/**
	 * 商品编号
	 *
	 */
	private String goodNo;
	/**
	 * 国际条码
	 *
	 */
	private String barNo;
	/**
	 * 商品名称
	 *
	 */
	private String goodName;
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
	 * 库存状态
	 *
	 */
	private int stockStatus;
	/**
	 * 采购单号
	 *
	 */
	private String cgNo;

	private String batchId;// 批次号
	/**
	 * 原价
	 *
	 */
	private String price;
	/**
	 * 售价
	 *
	 */
	private String salePrice;
	/**
	 * 进货价
	 *
	 */
	private String stockPrice;
	/**
	 * 订单号
	 *
	 */
	private String orderId;
	/**
	 * 订单商品号
	 *
	 */
	private String orderGoodId;
	/**
	 * 是否为赠品 0:非赠品 1:赠品
	 */
	private int isGift;
	/**
	 * 原追踪码
	 *
	 */
	private String oriTraceId;
	/**
	 * 公司ID
	 *
	 */
	private String companyId;
	/**
	 * 机构ID
	 *
	 */
	private String orgid;
	/**
	 * 机构
	 *
	 */
	private String orgname;
	/**
	 * 类别ID
	 *
	 */
	private String typeId;
	/**
	 * 类别
	 *
	 */
	private String typeName;
	/**
	 * 品牌ID
	 *
	 */
	private String brandId;
	/**
	 * 品牌
	 *
	 */
	private String brandName;
	/**
	 * 生产日期
	 *
	 */
	private String productDate;
	/**
	 * 到期日期
	 */
	private String expireDate;
	/**
	 * 供应商ID
	 *
	 */
	private String supplierId;
	/**
	 * 供应商
	 *
	 */
	private String supplierName;
	/**
	 * 会员ID
	 *
	 */
	private String userid;
	/**
	 * 会员名称
	 *
	 */
	private String username;
	/**
	 * 会员手机号
	 *
	 */
	private String mobile;
	/**
	 * 入库日期
	 *
	 */
	private String stockInDate;
	/**
	 * 结束日期
	 *
	 */
	private String endDate;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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

	public String getBarNo() {
		return barNo;
	}

	public void setBarNo(String barNo) {
		this.barNo = barNo;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
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

	public int getStockStatus() {
		return stockStatus;
	}

	public String getStockStatusName() {
		return StockEnums.StockStatus.getByKey(stockStatus);
	}

	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderGoodId() {
		return orderGoodId;
	}

	public void setOrderGoodId(String orderGoodId) {
		this.orderGoodId = orderGoodId;
	}

	public int getIsGift() {
		return isGift;
	}

	public void setIsGift(int isGift) {
		this.isGift = isGift;
	}

	public String getOriTraceId() {
		return oriTraceId;
	}

	public void setOriTraceId(String oriTraceId) {
		this.oriTraceId = oriTraceId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
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

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(String stockInDate) {
		this.stockInDate = stockInDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String toLog() {
		return " - traceId:" + String.valueOf(traceId) + " - barcode:" + String.valueOf(barcode) + " - goodId:"
				+ String.valueOf(goodId) + " - goodNo:" + String.valueOf(goodNo) + " - barNo:" + String.valueOf(barNo)
				+ " - goodName:" + String.valueOf(goodName) + " - createtime:" + String.valueOf(createtime)
				+ " - updatetime:" + String.valueOf(updatetime) + " - stockStatus:" + String.valueOf(stockStatus)
				+ " - cgNo:" + String.valueOf(cgNo) + " - price:" + String.valueOf(price) + " - vipPrice:"
				+ " - salePrice:" + String.valueOf(salePrice) + " - nowPrice:" + " - stockPrice:"
				+ String.valueOf(stockPrice) + " - orderId:"
				+ String.valueOf(orderId) + " - orderGoodId:" + String.valueOf(orderGoodId) + " - isGift:"
				+ String.valueOf(isGift) + " - oriTraceId:" + String.valueOf(oriTraceId) + " - companyId:"
				+ String.valueOf(companyId) + " - orgid:" + String.valueOf(orgid) + " - orgname:"
				+ String.valueOf(orgname) + " - typeId:" + String.valueOf(typeId) + " - typeName:"
				+ String.valueOf(typeName) + " - brandId:" + String.valueOf(brandId) + " - brandName:"
				+ String.valueOf(brandName) + " - productDate:" + String.valueOf(productDate) + " - supplierId:"
				+ String.valueOf(supplierId) + " - supplierName:" + String.valueOf(supplierName) + " - userid:"
				+ String.valueOf(userid) + " - username:" + String.valueOf(username) + " - mobile:"
				+ String.valueOf(mobile) + " - stockInDate:" + String.valueOf(stockInDate) + " - endDate:"
				+ String.valueOf(endDate);
	}
}