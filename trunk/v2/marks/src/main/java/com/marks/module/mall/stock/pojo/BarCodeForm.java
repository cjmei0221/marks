package com.marks.module.mall.stock.pojo;

public class BarCodeForm {
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
	private String cgNo;
	/**
	 * 进货价
	 *
	 */
	private String stockPrice;

	private int nums;

	private String companyId;
	private String orgid;
	private String orgname;

	private String operatorId;
	private String operator;

	private int stockManageType;// 库存管理方式

	private String supplierId2;// 供应商编号
	private String supplier2;// 供应商

	private String batchId;// 批次号

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
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

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
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

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

}
