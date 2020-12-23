package com.marks.smart.market.mall.report.pojo;

import com.marks.smart.market.mall.order.pojo.OrderGood;

public class OrderLog extends OrderGood{

	/**
	 * 订单商品编号
	 *
	 */
	private String orderGoodId;
	/**
	 * 订单编号
	 *
	 */
	private String orderId;
	/**
	 * 商品系统编号
	 *
	 */
	private String goodId;
	/**
	 * 商品编号
	 *
	 */
	private String goodNo;
	/**
	 * 商品名称
	 *
	 */
	private String goodName;
	/**
	 * 商品条码
	 *
	 */
	private String barNo;
	/**
	 * 列表图片
	 *
	 */
	private String picUrl;
	/**
	 * 单位
	 *
	 */
	private String unit;
	/**
	 * 规格
	 *
	 */
	private String rank;
	/**
	 * 类别编号
	 *
	 */
	private String typeId;
	/**
	 * 类别名称
	 *
	 */
	private String typeName;
	/**
	 * 品牌编号
	 *
	 */
	private String brandId;
	/**
	 * 品牌名称
	 *
	 */
	private String brandName;
	/**
	 * 数量
	 *
	 */
	private int nums;
	/**
	 * 售价
	 *
	 */
	private String salePrice;

	/**
	 * 应付金额
	 *
	 */
	private String payableAmt;
	/**
	 * 实付金额
	 *
	 */
	private String payAmt;

	private String recevieAmt;
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
	 * 其他金额
	 *
	 */
	private String otherAmt;
	/**
	 * 促销金额
	 *
	 */
	private String salesAmt;
	/**
	 * 折扣金额
	 *
	 */
	private String discountAmt;
	/**
	 * 满减金额
	 *
	 */
	private String fullCutAmt;
	/**
	 * 优惠券金额
	 *
	 */
	private String couponAmt;
	/**
	 * 积分抵扣金额
	 *
	 */
	private String pointAmt;
	/**
	 * 抹零金额
	 *
	 */
	private String mlAmt;
	/**
	 * 议价均额
	 *
	 */
	private String simpleDiscountAmt;
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
	 * 进货金额
	 *
	 */
	private String costAmt;
	/**
	 * 进货价
	 *
	 */
	private String costPrice;

	private String remarks;

	/**
	 * 计算金额
	 *
	 */
	private String salePriceAmt;

	/**
	 * 单品议价金额
	 *
	 */
	private String goodManDiscountAmt;

	private String payRate;// 占比

	private String companyId;

	private int stockType;

	/**
	 * 级别1ID
	 *
	 */
	private String lvl1Id;
	/**
	 * 级别1姓名
	 *
	 */
	private String lvl1Name;
	/**
	 * 级别2ID
	 *
	 */
	private String lvl2Id;
	/**
	 * 级别2姓名
	 *
	 */
	private String lvl2Name;
	/**
	 * 级别3ID
	 *
	 */
	private String lvl3Id;
	/**
	 * 级别3姓名
	 *
	 */
	private String lvl3Name;
	/**
	 * 级别4ID
	 *
	 */
	private String lvl4Id;
	/**
	 * 级别4姓名
	 *
	 */
	private String lvl4Name;
	/**
	 * 级别5ID
	 *
	 */
	private String lvl5Id;
	/**
	 * 级别5姓名
	 *
	 */
	private String lvl5Name;

	private String vipPrice;

	private String nowPrice;// 现销售价

	private String nowPriceAmt;// 现价金额

	private int point;// 可得积分

	private int usePoint;// 使用积分

	private String payPrice;// 实际成交价 actualPrice

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
	private String i_year;
	/**
	 * 月份
	 *
	 */
	private String i_month;
	/**
	 * 季度
	 *
	 */
	private String i_season;
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

	private String channelId;// 渠道

	private String channel;// 渠道

	private int balStockNums;// 剩余库存

	private String balStockAmt;// 剩余库存金额

	private String helpCode;// 助记码

	private int sendNums;// 赠送数量

	private String sendAmt;// 赠送金额

	private int payNums;// 支付数量
	
	

	public int getSendNums() {
		return sendNums;
	}

	public void setSendNums(int sendNums) {
		this.sendNums = sendNums;
	}

	public String getSendAmt() {
		return sendAmt;
	}

	public void setSendAmt(String sendAmt) {
		this.sendAmt = sendAmt;
	}

	public int getPayNums() {
		return payNums;
	}

	public void setPayNums(int payNums) {
		this.payNums = payNums;
	}

