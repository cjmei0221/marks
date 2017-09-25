package com.marks.module.pay.unionpay.pojo;

import java.util.Date;

/**
 * 银联后台通知报文实体
 * @author zqsheng
 *
 */
public class UnionPayLog {
	
	private String orderId;//订单号 商户根据自己规则定义生成，每订单日期内不重复
	private String txnTime;//订单发送时间 格式： YYYYMMDDhhmmss 商户发送交易时间，根据自己系统或平台生成
	private String txnType;//交易类型 79- 开通交易
	private String txnSubType;//交易子类型 00——默认开通
	private String bizType;//产品类型 000000-默认取值;000201-B2C网关支付;000401-代付
	private String merId;//商户号码
	private String txnAmt;//交易金额  单位(分)
	private String queryId;//交易查询流水号，供后续查询用
	private String respCode;//响应码
	private String respMsg;//响应信息
	private String settleAmt;//清算金币
	private String settleDate;//清算日期
	private String traceNo;//系统跟踪号
	private String traceTime;//交易传输时间
	private String accNo;//卡号账号
	private String customerNm;//卡号姓名
	private String status;//排查状态   0： 待排查    1：已排查；对于没有返回码的报文需要排查。
	private String channelType;//渠道类型 07-互联网;08-手机
	private String reqReserved;//请求方保留域，交易应答时会原样返回
	private Date createdate;
	
	public UnionPayLog() {
		this.createdate = new Date();
	}
	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getTxnSubType() {
		return txnSubType;
	}
	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getTraceTime() {
		return traceTime;
	}
	public void setTraceTime(String traceTime) {
		this.traceTime = traceTime;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}

	public String getSettleAmt() {
		return settleAmt;
	}

	public void setSettleAmt(String settleAmt) {
		this.settleAmt = settleAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerNm() {
		return customerNm;
	}

	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getReqReserved() {
		return reqReserved;
	}

	public void setReqReserved(String reqReserved) {
		this.reqReserved = reqReserved;
	}
}
