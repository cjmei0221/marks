package com.marks.module.acct.ext.pojo;

public class TranLog {
	/**
	 * 用户系统编号 帐户基本信息
	 */
	private String userid;
	/**
	 * 交易编号
	 *
	 */
	private String tranCode;
	/**
	 * 交易金额
	 *
	 */
	private String tranAmt;

	/**
	 * 交易时间
	 *
	 */
	private String tranTime;
	/**
	 * 交易描述
	 *
	 */
	private String tranDesc;

	/**
	 * 备注
	 *
	 */
	private String remarks;

	private String cashAmt;// 实充金额

	private String sendAmt;// 赠送金额

	private String channelId;// 渠道

	private String orgId;// 机构

	private String orgName;// 机构

	private String operatorCode;// 操作人编号

	private String operatorName;// 操作人姓名

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(String cashAmt) {
		this.cashAmt = cashAmt;
	}

	public String getSendAmt() {
		return sendAmt;
	}

	public void setSendAmt(String sendAmt) {
		this.sendAmt = sendAmt;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getTranDesc() {
		return tranDesc;
	}

	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
