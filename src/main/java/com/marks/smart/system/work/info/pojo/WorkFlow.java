package com.marks.smart.system.work.info.pojo;

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
	 * 备注
	 *
	 */
	private String remarks;
	/**
	 * 类型编号
	 *
	 */
	private String typeCode;

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

	private String applyOrgId;
	private String applyOrgName;
	private String applyRoleId;
	private String applyRoleName;
	
	private String checkerId;//审核人

	public WorkFlow() {

	}
	
	public String getCheckerId() {
		return checkerId;
	}



	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}



	public String getApplyOrgId() {
		return applyOrgId;
	}

	public void setApplyOrgId(String applyOrgId) {
		this.applyOrgId = applyOrgId;
	}

	public String getApplyOrgName() {
		return applyOrgName;
	}

	public void setApplyOrgName(String applyOrgName) {
		this.applyOrgName = applyOrgName;
	}

	public String getApplyRoleId() {
		return applyRoleId;
	}

	public void setApplyRoleId(String applyRoleId) {
		this.applyRoleId = applyRoleId;
	}

	public String getApplyRoleName() {
		return applyRoleName;
	}

	public void setApplyRoleName(String applyRoleName) {
		this.applyRoleName = applyRoleName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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