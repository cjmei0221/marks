package com.marks.smart.count.acct.info.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;

public class AcctPoint implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统编号
	 *
	 */
	private String userid;
	/**
	 * 用户编号
	 *
	 */
	private String userCode;
	/**
	 * 用户姓名
	 *
	 */
	private String userName;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
	/**
	 * 累计积分
	 *
	 */
	private int grand_total_point;
	/**
	 * 可用积分
	 *
	 */
	private int balPoint;
	/**
	 * 首次积分时间
	 *
	 */
	private String first_point_time;
	/**
	 * 最后积分时间
	 *
	 */
	private String last_point_time;
	/**
	 * 失效积分
	 *
	 */
	private int lossPoint;
	/**
	 * 即将失效积分
	 *
	 */
	private int soonPoint;
	/**
	 * 更新时间
	 *
	 */
	private String updatetime;

	public AcctPoint() {
		this.updatetime = DateUtil.getCurrDateStr();

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getGrand_total_point() {
		return grand_total_point;
	}

	public void setGrand_total_point(int grand_total_point) {
		this.grand_total_point = grand_total_point;
	}

	public int getBalPoint() {
		return balPoint;
	}

	public void setBalPoint(int balPoint) {
		this.balPoint = balPoint;
	}

	public String getFirst_point_time() {
		return first_point_time;
	}

	public void setFirst_point_time(String first_point_time) {
		this.first_point_time = first_point_time;
	}

	public String getLast_point_time() {
		return last_point_time;
	}

	public void setLast_point_time(String last_point_time) {
		this.last_point_time = last_point_time;
	}

	public int getLossPoint() {
		return lossPoint;
	}

	public void setLossPoint(int lossPoint) {
		this.lossPoint = lossPoint;
	}

	public int getSoonPoint() {
		return soonPoint;
	}

	public void setSoonPoint(int soonPoint) {
		this.soonPoint = soonPoint;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String toLog() {
		return " - userid:" + String.valueOf(userid) + " - userCode:" + String.valueOf(userCode) + " - userName:"
				+ String.valueOf(userName) + " - companyId:" + String.valueOf(companyId) + " - grand_total_point:"
				+ String.valueOf(grand_total_point) + " - balPoint:" + String.valueOf(balPoint) + " - first_point_time:"
				+ String.valueOf(first_point_time) + " - last_point_time:" + String.valueOf(last_point_time)
				+ " - lossPoint:" + String.valueOf(lossPoint) + " - soonPoint:" + String.valueOf(soonPoint)
				+ " - updatetime:" + String.valueOf(updatetime);
	}
}