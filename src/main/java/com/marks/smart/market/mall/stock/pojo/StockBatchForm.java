package com.marks.smart.market.mall.stock.pojo;

public class StockBatchForm {
	/**
	 * 商品编码
	 *
	 */
	private String goodId;

	/**
	 * 生产日期
	 *
	 */
	private String productDate;
	/**
	 * 采购单号
	 *
	 */
	private String orderId;
	/**
	 * 进货价
	 *
	 */
	private String costPrice;

	private int nums;

	private String companyId;
	private String orgid;
	private String orgname;
	private String operator;

	private int stockManageType;// 库存管理方式

	private String supplierId2;// 供应商编号
	private String supplier2;// 供应商

	private int ywCode;// 业务

	private int stockStatus;

	private String remarks;

	private int tranSaleNums;// 售出数量
	private String tranSaleAmt;// 售出金额
	
	private int stockType;

	

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public int getTranSaleNums() {
		return tranSaleNums;
	}

	public void setTranSaleNums(int tranSaleNums) {
		this.tranSaleNums = tranSaleNums;
	}

	public String getTranSaleAmt() {
		return tranSaleAmt;
	}

	public void setTranSaleAmt(String tranSaleAmt) {
		this.tranSaleAmt = tranSaleAmt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}

	public int getYwCode() {
		return ywCode;
	}

	public void setYwCode(int ywCode) {
		this.ywCode = ywCode;
	}

	public int getStockManageType() {
		return stockManageType;
	}

	public void setStockManageType(int stockManageType) {
		this.stockManageType = stockManageType;
	}

	public String getSupplierId2() {
		return supplierId2;
	}

	public void setSupplierId2(String supplierId2) {
		this.supplierId2 = supplierId2;
	}

	public String getSupplier2() {
		return supplier2;
	}

	public void setSupplier2(String supplier2) {
		this.supplier2 = supplier2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

}
