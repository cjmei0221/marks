package com.marks.smart.market.project.sales.pojo;

import java.io.Serializable;

import com.marks.common.enums.SalesEnums;
import com.marks.common.util.date.DateUtil;

public class SalesDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 *
	 */
	private String id;
	/**
	 * 方案编号
	 *
	 */
	private String projectCode;
	/**
	 * 方案名称
	 *
	 */
	private String projectName;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 创建时间
	 *
	 */
	private String createtime;
	/**
	 * 业务编号
	 *
	 */
	private int ywCode;
	/**
	 * 业务名称
	 *
	 */
	private String ywName;
	/**
	 * 类型编号
	 *
	 */
	private int typeCode;
	/**
	 * 类型名称
	 *
	 */
	private String typeName;
	/**
	 * 是否有奖品 0:无 1:有
	 */
	private int isAward;
	/**
	 * 奖品类型
	 *
	 */
	private int awardTypeCode;
	/**
	 * 奖品类型
	 *
	 */
	private String awardTypeName;

	/**
	 * 奖项编号
	 *
	 */
	private String itemCode;
	/**
	 * 奖项名称
	 *
	 */
	private String itemName;
	/**
	 * 奖项值
	 *
	 */
	private String itemValue;
	/**
	 * 备注
	 *
	 */
	private String remarks;
	/**
	 * 关联编号
	 *
	 */
	private String idNo;
	/**
	 * 关联名称
	 *
	 */
	private String idName;
	/**
	 * 用户编号
	 *
	 */
	private String userId;
	/**
	 * 用户编号
	 *
	 */
	private String userCode;
	/**
	 * 用户名称
	 *
	 */
	private String userName;
	/**
	 * 用户角色
	 *
	 */
	private String roleType;
	/**
	 * 用户角色
	 *
	 */
	private String roleName;
	/**
	 * 手机号码
	 *
	 */
	private String userTel;
	/**
	 * 机构编号
	 *
	 */
	private String orgId;
	/**
	 * 机构名称
	 *
	 */
	private String orgName;
	/**
	 * OPENID
	 *
	 */
	private String openid;
	/**
	 * 批次号
	 *
	 */
	private String batchId;
	/**
	 * 状态
	 *
	 */
	private int status;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
	/**
	 * 销售金额
	 *
	 */
	private String saleAmt;
	/**
	 * 成本金额
	 *
	 */
	private String costAmt;
	/**
	 * 收货电话
	 *
	 */
	private String receiveTel;
	/**
	 * 收货人
	 *
	 */
	private String receiveUser;
	/**
	 * 收货地址
	 *
	 */
	private String receiveAddr;

	private String awardVal;// 奖项值

	private String awardName;// 奖项名

	private String awardCode;// 奖项编号

	private int itemTypeCode;
	private String itemTypeName;

	/**
	 * 开始日期
	 *
	 */
	private String startDate;
	/**
	 * 结束日期
	 *
	 */
	private String endDate;

	private String checkOrgId;// 核销机构
	private String checkOrgName;// 核销门店
	private String checkTime;// 核销时间
	private String checkerCode;// 核销人编号
	private String checker;// 核销人

	public SalesDetail() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCheckOrgId() {
		return checkOrgId;
	}

	public void setCheckOrgId(String checkOrgId) {
		this.checkOrgId = checkOrgId;
	}

	public String getCheckOrgName() {
		return checkOrgName;
	}

	public void setCheckOrgName(String checkOrgName) {
		this.checkOrgName = checkOrgName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckerCode() {
		return checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getAwardVal() {
		return awardVal;
	}

	public void setAwardVal(String awardVal) {
		this.awardVal = awardVal;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardCode() {
		return awardCode;
	}

	public void setAwardCode(String awardCode) {
		this.awardCode = awardCode;
	}

	public int getItemTypeCode() {
		return itemTypeCode;
	}

	public void setItemTypeCode(int itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getYwCode() {
		return ywCode;
	}

	public void setYwCode(int ywCode) {
		this.ywCode = ywCode;
	}

	public String getYwName() {
		return SalesEnums.YwCode.getByKey(ywCode);
	}

	public void setYwName(String ywName) {
		this.ywName = ywName;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return SalesEnums.TypeCode.getByKey(typeCode);
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getIsAward() {
		return isAward;
	}

	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}

	public int getAwardTypeCode() {
		return awardTypeCode;
	}

	public void setAwardTypeCode(int awardTypeCode) {
		this.awardTypeCode = awardTypeCode;
	}

	public String getAwardTypeName() {
		return SalesEnums.AwardTypeCode.getByKey(awardTypeCode);
	}

	public void setAwardTypeName(String awardTypeName) {
		this.awardTypeName = awardTypeName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusName() {
		return SalesEnums.DetailStatus.getByKey(status);
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

	public String getSaleAmt() {
		return saleAmt;
	}

	public void setSaleAmt(String saleAmt) {
		this.saleAmt = saleAmt;
	}

	public String getCostAmt() {
		return costAmt;
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public String getReceiveTel() {
		return receiveTel;
	}

	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}

	public String getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	public String getReceiveAddr() {
		return receiveAddr;
	}

	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

}