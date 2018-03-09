package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.enums.StockEnums;

public class BarCode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 条码
	 *
	 */
	private String barcode;
	/**
	 * 公司ID
	 *
	 */
	private String companyId;
	/**
	 * 商品编码
	 *
	 */
	private String goodId;
	/**
	 * 商品条码
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
	 * 追踪码
	 *
	 */
	private String traceId;
	/**
	 * 激活状态 0:未使用 1:使用中
	 */
	private int activeStatus;
	/**
	 * 库存状态
	 *
	 */
	private int stockStatus;
	/**
	 * 机构ID
	 *
	 */
	private String orgid;
	/**
	 * 机构名称
	 *
	 */
	private String orgname;
	/**
	 * 生产日期
	 *
	 */
	private String productDate;
	/**
	 * 到期日期
	 */
	private String expireDate;

	private int isWarnDays;// 是否提醒保质期到期

	private int beforeWarnDays = 15;// 提前天数

	private String batchId;// 批次号

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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String toLog() {
		return " - barcode:" + String.valueOf(barcode) + " - companyId:" + String.valueOf(companyId) + " - goodId:"
				+ String.valueOf(goodId) + " - goodNo:" + String.valueOf(goodNo) + " - barNo:" + String.valueOf(barNo)
				+ " - goodName:" + String.valueOf(goodName) + " - createtime:" + String.valueOf(createtime)
				+ " - updatetime:" + String.valueOf(updatetime) + " - traceId:" + String.valueOf(traceId)
				+ " - activeStatus:" + String.valueOf(activeStatus) + " - stockStatus:" + String.valueOf(stockStatus)
				+ " - orgid:" + String.valueOf(orgid) + " - orgname:" + String.valueOf(orgname) + " - productDate:"
				+ String.valueOf(productDate);
	}
}