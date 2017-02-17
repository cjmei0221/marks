package com.nfb.module.wxmodulemsg.entity;

public class ModuleMsg {
	private String accountid;
	private String touser;
	private String template_id;
	private String url;
	private String data;
	
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String templateId) {
		template_id = templateId;
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
	public String toLog(){
		StringBuffer sb=new StringBuffer();
		sb.append("module massage>>");
		sb.append("accountid:"+accountid+" | ");
		sb.append("touser:"+touser+" | ");
		sb.append("template_id:"+template_id+" | ");
		sb.append("tourl:"+url+" | ");
		sb.append("data:"+data+" | ");
		return sb.toString();
	}
}
