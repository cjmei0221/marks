package com.marks.module.mall.stock.pojo;

import java.io.Serializable;

import com.marks.common.enums.Enums;
import com.marks.common.enums.StockAdjustEnums;
import com.marks.common.util.date.DateUtil;

public class AdjustInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String companyId;

	/**
	 * 单号
	 *
	 */
	private String orderId;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
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
	 * 总数量
	 *
	 */
	private int totalNums;
	/**
	 * 总金额
	 *
	 */
	private String totalAmt;
	/**
	 * 创建时间
	 *
	 */
	private String createtime;
	/**
	 * 制单人编号
	 *
	 */
	private String creatorCode;
	/**
	 * 制单人
	 *
	 */
	private String creatorName;
	/**
	 * 创建日期
	 *
	 */
	private String createDate;
	/**
	 * 单状态
	 *
	 */
	private int status;

	private String statusName;
	/**
	 * 审核状态
	 *
	 */
	private int checkStatus;
	private String checkStatusName;
	/**
	 * 审核人
	 *
	 */
	private String checkerId;
	/**
	 * 审核人
	 *
	 */
	private String checker;
	/**
	 * 审核时间
	 *
	 */
	private String checkTime;
	/**
	 * 业务类型
	 *
	 */
	private String ywCode;
	/**
	 * 业务类型
	 *
	 */
	private String ywName;
	/**
	 * 类别
	 *
	 */
	private String typeCode;
	/**
	 * 类别
	 *
	 */
	private String typeName;

	private String remarks;

	public AdjustInfo() {
		this.updatetime = DateUtil.getCurrDateStr();
		this.createtime = DateUtil.getCurrDateStr();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCheckStatusName() {
		return Enums.CheckStatus.getByKey(checkStatus);
	}

	public String getStatusName() {
		return StockAdjustEnums.Status.getByKey(status);
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
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

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreatorCode() {
		return creatorCode;
	}

	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getYwCode() {
		return ywCode;
	}

	public void setYwCode(String ywCode) {
		this.ywCode = ywCode;
	}

	public String getYwName() {
		return StockAdjustEnums.YwCode.getByKey(ywCode);
	}


	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return StockAdjustEnums.TypeCode.getByKey(typeCode);
	}

	public String toLog() {
		return " - orderId:" + String.valueOf(orderId) + " - updatetime:" + String.valueOf(updatetime) + " - orgId:"
				+ String.valueOf(orgId) + " - orgName:" + String.valueOf(orgName) + " - totalNums:"
				+ String.valueOf(totalNums) + " - totalAmt:" + String.valueOf(totalAmt) + " - createtime:"
				+ String.valueOf(createtime) + " - creatorCode:" + String.valueOf(creatorCode) + " - creatorName:"
				+ String.valueOf(creatorName) + " - createDate:" + String.valueOf(createDate) + " - status:"
				+ String.valueOf(status) + " - checkStatus:" + String.valueOf(checkStatus) + " - checkerId:"
				+ String.valueOf(checkerId) + " - checker:" + String.valueOf(checker) + " - checkTime:"
				+ String.valueOf(checkTime) + " - ywCode:" + String.valueOf(ywCode) + " - ywName:"
				+ String.valueOf(ywName) + " - typeCode:" + String.valueOf(typeCode) + " - typeName:"
				+ String.valueOf(typeName);
	}
}