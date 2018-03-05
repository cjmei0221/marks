package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.enums.StockEnums;
import com.marks.common.util.date.DateUtil;

public class StockBatch implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 批次号
	 *
	 */
	private String batchId;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 机构编号
	 *
	 */
	private String orgId;
	/**
	 * 机构名称
	 *
	 */
	private String orgName;
	/**
	 * 数量
	 *
	 */
	private int nums;
	/**
	 * 金额
	 *
	 */
	private String amount;
	/**
	 * 商品编号
	 *
	 */
	private String goodId;
	/**
	 * 商品名称
	 *
	 */
	private String goodName;
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
	 * 业务类型
	 *
	 */
	private int ywCode;
	/**
	 * 业务类型
	 *
	 */
	private String ywCodeName;
	/**
	 * 进货价
	 *
	 */
	private String stockPrice;
	/**
	 * 生产日期
	 *
	 */
	private String productDate;
	/**
	 * 到期日期
	 *
	 */
	private String expireDate;
	/**
	 * 供应商编号
	 *
	 */
	private String supplierId;
	/**
	 * 供应商
	 *
	 */
	private String supplierName;
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
	 * 更新者
	 *
	 */
	private String updater;
	/**
	 * 备注
	 *
	 */
	private String remarks;

	private int saleNums;// 售出数量

	private String saleAmount;// 售出金额

	public int getSaleNums() {
		return saleNums;
	}

	public void setSaleNums(int saleNums) {
		this.saleNums = saleNums;
	}

	public String getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(String saleAmount) {
		this.saleAmount = saleAmount;
	}

	public StockBatch() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public String getStockTypeName() {
		return StockEnums.StockManageType.getByKey(stockType);
	}

	public String getYwCodeName() {
		return StockEnums.YwCode.getByKey(ywCode);
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public int getYwCode() {
		return ywCode;
	}

	public void setYwCode(int ywCode) {
		this.ywCode = ywCode;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
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

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String toLog() {
		return " - batchId:" + String.valueOf(batchId) + " - companyId:" + String.valueOf(companyId) + " - orgId:"
				+ String.valueOf(orgId) + " - orgName:" + String.valueOf(orgName) + " - nums:" + String.valueOf(nums)
				+ " - amount:" + String.valueOf(amount) + " - goodId:" + String.valueOf(goodId) + " - goodName:"
				+ String.valueOf(goodName) + " - goodNo:" + String.valueOf(goodNo) + " - barNo:" + String.valueOf(barNo)
				+ " - stockType:" + String.valueOf(stockType) + " - ywCode:" + String.valueOf(ywCode) + " - stockPrice:"
				+ String.valueOf(stockPrice) + " - productDate:" + String.valueOf(productDate) + " - expireDate:"
				+ String.valueOf(expireDate) + " - supplierId:" + String.valueOf(supplierId) + " - supplierName:"
				+ String.valueOf(supplierName) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - updater:" + String.valueOf(updater) + " - remarks:"
				+ String.valueOf(remarks);
	}
}