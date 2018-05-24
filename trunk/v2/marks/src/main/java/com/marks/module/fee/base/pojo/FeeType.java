package com.marks.module.fee.base.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class FeeType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 科目
	 *
	 */
	private String typeId;
	/**
	 * 科目编号
	 *
	 */
	private String typeCode;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 科目名称
	 *
	 */
	private String typeName;
	/**
	 * 启禁用 0:禁用 1:启用
	 */
	private int status;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
	/**
	 * 更新者
	 *
	 */
	private String updater;
	/**
	 * 删除标识 0:不可删除 1:可删除
	 */
	private int delFlag;
	private int inOrOut;

	public FeeType() {
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public int getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String toLog() {
		return " - typeId:" + String.valueOf(typeId) + " - typeCode:" + String.valueOf(typeCode) + " - companyId:"
				+ String.valueOf(companyId) + " - typeName:" + String.valueOf(typeName) + " - status:"
				+ String.valueOf(status) + " - updatetime:" + String.valueOf(updatetime) + " - updater:"
				+ String.valueOf(updater) + " - delFlag:" + String.valueOf(delFlag);
	}
}