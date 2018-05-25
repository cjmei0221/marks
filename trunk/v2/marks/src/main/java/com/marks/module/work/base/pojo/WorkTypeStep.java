package com.marks.module.work.base.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class WorkTypeStep implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 步骤编号
	 *
	 */
	private String stepId;
	/**
	 * 步骤序号
	 *
	 */
	private int step;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 步骤名称
	 *
	 */
	private String stepName;
	/**
	 * 角色编号
	 *
	 */
	private String roleId;
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
	/**
	 * 更新者
	 *
	 */
	private String updater;
	/**
	 * 类别编号
	 *
	 */
	private String typeId;
	/**
	 * 是否为审核通过 是否为审核通过 0:不是。1:是
	 */
	private int isCheckOk;
	/**
	 * 角色名称
	 *
	 */
	private String roleName;

	private String dealType;// 处理方式 0:按指定角色 1:按同级职位 2:按上级职位

	public WorkTypeStep() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getIsCheckOk() {
		return isCheckOk;
	}

	public void setIsCheckOk(int isCheckOk) {
		this.isCheckOk = isCheckOk;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String toLog() {
		return " - stepId:" + String.valueOf(stepId) + " - step:" + String.valueOf(step) + " - companyId:"
				+ String.valueOf(companyId) + " - stepName:" + String.valueOf(stepName) + " - roleId:"
				+ String.valueOf(roleId) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - updater:" + String.valueOf(updater) + " - typeId:"
				+ String.valueOf(typeId) + " - isCheckOk:" + String.valueOf(isCheckOk) + " - roleName:"
				+ String.valueOf(roleName);
	}
}