	public String getHelpCode() {
		return helpCode;
	}

	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}

	public int getBalStockNums() {
		return balStockNums;
	}

	public void setBalStockNums(int balStockNums) {
		this.balStockNums = balStockNums;
	}

	public String getBalStockAmt() {
		return balStockAmt;
	}

	public void setBalStockAmt(String balStockAmt) {
		this.balStockAmt = balStockAmt;
	}

	public String getOrderGoodId() {
		return orderGoodId;
	}

	public void setOrderGoodId(String orderGoodId) {
		this.orderGoodId = orderGoodId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodNo() {
		return goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getBarNo() {
		return barNo;
	}

	public void setBarNo(String barNo) {
		this.barNo = barNo;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
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

	public String getRecevieAmt() {
		return recevieAmt;
	}

	public void setRecevieAmt(String recevieAmt) {
		this.recevieAmt = recevieAmt;
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

	public String getStoredAmt() {
		return storedAmt;
	}

	public void setStoredAmt(String storedAmt) {
		this.storedAmt = storedAmt;
	}

	public String getOtherAmt() {
		return otherAmt;
	}

	public void setOtherAmt(String otherAmt) {
		this.otherAmt = otherAmt;
	}

	public String getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
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

	public String getPointAmt() {
		return pointAmt;
	}

	public void setPointAmt(String pointAmt) {
		this.pointAmt = pointAmt;
	}

	public String getMlAmt() {
		return mlAmt;
	}

	public void setMlAmt(String mlAmt) {
		this.mlAmt = mlAmt;
	}

	public String getSimpleDiscountAmt() {
		return simpleDiscountAmt;
	}

	public void setSimpleDiscountAmt(String simpleDiscountAmt) {
		this.simpleDiscountAmt = simpleDiscountAmt;
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

	public String getCostAmt() {
		return costAmt;
	}

	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSalePriceAmt() {
		return salePriceAmt;
	}

	public void setSalePriceAmt(String salePriceAmt) {
		this.salePriceAmt = salePriceAmt;
	}

	public String getGoodManDiscountAmt() {
		return goodManDiscountAmt;
	}

	public void setGoodManDiscountAmt(String goodManDiscountAmt) {
		this.goodManDiscountAmt = goodManDiscountAmt;
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public String getLvl1Id() {
		return lvl1Id;
	}

	public void setLvl1Id(String lvl1Id) {
		this.lvl1Id = lvl1Id;
	}

	public String getLvl1Name() {
		return lvl1Name;
	}

	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
	}

	public String getLvl2Id() {
		return lvl2Id;
	}

	public void setLvl2Id(String lvl2Id) {
		this.lvl2Id = lvl2Id;
	}

	public String getLvl2Name() {
		return lvl2Name;
	}

	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}

	public String getLvl3Id() {
		return lvl3Id;
	}

	public void setLvl3Id(String lvl3Id) {
		this.lvl3Id = lvl3Id;
	}

	public String getLvl3Name() {
		return lvl3Name;
	}

	public void setLvl3Name(String lvl3Name) {
		this.lvl3Name = lvl3Name;
	}

	public String getLvl4Id() {
		return lvl4Id;
	}

	public void setLvl4Id(String lvl4Id) {
		this.lvl4Id = lvl4Id;
	}

	public String getLvl4Name() {
		return lvl4Name;
	}

	public void setLvl4Name(String lvl4Name) {
		this.lvl4Name = lvl4Name;
	}

	public String getLvl5Id() {
		return lvl5Id;
	}

	public void setLvl5Id(String lvl5Id) {
		this.lvl5Id = lvl5Id;
	}

	public String getLvl5Name() {
		return lvl5Name;
	}

	public void setLvl5Name(String lvl5Name) {
		this.lvl5Name = lvl5Name;
	}

	public String getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getNowPriceAmt() {
		return nowPriceAmt;
	}

	public void setNowPriceAmt(String nowPriceAmt) {
		this.nowPriceAmt = nowPriceAmt;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
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

	public String getI_year() {
		return i_year;
	}

	public void setI_year(String i_year) {
		this.i_year = i_year;
	}

	public String getI_month() {
		return i_month;
	}

	public void setI_month(String i_month) {
		this.i_month = i_month;
	}

	public String getI_season() {
		return i_season;
	}

	public void setI_season(String i_season) {
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

	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}

	public String getCashTypeName() {
		return cashTypeName;
	}

	public void setCashTypeName(String cashTypeName) {
		this.cashTypeName = cashTypeName;
	}

	public String getCashManId() {
		return cashManId;
	}

	public void setCashManId(String cashManId) {
		this.cashManId = cashManId;
	}

	public String getCashManCode() {
		return cashManCode;
	}

	public void setCashManCode(String cashManCode) {
		this.cashManCode = cashManCode;
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

	public String getGuiderCode() {
		return guiderCode;
	}

	public void setGuiderCode(String guiderCode) {
		this.guiderCode = guiderCode;
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

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
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

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
