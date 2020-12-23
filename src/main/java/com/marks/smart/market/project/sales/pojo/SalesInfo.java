package com.marks.smart.market.project.sales.pojo;

import java.io.Serializable;

import com.marks.common.enums.Enums;
import com.marks.common.enums.SalesEnums;
import com.marks.common.util.date.DateUtil;

public class SalesInfo implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * 开始日期
	 *
	 */
	private String startDate;
	/**
	 * 结束日期
	 *
	 */
	private String endDate;
	/**
	 * 方案介绍
	 *
	 */
	private String intro;
	/**
	 * 每人每日限制数
	 *
	 */
	private int daylimit;
	/**
	 * 总限制数
	 *
	 */
	private int totallimit;
	/**
	 * 是否限制门店
	 *
	 */
	private int limitAreaFlag;
	/**
	 * 门店编号
	 *
	 */
	private String limitAreaCodes;
	/**
	 * 门店名称
	 *
	 */
	private String limitAreaNames;
	/**
	 * 是否限制商品
	 *
	 */
	private int limitGoodFlag;
	/**
	 * 商品编号
	 *
	 */
	private String limitGoodNos;
	/**
	 * 商品名称
	 *
	 */
	private String limitGoodNames;
	/**
	 * 方案值 如优惠券值
	 */
	private String projectVal;
	/**
	 * 使用条件
	 *
	 */
	private String useLimit;
	/**
	 * 使用场景
	 *
	 */
	private int sceneCode;
	/**
	 * 使用场景
	 *
	 */
	private String scene;
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
	 * 创建者
	 *
	 */
	private String creator;
	/**
	 * 更新者
	 *
	 */
	private String updater;
	/**
	 * 状态 1:启用 0:禁用
	 */
	private int status;
	/**
	 * 审核状态
	 *
	 */
	private int checkStatus;
	/**
	 * 审核时间
	 *
	 */
	private String checkTime;
	/**
	 * 审核者
	 *
	 */
	private String checker;
	/**
	 * 备注
	 *
	 */
	private String remarks;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;

	private String pushLimit;// 推送条件

	private int notJoinFlag;// 是否有排除对象

	private String notJoinGoodTypes;// 排除类目
	private String notJoinBrands;
	private String notJoinGoods;

	public SalesInfo() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public int getNotJoinFlag() {
		return notJoinFlag;
	}

	public void setNotJoinFlag(int notJoinFlag) {
		this.notJoinFlag = notJoinFlag;
	}

	public String getNotJoinGoodTypes() {
		return notJoinGoodTypes;
	}

	public void setNotJoinGoodTypes(String notJoinGoodTypes) {
		this.notJoinGoodTypes = notJoinGoodTypes;
	}

	public String getNotJoinBrands() {
		return notJoinBrands;
	}

	public void setNotJoinBrands(String notJoinBrands) {
		this.notJoinBrands = notJoinBrands;
	}

	public String getNotJoinGoods() {
		return notJoinGoods;
	}

	public void setNotJoinGoods(String notJoinGoods) {
		this.notJoinGoods = notJoinGoods;
	}

	public String getPushLimit() {
		return pushLimit;
	}

	public void setPushLimit(String pushLimit) {
		this.pushLimit = pushLimit;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getDaylimit() {
		return daylimit;
	}

	public void setDaylimit(int daylimit) {
		this.daylimit = daylimit;
	}

	public int getTotallimit() {
		return totallimit;
	}

	public void setTotallimit(int totallimit) {
		this.totallimit = totallimit;
	}

	public int getLimitAreaFlag() {
		return limitAreaFlag;
	}

	public void setLimitAreaFlag(int limitAreaFlag) {
		this.limitAreaFlag = limitAreaFlag;
	}

	public String getLimitAreaCodes() {
		return limitAreaCodes;
	}

	public void setLimitAreaCodes(String limitAreaCodes) {
		this.limitAreaCodes = limitAreaCodes;
	}

	public String getLimitAreaNames() {
		return limitAreaNames;
	}

	public void setLimitAreaNames(String limitAreaNames) {
		this.limitAreaNames = limitAreaNames;
	}

	public int getLimitGoodFlag() {
		return limitGoodFlag;
	}

	public void setLimitGoodFlag(int limitGoodFlag) {
		this.limitGoodFlag = limitGoodFlag;
	}

	public String getLimitGoodNos() {
		return limitGoodNos;
	}

	public void setLimitGoodNos(String limitGoodNos) {
		this.limitGoodNos = limitGoodNos;
	}

	public String getLimitGoodNames() {
		return limitGoodNames;
	}

	public void setLimitGoodNames(String limitGoodNames) {
		this.limitGoodNames = limitGoodNames;
	}

	public String getProjectVal() {
		return projectVal;
	}

	public void setProjectVal(String projectVal) {
		this.projectVal = projectVal;
	}

	public String getUseLimit() {
		return useLimit;
	}

	public void setUseLimit(String useLimit) {
		this.useLimit = useLimit;
	}

	public int getSceneCode() {
		return sceneCode;
	}

	public void setSceneCode(int sceneCode) {
		this.sceneCode = sceneCode;
	}

	public String getScene() {
		return SalesEnums.SceneCode.getByKey(sceneCode);
	}

	public void setScene(String scene) {
		this.scene = scene;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusName() {
		return Enums.Status.getByKey(status);
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public String getCheckStatusName() {
		return Enums.CheckStatus.getByKey(checkStatus);
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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

}