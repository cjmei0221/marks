package com.marks.module.work.info.pojo;

import java.io.Serializable;

import com.marks.common.enums.Enums;
import com.marks.common.util.date.DateUtil;

public class WorkInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 工作编号
	 *
	 */
	private String workId;
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
	/**
	 * 类型名称
	 *
	 */
	private String typeName;

	private int nextStep;// 当前步骤
	/**
	 * 当前步骤编号
	 *
	 */
	private String nextStepId;
	/**
	 * 步骤名称
	 *
	 */
	private String nextStepName;
	/**
	 * 创建时间
	 *
	 */
	private String createtime;
	/**
	 * 下一步编号
	 *
	 */
	private String nextUserid;
	/**
	 * 下一步名称
	 *
	 */
	private String nextUsername;
	/**
	 * 操作状态
	 *
	 */
	private int operatorStatus;
	private String operatorStatusName;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
	/**
	 * 当前操作人编号
	 *
	 */
	private String currUserid;
	/**
	 * 当前操作人
	 *
	 */
	private String currUsername;
	/**
	 * 页面路径
	 *
	 */
	private String pageUrl;
	/**
	 * 当前角色编号
	 *
	 */
	private String currRoleid;
	/**
	 * 下一步角色编号
	 *
	 */
	private String nextRoleid;
	/**
	 * 当前角色
	 *
	 */
	private String currRolename;
	/**
	 * 下一步角色
	 *
	 */
	private String nextRolename;
	/**
	 * 申请人所属机构编号
	 *
	 */
	private String applyOrgId;
	/**
	 * 申请人所属机构
	 *
	 */
	private String applyOrgName;

	private int nextDealType;// 处理方式 0:按指定角色 1:按同级职位 2:按上级职位

	private int dealModel;// 处理模式同isAuto

	public WorkInfo() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public int getDealModel() {
		return dealModel;
	}

	public void setDealModel(int dealModel) {
		this.dealModel = dealModel;
	}

	public int getNextDealType() {
		return nextDealType;
	}

	public void setNextDealType(int nextDealType) {
		this.nextDealType = nextDealType;
	}


	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getOperatorStatusName() {
		return Enums.CheckStatus.getByKey(operatorStatus);
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getNextUserid() {
		return nextUserid;
	}

	public void setNextUserid(String nextUserid) {
		this.nextUserid = nextUserid;
	}

	public String getNextUsername() {
		return nextUsername;
	}

	public void setNextUsername(String nextUsername) {
		this.nextUsername = nextUsername;
	}

	public int getOperatorStatus() {
		return operatorStatus;
	}

	public void setOperatorStatus(int operatorStatus) {
		this.operatorStatus = operatorStatus;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCurrUserid() {
		return currUserid;
	}

	public void setCurrUserid(String currUserid) {
		this.currUserid = currUserid;
	}

	public String getCurrUsername() {
		return currUsername;
	}

	public void setCurrUsername(String currUsername) {
		this.currUsername = currUsername;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getCurrRoleid() {
		return currRoleid;
	}

	public void setCurrRoleid(String currRoleid) {
		this.currRoleid = currRoleid;
	}

	public String getNextRoleid() {
		return nextRoleid;
	}

	public void setNextRoleid(String nextRoleid) {
		this.nextRoleid = nextRoleid;
	}

	public String getCurrRolename() {
		return currRolename;
	}

	public void setCurrRolename(String currRolename) {
		this.currRolename = currRolename;
	}

	public String getNextRolename() {
		return nextRolename;
	}

	public void setNextRolename(String nextRolename) {
		this.nextRolename = nextRolename;
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

	public int getNextStep() {
		return nextStep;
	}

	public void setNextStep(int nextStep) {
		this.nextStep = nextStep;
	}

	public String getNextStepId() {
		return nextStepId;
	}

	public void setNextStepId(String nextStepId) {
		this.nextStepId = nextStepId;
	}

	public String getNextStepName() {
		return nextStepName;
	}

	public void setNextStepName(String nextStepName) {
		this.nextStepName = nextStepName;
	}

	public String toLog() {
		return " - workId:" + String.valueOf(workId) + " - companyId:" + String.valueOf(companyId) + " - idNo:"
				+ String.valueOf(idNo) + " - applyManId:" + String.valueOf(applyManId) + " - applyMan:"
				+ String.valueOf(applyMan) + " - typeId:" + String.valueOf(typeCode) + " - typeName:"
				+ String.valueOf(typeName) + " - stepId:" + String.valueOf(nextStepId) + " - stepName:"
				+ String.valueOf(nextStepName) + " - createtime:" + String.valueOf(createtime) + " - nextUserid:"
				+ String.valueOf(nextUserid) + " - nextUsername:" + String.valueOf(nextUsername) + " - operatorStatus:"
				+ String.valueOf(operatorStatus) + " - updatetime:" + String.valueOf(updatetime) + " - currUserid:"
				+ String.valueOf(currUserid) + " - currUsername:" + String.valueOf(currUsername) + " - pageUrl:"
				+ String.valueOf(pageUrl) + " - currRoleid:" + String.valueOf(currRoleid) + " - nextRoleid:"
				+ String.valueOf(nextRoleid) + " - currRolename:" + String.valueOf(currRolename) + " - nextRolename:"
				+ String.valueOf(nextRolename) + " - applyOrgId:" + String.valueOf(applyOrgId) + " - applyOrgName:"
				+ String.valueOf(applyOrgName);
	}
}