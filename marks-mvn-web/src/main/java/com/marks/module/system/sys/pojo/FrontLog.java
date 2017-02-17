package com.marks.module.system.sys.pojo;

import java.util.Date;

import com.marks.common.util.IDUtil;

public class FrontLog {

	private String id;//
	private String moduleId;//模块名称
	private String moduleName;//模块名称
	private String operId;//操作名称
	private String operName;//操作名称
	private String type;//0:默认  1:作为模块日志（用于统计菜单统计量）  2：操作日志
	private Date createtime;//
	private String note;//备注
	private String ip;//请求IP地址
	private String req_url;//请求URL
	public FrontLog(){
		id=IDUtil.getTimeID();
		createtime=new Date();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getReq_url() {
		return req_url;
	}
	public void setReq_url(String req_url) {
		this.req_url = req_url;
	}
	
}
