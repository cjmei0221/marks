package com.marks.module.work.info.pojo;

import java.io.Serializable;

public class WorkFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 业务编号
	 *
	 */
	private String idNo;
	/**
	 * 业务名称
	 *
	 */
	private String idName;
	/**
	 * 申请人编号
	 *
	 */
	private String applyManId;
	/**
	 * 申请人
	 *
	 */
	private String applyMan;
	/**
	 * 类型编号
	 *
	 */
	private String typeCode;

	public WorkFlow() {

	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getApplyManId() {
		return applyManId;
	}

	public void setApplyManId(String applyManId) {
		this.applyManId = applyManId;
	}

	public String getApplyMan() {
		return applyMan;
	}

	public void setApplyMan(String applyMan) {
		this.applyMan = applyMan;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
}