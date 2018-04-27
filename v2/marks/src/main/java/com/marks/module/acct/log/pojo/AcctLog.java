package com.marks.module.acct.log.pojo;

import java.io.Serializable;

import com.marks.common.enums.AcctEnums;
import com.marks.common.enums.ChannelEnums;
import com.marks.common.util.date.DateUtil;

public class AcctLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 单号
	 *
	 */
	private String id;
	/**
	 * 用户系统编号 帐户基本信息
	 */
	private String userid;
	/**
	 * 用户编号
	 *
	 */
	private String userCode;
	/**
	 * 用户姓名
	 *
	 */
	private String userName;
	/**
	 * 业务编号 point:积分 amt：充值
	 */
	private String ywCode;
	/**
	 * 业务类型
	 *
	 */
	private String ywName;
	/**
	 * 交易编号
	 *
	 */
	private String tranCode;
	/**
	 * 交易类型
	 *
	 */
	private String tranName;
	/**
	 * 交易状态
	 *
	 */
	private int tranStatus;
	/**
	 * 交易金额
	 *
	 */
	private String tranAmt;
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
	 * 剩余金额
	 *
	 */
	private String balAmt;
	/**
	 * 剩余积分
	 *
	 */
	private int balPoint;
	/**
	 * 备注
	 *
	 */
	private String remarks;
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

	private String cashAmt;// 实充金额
	private String sendAmt;// 赠送金额

	private String channelId;// 渠道

	private String channel;// 渠道

	private String companyId;// 公司编号

	private String orgId;// 机构

	private String orgName;// 机构

	private String operatorCode;// 操作人编号

	private String operatorName;// 操作人姓名

	public AcctLog() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannel() {
		return ChannelEnums.Channel.getByKey(channelId);
	}

	public void setChannel(String channel) {
		this.channel = channel;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getYwCode() {
		return ywCode;
	}

	public void setYwCode(String ywCode) {
		this.ywCode = ywCode;
	}

	public String getYwName() {
		return AcctEnums.YwCode.getByKey(this.getYwCode());
	}

	public void setYwName(String ywName) {
		this.ywName = ywName;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public String getTranName() {
		return AcctEnums.TranCode.getByKey(this.getTranCode());
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	public int getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(int tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
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

	public String getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}

	public int getBalPoint() {
		return balPoint;
	}

	public void setBalPoint(int balPoint) {
		this.balPoint = balPoint;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String toLog() {
		return " - id:" + String.valueOf(id) + " - userid:" + String.valueOf(userid) + " - userCode:"
				+ String.valueOf(userCode) + " - userName:" + String.valueOf(userName) + " - ywCode:"
				+ String.valueOf(ywCode) + " - ywName:" + String.valueOf(ywName) + " - tranCode:"
				+ String.valueOf(tranCode) + " - tranName:" + String.valueOf(tranName) + " - tranStatus:"
				+ String.valueOf(tranStatus) + " - tranAmt:" + String.valueOf(tranAmt) + " - tranPoint:"
				+ String.valueOf(tranPoint) + " - tranTime:" + String.valueOf(tranTime) + " - tranDesc:"
				+ String.valueOf(tranDesc) + " - balAmt:" + String.valueOf(balAmt) + " - balPoint:"
				+ String.valueOf(balPoint) + " - remarks:" + String.valueOf(remarks) + " - createtime:"
				+ String.valueOf(createtime) + " - updatetime:" + String.valueOf(updatetime);
	}
}