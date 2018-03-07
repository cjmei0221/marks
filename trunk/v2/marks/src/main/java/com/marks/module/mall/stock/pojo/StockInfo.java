package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class StockInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 库存编号
	 *
	 */
	private String stockId;
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
	 * 商品系统编号
	 *
	 */
	private String goodId;
	/**
	 * 库存数量
	 *
	 */
	private int stockNums;
	/**
	 * 库存金额
	 *
	 */
	private String stockAmount;
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
	 * 次品数量
	 *
	 */
	private int secondNums;
	/**
	 * 次品金额
	 *
	 */
	private String secondAmount;
	/**
	 * 预占数量
	 *
	 */
	private int holdNums;
	/**
	 * 预占金额
	 *
	 */
	private String holdAmount;
	/**
	 * 报废数量
	 *
	 */
	private int scrapNums;
	/**
	 * 报废金额
	 *
	 */
	private String scrapAmount;
	/**
	 * 赠品数量
	 *
	 */
	private int giftNums;
	/**
	 * 赠品金额
	 *
	 */
	private String giftAmount;
	/**
	 * 总数量 库存 预占 赠品，不含残次品、报废商品
	 */
	private int totalNums;
	/**
	 * 总金额 库存 预占 赠品，不含残次品、报废商品
	 */
	private String totalAmount;

	private String goodNo;// 商品编码

	private String barNo;// 商品编码

	private String goodName;// 商品编码

	private String saleAmt;// 售出数量
	private int saleNums;// 售出数量

	public StockInfo() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public String getSaleAmt() {
		return saleAmt;
	}

	public void setSaleAmt(String saleAmt) {
		this.saleAmt = saleAmt;
	}

	public int getSaleNums() {
		return saleNums;
	}

	public void setSaleNums(int saleNums) {
		this.saleNums = saleNums;
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

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
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

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public int getStockNums() {
		return stockNums;
	}

	public void setStockNums(int stockNums) {
		this.stockNums = stockNums;
	}

	public String getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(String stockAmount) {
		this.stockAmount = stockAmount;
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

	public int getSecondNums() {
		return secondNums;
	}

	public void setSecondNums(int secondNums) {
		this.secondNums = secondNums;
	}

	public String getSecondAmount() {
		return secondAmount;
	}

	public void setSecondAmount(String secondAmount) {
		this.secondAmount = secondAmount;
	}

	public int getHoldNums() {
		return holdNums;
	}

	public void setHoldNums(int holdNums) {
		this.holdNums = holdNums;
	}

	public String getHoldAmount() {
		return holdAmount;
	}

	public void setHoldAmount(String holdAmount) {
		this.holdAmount = holdAmount;
	}

	public int getScrapNums() {
		return scrapNums;
	}

	public void setScrapNums(int scrapNums) {
		this.scrapNums = scrapNums;
	}

	public String getScrapAmount() {
		return scrapAmount;
	}

	public void setScrapAmount(String scrapAmount) {
		this.scrapAmount = scrapAmount;
	}

	public int getGiftNums() {
		return giftNums;
	}

	public void setGiftNums(int giftNums) {
		this.giftNums = giftNums;
	}

	public String getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(String giftAmount) {
		this.giftAmount = giftAmount;
	}

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String toLog() {
		return " - stockId:" + String.valueOf(stockId) + " - companyId:" + String.valueOf(companyId) + " - orgId:"
				+ String.valueOf(orgId) + " - orgName:" + String.valueOf(orgName) + " - goodId:"
				+ String.valueOf(goodId) + " - stockNums:" + String.valueOf(stockNums) + " - stockAmount:"
				+ String.valueOf(stockAmount) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - secondNums:" + String.valueOf(secondNums) + " - secondAmount:"
				+ String.valueOf(secondAmount) + " - holdNums:" + String.valueOf(holdNums) + " - holdAmount:"
				+ String.valueOf(holdAmount) + " - scrapNums:" + String.valueOf(scrapNums) + " - scrapAmount:"
				+ String.valueOf(scrapAmount) + " - giftNums:" + String.valueOf(giftNums) + " - giftAmount:"
				+ String.valueOf(giftAmount) + " - totalNums:" + String.valueOf(totalNums) + " - totalAmount:"
				+ String.valueOf(totalAmount);
	}
}