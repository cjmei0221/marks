package com.marks.module.mall.dispatch.pojo;

import java.io.Serializable;

import com.marks.common.enums.DispatchEnums;
import com.marks.common.enums.Enums;
import com.marks.common.util.date.DateUtil;

public class DispatchInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 单号
	 *
	 */
	private String orderId;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 单状态
	 *
	 */
	private int status;
	/**
	 * 要货门店
	 *
	 */
	private String receiveOrgId;
	/**
	 * 要货门店
	 *
	 */
	private String receiveOrgName;
	/**
	 * 年份
	 *
	 */
	private int i_year;
	/**
	 * 月份
	 *
	 */
	private int i_month;
	/**
	 * 季度
	 *
	 */
	private int i_season;
	/**
	 * 下单时间
	 *
	 */
	private String commitTime;
	/**
	 * 下单日期
	 *
	 */
	private String cashDate;
	/**
	 * 商品总额
	 *
	 */
	private String totalAmt;
	/**
	 * 应付金额
	 *
	 */
	private String payableAmt;
	/**
	 * 实付金额
	 *
	 */
	private String payAmt;
	/**
	 * 未付金额
	 *
	 */
	private String unpayAmt;
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
	 * 总数量
	 *
	 */
	private int totalNums;
	/**
	 * 优惠金额
	 *
	 */
	private String salesAmt;
	/**
	 * 赠送总数
	 *
	 */
	private int sendNums;
	/**
	 * 收货数量
	 *
	 */
	private int receiveNums;
	/**
	 * 配送数量
	 *
	 */
	private int dispatchNums;
	/**
	 * 发货门店
	 *
	 */
	private String sendOrgId;
	/**
	 * 发货门店
	 *
	 */
	private String sendOrgName;
	/**
	 * 申请人编号
	 *
	 */
	private String applyManId;
	/**
	 * 申请人编号
	 *
	 */
	private String applyManCode;
	/**
	 * 申请人
	 *
	 */
	private String applyMan;
	/**
	 * 联系人
	 *
	 */
	private String sendContactor;
	/**
	 * 联系电话
	 *
	 */
	private String sendContact;
	/**
	 * 审核状态
	 *
	 */
	private int checkStatus;
	/**
	 * 审核时间
	 *
	 */
	private String checkTime;
	/**
	 * 审核人
	 *
	 */
	private String checkCode;
	/**
	 * 审核人
	 *
	 */
	private String checker;
	/**
	 * 业务编号
	 *
	 */
	private String ywCode;
	/**
	 * 业务名称
	 *
	 */
	private String ywName;
	/**
	 * 类别编号
	 *
	 */
	private String typeCode;
	/**
	 * 类别
	 *
	 */
	private String typeName;
	/**
	 * 状态名称
	 *
	 */
	private String statusName;
	/**
	 * 审核状态
	 *
	 */
	private String checkStatusName;

	private String creatorCode;

	private String creator;

	private String deadlineDate;// 交货期限

	private String remarks;// 备注

	private int refundNums;

	public DispatchInfo() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public int getRefundNums() {
		return refundNums;
	}

	public void setRefundNums(int refundNums) {
		this.refundNums = refundNums;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getCreatorCode() {
		return creatorCode;
	}

	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReceiveOrgId() {
		return receiveOrgId;
	}

	public void setReceiveOrgId(String receiveOrgId) {
		this.receiveOrgId = receiveOrgId;
	}

	public String getReceiveOrgName() {
		return receiveOrgName;
	}

	public void setReceiveOrgName(String receiveOrgName) {
		this.receiveOrgName = receiveOrgName;
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

	public String getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	public String getCashDate() {
		return cashDate;
	}

	public void setCashDate(String cashDate) {
		this.cashDate = cashDate;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(String payableAmt) {
		this.payableAmt = payableAmt;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getUnpayAmt() {
		return unpayAmt;
	}

	public void setUnpayAmt(String unpayAmt) {
		this.unpayAmt = unpayAmt;
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

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public String getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}

	public int getSendNums() {
		return sendNums;
	}

	public void setSendNums(int sendNums) {
		this.sendNums = sendNums;
	}

	public int getReceiveNums() {
		return receiveNums;
	}

	public void setReceiveNums(int receiveNums) {
		this.receiveNums = receiveNums;
	}

	public int getDispatchNums() {
		return dispatchNums;
	}

	public void setDispatchNums(int dispatchNums) {
		this.dispatchNums = dispatchNums;
	}

	public String getSendOrgId() {
		return sendOrgId;
	}

	public void setSendOrgId(String sendOrgId) {
		this.sendOrgId = sendOrgId;
	}

	public String getSendOrgName() {
		return sendOrgName;
	}

	public void setSendOrgName(String sendOrgName) {
		this.sendOrgName = sendOrgName;
	}

	public String getApplyManId() {
		return applyManId;
	}

	public void setApplyManId(String applyManId) {
		this.applyManId = applyManId;
	}

	public String getApplyManCode() {
		return applyManCode;
	}

	public void setApplyManCode(String applyManCode) {
		this.applyManCode = applyManCode;
	}

	public String getApplyMan() {
		return applyMan;
	}

	public void setApplyMan(String applyMan) {
		this.applyMan = applyMan;
	}

	public String getSendContactor() {
		return sendContactor;
	}

	public void setSendContactor(String sendContactor) {
		this.sendContactor = sendContactor;
	}

	public String getSendContact() {
		return sendContact;
	}

	public void setSendContact(String sendContact) {
		this.sendContact = sendContact;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getYwCode() {
		return ywCode;
	}

	public void setYwCode(String ywCode) {
		this.ywCode = ywCode;
	}

	public String getYwName() {
		return DispatchEnums.YwCode.getByKey(ywCode);
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return DispatchEnums.TypeCode.getByKey(typeCode);
	}

	public String getStatusName() {
		return DispatchEnums.Status.getByKey(status);
	}

	public String getCheckStatusName() {
		return Enums.CheckStatus.getByKey(checkStatus);
	}

	public String toLog() {
		return " - orderId:" + String.valueOf(orderId) + " - companyId:" + String.valueOf(companyId) + " - status:"
				+ String.valueOf(status) + " - receiveOrgId:" + String.valueOf(receiveOrgId) + " - receiveOrgName:"
				+ String.valueOf(receiveOrgName) + " - i_year:" + String.valueOf(i_year) + " - i_month:"
				+ String.valueOf(i_month) + " - i_season:" + String.valueOf(i_season) + " - commitTime:"
				+ String.valueOf(commitTime) + " - cashDate:" + String.valueOf(cashDate) + " - totalAmt:"
				+ String.valueOf(totalAmt) + " - payableAmt:" + String.valueOf(payableAmt) + " - payAmt:"
				+ String.valueOf(payAmt) + " - unpayAmt:" + String.valueOf(unpayAmt) + " - createtime:"
				+ String.valueOf(createtime) + " - updatetime:" + String.valueOf(updatetime) + " - totalNums:"
				+ String.valueOf(totalNums) + " - salesAmt:" + String.valueOf(salesAmt) + " - sendNums:"
				+ String.valueOf(sendNums) + " - receiveNums:" + String.valueOf(receiveNums) + " - dispatchNums:"
				+ String.valueOf(dispatchNums) + " - sendOrgId:" + String.valueOf(sendOrgId) + " - sendOrgName:"
				+ String.valueOf(sendOrgName) + " - applyManId:" + String.valueOf(applyManId) + " - applyManCode:"
				+ String.valueOf(applyManCode) + " - applyMan:" + String.valueOf(applyMan) + " - sendContactor:"
				+ String.valueOf(sendContactor) + " - sendContact:" + String.valueOf(sendContact) + " - checkStatus:"
				+ String.valueOf(checkStatus) + " - checkTime:" + String.valueOf(checkTime) + " - checkCode:"
				+ String.valueOf(checkCode) + " - checker:" + String.valueOf(checker) + " - ywCode:"
				+ String.valueOf(ywCode) + " - ywName:" + String.valueOf(ywName) + " - typeCode:"
				+ String.valueOf(typeCode) + " - typeName:" + String.valueOf(typeName) + " - statusName:"
				+ String.valueOf(statusName) + " - checkStatusName:" + String.valueOf(checkStatusName);
	}
}