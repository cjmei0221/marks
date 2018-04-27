package com.marks.module.fee.log.pojo;

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
	 * 收款人编号
	 *
	 */
	private String payeeId;
	/**
	 * 收款人手机号
	 *
	 */
	private String payeeMobile;
	/**
	 * 收款人
	 *
	 */
	private String payeeName;
	/**
	 * 角色类型
	 *
	 */
	private String payeeRoleType;
	/**
	 * 角色类型
	 *
	 */
	private String payeeRole;
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
	private String year;
	/**
	 * 月
	 *
	 */
	private String month;

	private int season;
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

	public FeeLog() {
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
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

	public int getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeMobile() {
		return payeeMobile;
	}

	public void setPayeeMobile(String payeeMobile) {
		this.payeeMobile = payeeMobile;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeRoleType() {
		return payeeRoleType;
	}

	public void setPayeeRoleType(String payeeRoleType) {
		this.payeeRoleType = payeeRoleType;
	}

	public String getPayeeRole() {
		return payeeRole;
	}

	public void setPayeeRole(String payeeRole) {
		this.payeeRole = payeeRole;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public String toLog() {
		return " - id:" + String.valueOf(id) + " - companyId:" + String.valueOf(companyId) + " - feeCode:"
				+ String.valueOf(feeCode) + " - feeName:" + String.valueOf(feeName) + " - itemCode:"
				+ String.valueOf(itemCode) + " - itemName:" + String.valueOf(itemName) + " - tranTime:"
				+ String.valueOf(tranTime) + " - tranAmt:" + String.valueOf(tranAmt) + " - inOrOut:"
				+ String.valueOf(inOrOut) + " - remarks:" + String.valueOf(remarks) + " - payeeId:"
				+ String.valueOf(payeeId) + " - payeeMobile:" + String.valueOf(payeeMobile) + " - payeeName:"
				+ String.valueOf(payeeName) + " - payeeRoleType:" + String.valueOf(payeeRoleType) + " - payeeRole:"
				+ String.valueOf(payeeRole) + " - payeeOrgId:" + String.valueOf(payeeOrgId) + " - payeeOrgName:"
				+ String.valueOf(payeeOrgName) + " - payeeCode:" + String.valueOf(payeeCode) + " - year:"
				+ String.valueOf(year) + " - month:" + String.valueOf(month) + " - idNo:" + String.valueOf(idNo)
				+ " - updatetime:" + String.valueOf(updatetime);
	}
}