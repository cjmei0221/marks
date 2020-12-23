package com.marks.smart.market.project.sales.pojo;

public class SalesForm {

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

	private String batchId;// 批次号

	/**
	 * 是否有奖品 0:无 1:有
	 */
	private int isAward;
	/**
	 * 奖项类型
	 *
	 */
	private int awardTypeCode;
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
	 * 奖品类型
	 *
	 */
	private int typeCode;

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

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
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

}
