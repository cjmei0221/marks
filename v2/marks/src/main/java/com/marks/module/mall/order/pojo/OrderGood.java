package com.marks.module.mall.order.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.marks.common.util.date.DateUtil;
import com.marks.module.mall.stock.pojo.BarCode;

public class OrderGood implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * 计算金额
	 *
	 */
	private String salePriceAmt;

	/**
	 * 小计
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
	 * 单品议价金额
	 *
	 */
	private String goodManDiscountAmt;

	private String payRate;// 占比

	private List<String> barCodeList = new ArrayList<String>();// 商品唯一条码集合
	private List<BarCode> barList = new ArrayList<BarCode>();// 商品唯一条码集合

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

	private String helpCode;// 助记码

	public OrderGood() {
		this.createtime = DateUtil.getCurrDateStr();
		this.updatetime = DateUtil.getCurrDateStr();
	}

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
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

	public String getNowPriceAmt() {
		return nowPriceAmt;
	}

	public void setNowPriceAmt(String nowPriceAmt) {
		this.nowPriceAmt = nowPriceAmt;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public List<BarCode> getBarList() {
		return barList;
	}

	public void setBarList(List<BarCode> barList) {
		this.barList = barList;
	}

	public void addBarList(BarCode bar) {
		this.barList.add(bar);
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public List<String> getBarCodeList() {
		return barCodeList;
	}

	public void setBarCodeList(List<String> barCodeList) {
		this.barCodeList = barCodeList;
	}

	public void addBarCode(String barCode) {
		this.barCodeList.add(barCode);
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}

	public String getGoodManDiscountAmt() {
		return goodManDiscountAmt;
	}

	public void setGoodManDiscountAmt(String goodManDiscountAmt) {
		this.goodManDiscountAmt = goodManDiscountAmt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getSalePriceAmt() {
		return salePriceAmt;
	}

	public void setSalePriceAmt(String salePriceAmt) {
		this.salePriceAmt = salePriceAmt;
	}

	public String getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(String salesAmt) {
		this.salesAmt = salesAmt;
	}

	public String getHelpCode() {
		return helpCode;
	}

	public void setHelpCode(String helpCode) {
		this.helpCode = helpCode;
	}

	public String toLog() {
		return " - orderGoodId:" + String.valueOf(orderGoodId) + " - orderId:" + String.valueOf(orderId) + " - goodId:"
				+ String.valueOf(goodId) + " - goodNo:" + String.valueOf(goodNo) + " - goodName:"
				+ String.valueOf(goodName) + " - barNo:" + String.valueOf(barNo) + " - picUrl:" + String.valueOf(picUrl)
				+ " - unit:" + String.valueOf(unit) + " - rank:" + String.valueOf(rank) + " - typeId:"
				+ String.valueOf(typeId) + " - typeName:" + String.valueOf(typeName) + " - brandId:"
				+ String.valueOf(brandId) + " - brandName:" + String.valueOf(brandName) + " - nums:"
				+ String.valueOf(nums) + " - salePrice:" + String.valueOf(salePrice) + " - nowPrice:" + " - payableAmt:"
				+ String.valueOf(payableAmt) + " - payAmt:" + String.valueOf(payAmt) + " - cashAmt:"
				+ String.valueOf(cashAmt) + " - wxAmt:" + String.valueOf(wxAmt) + " - alipayAmt:"
				+ String.valueOf(alipayAmt) + " - otherAmt:" + String.valueOf(otherAmt) + " - saleAmt:"
				+ String.valueOf(salesAmt) + " - discountAmt:" + String.valueOf(discountAmt) + " - fullCutAmt:"
				+ String.valueOf(fullCutAmt) + " - couponAmt:" + String.valueOf(couponAmt) + " - pointAmt:"
				+ String.valueOf(pointAmt) + " - mlAmt:" + String.valueOf(mlAmt) + " - simpleDiscountAmt:"
				+ String.valueOf(simpleDiscountAmt) + " - createtime:" + String.valueOf(createtime) + " - updatetime:"
				+ String.valueOf(updatetime) + " - costAmt:" + String.valueOf(costAmt) + " - costPrice:"
				+ String.valueOf(costPrice);
	}
}