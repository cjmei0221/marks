package com.marks.module.acct.ext.pojo;

public class PointLog {

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
	 * 交易积分
	 *
	 */
	private int tranPoint;
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

	public int getTranPoint() {
		return tranPoint;
	}

	public void setTranPoint(int tranPoint) {
		this.tranPoint = tranPoint;
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
