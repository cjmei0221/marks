package com.marks.smart.market.mall.stock.pojo;

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
	private String ywName;
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

	private String balAmt;// 剩余金额

	private int balNums;// 剩余数量

	private int tranNums;// 交易数量
	private String tranAmt;// 交易金额
	private String tranOutAmt;// 交易售出金额
	private int tranStatus;// 交易类型

	/**
	 * 品类ID
	 *
	 */
	private String typeId;
	/**
	 * 品类
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

	private String costPrice;// 进货价

	private String stockId;// 库存编号
	private String operator;// 操作人

	private String tradePrice;// 配送价

	private String tradePriceAmt;// 配送价

	private int goodType;// 商品类型

	private String goodTypeName;// 商品类型

	private String orderId;// 订单号

	private String stockBalAmt;// 库存剩余金额

	private int stockBalNums;// 库存剩余数量

	private int dispatchOutNums;// 调出数量

	private String dispatchOutAmt;// 调出金额

	private int outNums;// 出库数量

	private String outAmt;// 出库金额

	public String getDispatchOutAmt() {
		return dispatchOutAmt;
	}

	public void setDispatchOutAmt(String dispatchOutAmt) {
		this.dispatchOutAmt = dispatchOutAmt;
	}

	public int getOutNums() {
		return outNums;
	}

	public void setOutNums(int outNums) {
		this.outNums = outNums;
	}

	public String getOutAmt() {
		return outAmt;
	}

	public void setOutAmt(String outAmt) {
		this.outAmt = outAmt;
	}

	public int getDispatchOutNums() {
		return dispatchOutNums;
	}

	public void setDispatchOutNums(int dispatchOutNums) {
		this.dispatchOutNums = dispatchOutNums;
	}

	public String getStockBalAmt() {
		return stockBalAmt;
	}

	public void setStockBalAmt(String stockBalAmt) {
		this.stockBalAmt = stockBalAmt;
	}

	public int getStockBalNums() {
		return stockBalNums;
	}

	public void setStockBalNums(int stockBalNums) {
		this.stockBalNums = stockBalNums;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getGoodType() {
		return goodType;
	}

	public void setGoodType(int goodType) {
		this.goodType = goodType;
	}

	public String getGoodTypeName() {
		return StockEnums.StockType.getByKey(goodType);
	}

	public String getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getTradePriceAmt() {
		return tradePriceAmt;
	}

	public void setTradePriceAmt(String tradePriceAmt) {
		this.tradePriceAmt = tradePriceAmt;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public int getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(int tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
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
	
	public String getTranOutAmt() {
		return tranOutAmt;
	}

	public void setTranOutAmt(String tranOutAmt) {
		this.tranOutAmt = tranOutAmt;
	}

	public int getTranNums() {
		return tranNums;
	}

	public void setTranNums(int tranNums) {
		this.tranNums = tranNums;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}

	public int getBalNums() {
		return balNums;
	}

	public void setBalNums(int balNums) {
		this.balNums = balNums;
	}

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

	public String getYwName() {
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
}