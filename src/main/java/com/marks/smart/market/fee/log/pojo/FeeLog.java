package com.marks.smart.market.fee.log.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class FeeLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 单号
	 *
	 */
	private String id;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 科目编号
	 *
	 */
	private String feeCode;
	/**
	 * 科目名称
	 *
	 */
	private String feeName;
	/**
	 * 条目编号
	 *
	 */
	private String itemCode;
	/**
	 * 条目名称
	 *
	 */
	private String itemName;
	/**
	 * 交易时间
	 *
	 */
	private String tranTime;
	/**
	 * 交易金额
	 *
	 */
	private String tranAmt;
	/**
	 * 收支 0:支出 1:收入
	 */
	private int inOrOut;
	/**
	 * 备注
	 *
	 */
	private String remarks;

	/**
	 * 收款人
	 *
	 */
	private String payeeName;

	/**
	 * 机构
	 *
	 */
	private String payeeOrgId;
	/**
	 * 机构
	 *
	 */
	private String payeeOrgName;
	/**
	 * 编号
	 *
	 */
	private String payeeCode;
	/**
	 * 年
	 *
	 */
	private int i_year;
	/**
	 * 月
	 *
	 */
	private int i_month;

	private int i_season;
	/**
	 * 关联单号
	 *
	 */
	private String idNo;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;

	private String creator;//
	private int isDel;
	private String tranDate;// 交易日期

	private String salesManCode;
	private String salesMan;// 营业员

	private String whMan;

	private String whManCode;

	public FeeLog() {
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getSalesManCode() {
		return salesManCode;
	}

	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	}

	public String getSalesMan() {
		return salesMan;
	}

	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}

	public String getWhMan() {
		return whMan;
	}

	public void setWhMan(String whMan) {
		this.whMan = whMan;
	}

	public String getWhManCode() {
		return whManCode;
	}

	public void setWhManCode(String whManCode) {
		this.whManCode = whManCode;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getTranAmtShow() {
		return inOrOut == 0 ? "-" + tranAmt : tranAmt;
	}

	public int getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getInOrOutStr() {
		return inOrOut == 0 ? "支出" : "收入";
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeOrgId() {
		return payeeOrgId;
	}

	public void setPayeeOrgId(String payeeOrgId) {
		this.payeeOrgId = payeeOrgId;
	}

	public String getPayeeOrgName() {
		return payeeOrgName;
	}

	public void setPayeeOrgName(String payeeOrgName) {
		this.payeeOrgName = payeeOrgName;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getI_year() {
		return i_year;
	}

	public void setI_year(int i_year) {
		this.i_year = i_year;
	}

	public int getI_month() {
		return i_month;
	}

	public void setI_month(int i_month) {
		this.i_month = i_month;
	}

	public int getI_season() {
		return i_season;
	}

	public void setI_season(int i_season) {
		this.i_season = i_season;
	}

}