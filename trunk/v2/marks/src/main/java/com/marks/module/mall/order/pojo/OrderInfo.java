package com.marks.module.mall.order.pojo;

import java.io.Serializable;

import com.marks.common.enums.ChannelEnums;
import com.marks.common.enums.OrderEnums;
import com.marks.common.util.date.DateUtil;

public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单编号
	 *
	 */
	private String orderId;
	/**
	 * 订单状态
	 *
	 */
	private int orderStatus;
	/**
	 * 公司编号
	 *
	 */
	private String companyId;
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
	 * 区域编号
	 *
	 */
	private String areaId;
	/**
	 * 区域名称
	 *
	 */
	private String areaName;
	/**
	 * 年份
	 *
	 */
	private int i_year;
	/**
	 * 月份
	 *
	 */
	private int i_month;
	/**
	 * 季度
	 *
	 */
	private int i_season;
	/**
	 * 下单时间
	 *
	 */
	private String commitTime;
	/**
	 * 收银日期
	 *
	 */
	private String cashDate;
	/**
	 * 小计总额
	 *
	 */
	private String payableAmt;
	/**
	 * 应付金额
	 *
	 */
	private String payingAmt;
	/**
	 * 实付金额
	 *
	 */
	private String payAmt;
	/**
	 * 收款金额
	 */
	private String recevieAmt;
	/**
	 * 促销总额
	 *
	 */
	private String salesAmt;
	/**
	 * 折扣总额
	 *
	 */
	private String discountAmt;
	/**
	 * 满减总额
	 *
	 */
	private String fullCutAmt;
	/**
	 * 优惠券金额
	 *
	 */
	private String couponAmt;
	/**
	 * 抹零金额
	 *
	 */
	private String malingAmt;
	/**
	 * 议价总额
	 *
	 */
	private String simpleDiscountAmt;
	/**
	 * 备注
	 *
	 */
	private String remarks;
	/**
	 * 支付方式编号
	 *
	 */
	private String payTypeCode;
	/**
	 * 支付方式名称
	 *
	 */
	private String payTypeName;
	/**
	 * 现金金额
	 *
	 */
	private String cashAmt;
	/**
	 * 微信金额
	 *
	 */
	private String wxAmt;
	/**
	 * 支付宝金额
	 *
	 */
	private String alipayAmt;

	/**
	 * 储值卡支付金额
	 */
	private String storedAmt;
	/**
	 * 其他金额 包含 刷卡。银联，等其他支付方式
	 *
	 */
	private String otherAmt;
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
	 * 支付状态
	 *
	 */
	private int payStatus;
	/**
	 * 业务编号
	 *
	 */
	private String cashType;
	/**
	 * 业务名称
	 *
	 */
	private String cashTypeName;
	/**
	 * 积分抵扣金额
	 *
	 */
	private String pointAmt;
	/**
	 * 积分
	 *
	 */
	private int point;
	/**
	 * 收银员系统编号
	 *
	 */
	private String cashManId;

	private String cashManCode;// 收银员编号
	/**
	 * 收银员名称
	 *
	 */
	private String cashMan;
	/**
	 * 导购员编号
	 *
	 */
	private String guiderId;

	private String guiderCode;
	/**
	 * 导购员名称
	 *
	 */
	private String guiderName;
	/**
	 * 会员编号
	 *
	 */
	private String vipId;

	private String vipCode;//
	/**
	 * 会员名称
	 *
	 */
	private String vipName;
	/**
	 * 会员手机号
	 *
	 */
	private String vipMobile;
	/**
	 * 收货手机号
	 *
	 */
	private String receiveTel;
	/**
	 * 收货人
	 *
	 */
	private String receiver;
	/**
	 * 收货地址
	 *
	 */
	private String receiveAddr;
	/**
	 * 订单状态名称
	 *
	 */
	private String orderStatusName;
	/**
	 * 进货金额
	 *
	 */
	private String costAmt;
	/**
	 * 数量
	 *
	 */
	private int nums;


	private String salePriceAmt;// 售价金额

	private String ywType;// 订单类型
	private String ywName;// 订单类型

	private String nowPriceAmt;// 现价金额

	private int usePoint;// 使用积分

	private String channelId;// 渠道

	private String channel;// 渠道

	public String getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}

	public String getSalePriceAmt() {
		return salePriceAmt;
	}

	public void setSalePriceAmt(String salePriceAmt) {
		this.salePriceAmt = salePriceAmt;
	}

	public OrderInfo() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getPayingAmt() {
		return payingAmt;
	}

	public void setPayingAmt(String payingAmt) {
		this.payingAmt = payingAmt;
	}

	public String getRecevieAmt() {
		return recevieAmt;
	}

	public void setRecevieAmt(String recevieAmt) {
		this.recevieAmt = recevieAmt;
	}

	public String getStoredAmt() {
		return storedAmt;
	}

	public void setStoredAmt(String storedAmt) {
		this.storedAmt = storedAmt;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannel() {
		return ChannelEnums.Channel.getByKey(channelId);
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public String getCashManCode() {
		return cashManCode;
	}

	public void setCashManCode(String cashManCode) {
		this.cashManCode = cashManCode;
	}

	public String getGuiderCode() {
		return guiderCode;
	}

	public void setGuiderCode(String guiderCode) {
		this.guiderCode = guiderCode;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getNowPriceAmt() {
		return nowPriceAmt;
	}

	public void setNowPriceAmt(String nowPriceAmt) {
		this.nowPriceAmt = nowPriceAmt;
	}

	public String getYwType() {
		return ywType;
	}

	public void setYwType(String ywType) {
		this.ywType = ywType;
	}

	public String getYwName() {
		return OrderEnums.YwType.getByKey(this.getYwType());
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getI_year() {
		return i_year;
	}

	public void setI_year(int i_year) {
		this.i_year = i_year;
	}

	public int getI_month() {
		return i_month;
	}

	public void setI_month(int i_month) {
		this.i_month = i_month;
	}

	public int getI_season() {
		return i_season;
	}

	public void setI_season(int i_season) {
		this.i_season = i_season;
	}

	public String getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	public String getCashDate() {
		return cashDate;
	}

	public void setCashDate(String cashDate) {
		this.cashDate = cashDate;
	}

	public String getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(String payableAmt) {
		this.payableAmt = payableAmt;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}


	public String getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(String discountAmt) {
		this.discountAmt = discountAmt;
	}

	public String getFullCutAmt() {
		return fullCutAmt;
	}

	public void setFullCutAmt(String fullCutAmt) {
		this.fullCutAmt = fullCutAmt;
	}

	public String getCouponAmt() {
		return couponAmt;
	}

	public void setCouponAmt(String couponAmt) {
		this.couponAmt = couponAmt;
	}

	public String getMalingAmt() {
		return malingAmt;
	}

	public void setMalingAmt(String malingAmt) {
		this.malingAmt = malingAmt;
	}

	public String getSimpleDiscountAmt() {
		return simpleDiscountAmt;
	}

	public void setSimpleDiscountAmt(String simpleDiscountAmt) {
		this.simpleDiscountAmt = simpleDiscountAmt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(String cashAmt) {
		this.cashAmt = cashAmt;
	}

	public String getWxAmt() {
		return wxAmt;
	}

	public void setWxAmt(String wxAmt) {
		this.wxAmt = wxAmt;
	}

	public String getAlipayAmt() {
		return alipayAmt;
	}

	public void setAlipayAmt(String alipayAmt) {
		this.alipayAmt = alipayAmt;
	}

	public String getOtherAmt() {
		return otherAmt;
	}

	public void setOtherAmt(String otherAmt) {
		this.otherAmt = otherAmt;
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

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	public String getCashTypeName() {
		return OrderEnums.CashType.getByKey(this.getCashType());
	}

	public String getPointAmt() {
		return pointAmt;
	}

	public void setPointAmt(String pointAmt) {
		this.pointAmt = pointAmt;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getCashManId() {
		return cashManId;
	}

	public void setCashManId(String cashManId) {
		this.cashManId = cashManId;
	}

	public String getCashMan() {
		return cashMan;
	}

	public void setCashMan(String cashMan) {
		this.cashMan = cashMan;
	}

	public String getGuiderId() {
		return guiderId;
	}

	public void setGuiderId(String guiderId) {
		this.guiderId = guiderId;
	}

	public String getGuiderName() {
		return guiderName;
	}

	public void setGuiderName(String guiderName) {
		this.guiderName = guiderName;
	}

	public String getVipId() {
		return vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getVipMobile() {
		return vipMobile;
	}

	public void setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
	}

	public String getReceiveTel() {
		return receiveTel;
	}

	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiveAddr() {
		return receiveAddr;
	}

	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getCostAmt() {
		return costAmt;
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String toLog() {
		return " - orderId:" + String.valueOf(orderId) + " - orderStatus:" + String.valueOf(orderStatus)
				+ " - companyId:" + String.valueOf(companyId) + " - orgId:" + String.valueOf(orgId) + " - orgName:"
				+ String.valueOf(orgName) + " - areaId:" + String.valueOf(areaId) + " - areaName:"
				+ String.valueOf(areaName) + " - i_year:" + String.valueOf(i_year) + " - i_month:"
				+ String.valueOf(i_month) + " - i_season:" + String.valueOf(i_season) + " - commitTime:"
				+ String.valueOf(commitTime) + " - cashDate:" + String.valueOf(cashDate) + " - payableAmt:"
				+ String.valueOf(payableAmt) + " - payAmt:" + String.valueOf(payAmt) + " - saleAmt:"
				+ String.valueOf(salesAmt) + " - discountAmt:" + String.valueOf(discountAmt) + " - fullCutAmt:"
				+ String.valueOf(fullCutAmt) + " - couponAmt:" + String.valueOf(couponAmt) + " - malingAmt:"
				+ String.valueOf(malingAmt) + " - simpleDiscountAmt:" + String.valueOf(simpleDiscountAmt)
				+ " - remarks:" + String.valueOf(remarks) + " - payTypeCode:" + String.valueOf(payTypeCode)
				+ " - payTypeName:" + String.valueOf(payTypeName) + " - cashAmt:" + String.valueOf(cashAmt)
				+ " - wxAmt:" + String.valueOf(wxAmt) + " - alipayAmt:" + String.valueOf(alipayAmt) + " - otherAmt:"
				+ String.valueOf(otherAmt) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - payStatus:" + String.valueOf(payStatus) + " - cashType:"
				+ String.valueOf(cashType) + " - cashTypeName:" + String.valueOf(cashTypeName) + " - pointAmt:"
				+ String.valueOf(pointAmt) + " - point:" + String.valueOf(point) + " - cashManId:"
				+ String.valueOf(cashManId) + " - cashMan:" + String.valueOf(cashMan) + " - guiderId:"
				+ String.valueOf(guiderId) + " - guiderName:" + String.valueOf(guiderName) + " - vipId:"
				+ String.valueOf(vipId) + " - vipName:" + String.valueOf(vipName) + " - vipMobile:"
				+ String.valueOf(vipMobile) + " - receiveTel:" + String.valueOf(receiveTel) + " - receiver:"
				+ String.valueOf(receiver) + " - receiveAddr:" + String.valueOf(receiveAddr) + " - orderStatusName:"
				+ String.valueOf(orderStatusName) + " - costAmt:" + String.valueOf(costAmt) + " - nums:"
				+ String.valueOf(nums);
	}
}