package com.marks.module.work.info.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class WorkStep implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 步骤编号
	 *
	 */
	private String stepId;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 工作流编号
	 *
	 */
	private String wrokId;
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
	 * 序号
	 *
	 */
	private int step;
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
	 * 角色名称
	 *
	 */
	private String roleName;
	/**
	 * 操作人编号
	 *
	 */
	private String operatorId;
	/**
	 * 操作人姓名
	 *
	 */
	private String operatorName;
	/**
	 * 结束时间
	 *
	 */
	private String endTime;
	/**
	 * 操作状态
	 *
	 */
	private int operateStatus;
	/**
	 * 操作人机构编号
	 *
	 */
	private String operatorOrgId;
	/**
	 * 机构名称
	 *
	 */
	private String operatorOrgName;
	/**
	 * 备注
	 *
	 */
	private String remarks;

	private String parentOrgId;

	public WorkStep() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getWrokId() {
		return wrokId;
	}

	public void setWrokId(String wrokId) {
		this.wrokId = wrokId;
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

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getOperateStatus() {
		return operateStatus;
	}

	public void setOperateStatus(int operateStatus) {
		this.operateStatus = operateStatus;
	}

	public String getOperatorOrgId() {
		return operatorOrgId;
	}

	public void setOperatorOrgId(String operatorOrgId) {
		this.operatorOrgId = operatorOrgId;
	}

	public String getOperatorOrgName() {
		return operatorOrgName;
	}

	public void setOperatorOrgName(String operatorOrgName) {
		this.operatorOrgName = operatorOrgName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String toLog() {
		return " - stepId:" + String.valueOf(stepId) + " - companyId:" + String.valueOf(companyId) + " - wrokId:"
				+ String.valueOf(wrokId) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - step:" + String.valueOf(step) + " - stepName:"
				+ String.valueOf(stepName) + " - roleId:" + String.valueOf(roleId) + " - roleName:"
				+ String.valueOf(roleName) + " - operatorId:" + String.valueOf(operatorId) + " - operatorName:"
				+ String.valueOf(operatorName) + " - endTime:" + String.valueOf(endTime) + " - operateStatus:"
				+ String.valueOf(operateStatus) + " - operatorOrgId:" + String.valueOf(operatorOrgId)
				+ " - operatorOrgName:" + String.valueOf(operatorOrgName) + " - remarks:" + String.valueOf(remarks);
	}
}