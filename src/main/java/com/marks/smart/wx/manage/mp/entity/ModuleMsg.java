package com.marks.smart.wx.manage.mp.entity;

import java.io.Serializable;

public class ModuleMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String id;
	/**
	 * 公众号ID
	 */
	private String accountid;
	/**
	 * 模板ID
	 */
	private String template_id;
	/**
	 * 接受者
	 */
	private String touser;

	private String nickName;
	/**
	 * 访问URL
	 */
	private String url;
	/**
	 * 内容
	 */
	private String data;
	/**
	 * 需要发送标识
	 */
	private int needFlag;
	/**
	 * 发送标识
	 */
	private int sendFlag;
	/**
	 * 发送次数
	 */
	private int sendTimes;
	/**
	 * 创建时间
	 */
	private String createtime;
	/**
	 * 发送时间
	 */
	private String sendtime;
	/**
	 * 消息ID
	 */
	private String msgId;
	/**
	 * 推送返回码
	 */
	private String push_code;
	/**
	 * 推送返回信息
	 */
	private String push_msg;
	/**
	 * 推送结果码
	 */
	private String resultCode;
	/**
	 * 推送结果消息
	 */
	private String resultMsg;

	private String resultTime;
	/**
	 * 备注
	 */
	private String note;

	private long create_stamp;
	private String companyId;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public long getCreate_stamp() {
		return create_stamp;
	}

	public void setCreate_stamp(long create_stamp) {
		this.create_stamp = create_stamp;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNeedFlag() {
		return needFlag;
	}

	public void setNeedFlag(int needFlag) {
		this.needFlag = needFlag;
	}

	public int getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(int sendFlag) {
		this.sendFlag = sendFlag;
	}

	public int getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(int sendTimes) {
		this.sendTimes = sendTimes;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getPush_code() {
		return push_code;
	}

	public void setPush_code(String push_code) {
		this.push_code = push_code;
	}

	public String getPush_msg() {
		return push_msg;
	}

	public void setPush_msg(String push_msg) {
		this.push_msg = push_msg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}