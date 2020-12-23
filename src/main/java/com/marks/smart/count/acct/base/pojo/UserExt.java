package com.marks.smart.count.acct.base.pojo;

import java.io.Serializable;

import com.marks.common.util.date.DateUtil;
import com.marks.smart.system.user.sysuser.pojo.SysUser;

public class UserExt extends SysUser implements Serializable {

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
	 * 等级编号
	 *
	 */
	private String lvlId;

	private int lvl;
	/**
	 * 等级名称
	 *
	 */
	private String lvlName;
	/**
	 * 首次操作时间
	 *
	 */
	private String first_operate_time;
	/**
	 * 最后操作时间
	 *
	 */
	private String last_operate_time;
	/**
	 * 首次消费时间
	 *
	 */
	private String first_consume_time;
	/**
	 * 最后消费时间
	 *
	 */
	private String last_consume_time;
	/**
	 * 累计积分
	 *
	 */
	private int grand_total_point;
	/**
	 * 累计消费金额
	 *
	 */
	private String grand_total_consume_amt;
	/**
	 * 累计消费次数
	 *
	 */
	private int grand_total_consume_nums;
	/**
	 * 可用积分
	 *
	 */
	private int balPoint = 0;

	/**
	 * 更新时间
	 *
	 */
	private String updatetime;
	/**
	 * 余额
	 *
	 */
	private String balAmt = "0.00";

	public UserExt() {
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
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

	public String getLvlId() {
		return lvlId;
	}

	public void setLvlId(String lvlId) {
		this.lvlId = lvlId;
	}

	public String getLvlName() {
		return lvlName;
	}

	public void setLvlName(String lvlName) {
		this.lvlName = lvlName;
	}

	public String getFirst_operate_time() {
		return first_operate_time;
	}

	public void setFirst_operate_time(String first_operate_time) {
		this.first_operate_time = first_operate_time;
	}

	public String getLast_operate_time() {
		return last_operate_time;
	}

	public void setLast_operate_time(String last_operate_time) {
		this.last_operate_time = last_operate_time;
	}

	public String getFirst_consume_time() {
		return first_consume_time;
	}

	public void setFirst_consume_time(String first_consume_time) {
		this.first_consume_time = first_consume_time;
	}

	public String getLast_consume_time() {
		return last_consume_time;
	}

	public void setLast_consume_time(String last_consume_time) {
		this.last_consume_time = last_consume_time;
	}

	public int getGrand_total_point() {
		return grand_total_point;
	}

	public void setGrand_total_point(int grand_total_point) {
		this.grand_total_point = grand_total_point;
	}

	public String getGrand_total_consume_amt() {
		return grand_total_consume_amt;
	}

	public void setGrand_total_consume_amt(String grand_total_consume_amt) {
		this.grand_total_consume_amt = grand_total_consume_amt;
	}

	public int getGrand_total_consume_nums() {
		return grand_total_consume_nums;
	}

	public void setGrand_total_consume_nums(int grand_total_consume_nums) {
		this.grand_total_consume_nums = grand_total_consume_nums;
	}

	public int getBalPoint() {
		return balPoint;
	}

	public void setBalPoint(int balPoint) {
		this.balPoint = balPoint;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}

	public String toLog() {
		return " - userid:" + String.valueOf(userid) + " - userCode:" + String.valueOf(userCode) + " - userName:"
				+ String.valueOf(userName) + " - companyId:" + String.valueOf(companyId) + " - lvlId:"
				+ String.valueOf(lvlId) + " - lvlName:" + String.valueOf(lvlName) + " - first_operate_time:"
				+ String.valueOf(first_operate_time) + " - last_operate_time:" + String.valueOf(last_operate_time)
				+ " - first_consume_time:" + String.valueOf(first_consume_time) + " - last_consume_time:"
				+ String.valueOf(last_consume_time) + " - grand_total_point:" + String.valueOf(grand_total_point)
				+ " - grand_total_consume_amt:" + String.valueOf(grand_total_consume_amt)
				+ " - grand_total_consume_nums:" + String.valueOf(grand_total_consume_nums) + " - balPoint:"
				+ String.valueOf(balPoint) + " - updatetime:" + String.valueOf(updatetime) + " - balAmt:"
				+ String.valueOf(balAmt);
	}
}