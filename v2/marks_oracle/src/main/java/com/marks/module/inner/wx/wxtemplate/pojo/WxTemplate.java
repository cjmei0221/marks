package com.marks.module.inner.wx.wxtemplate.pojo;

import java.io.Serializable;
import java.util.Date;

public class WxTemplate implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 业务类型
	 */
	private String ywType;

	/**
	 * 公众号ID
	 */
	private String accountid;
	/**
	 * 微信模板ID
	 */
	private String template_id;
	/**
	 * 微信模板标题
	 */
	private String template_name;
	/**
	 * 首行内容
	 */
	private String first_content;
	/**
	 * 尾行内容
	 */
	private String remark_content;
	/**
	 * 访问URL
	 */
	private String detailUrl;
	/**
	 * 启用标识
	 */
	private int status;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 更新时间
	 */
	private Date updatetime;
	/**
	 * 创建者
	 */
	private String creator;
	
	public String getId() {
		return accountid+"_"+ywType;
	}

	public String getYwType() {
		return ywType;
	}

	public void setYwType(String ywType) {
		this.ywType = ywType;
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

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}

	public String getFirst_content() {
		return first_content;
	}

	public void setFirst_content(String first_content) {
		this.first_content = first_content;
	}

	public String getRemark_content() {
		return remark_content;
	}

	public void setRemark_content(String remark_content) {
		this.remark_content = remark_content;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}