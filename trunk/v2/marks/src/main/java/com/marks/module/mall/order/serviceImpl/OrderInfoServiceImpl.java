package com.marks.module.mall.order.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.AcctEnums;
import com.marks.common.enums.FeeEnums;
import com.marks.common.enums.OrderEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.module.acct.base.service.UserExtService;
import com.marks.module.acct.ext.pojo.PointLog;
import com.marks.module.acct.ext.pojo.TranLog;
import com.marks.module.acct.ext.service.AcctService;
import com.marks.module.fee.log.pojo.FeeLog;
import com.marks.module.fee.log.service.FeeLogService;
import com.marks.module.mall.order.dao.OrderGoodDao;
import com.marks.module.mall.order.dao.OrderInfoDao;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.pojo.OrderInfo;
import com.marks.module.mall.order.service.OrderInfoService;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.service.BarCodeService;
import com.marks.module.mall.stock.service.StockBatchService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.service.SysUserService;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private OrderGoodDao orderGoodDao;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private StockBatchService stockBatchService;
	@Autowired
	private BarCodeService barCodeService;

	@Autowired
	private AcctService acctService;

	@Autowired
	private UserExtService userExtService;

	@Autowired
	private FeeLogService feeLogService;

	/**
	 * private OrderInfoDao orderInfoDao;
	 * 
	 * public OrderInfoDao getOrderInfoDao(){ return orderInfoDao; } public void
	 * setOrderInfoDao(OrderInfoDao orderInfoDao){ this.orderInfoDao
	 * =orderInfoDao; }
	 * 
	 */
	/**
	 * 根据ID查找订单管理
	 */
	@Override
	public OrderInfo findById(String id) {
		return orderInfoDao.findById(id);
	}

	/**
	 * 更新订单管理
	 */
	@Override
	public void update(OrderInfo info) {
		orderInfoDao.update(info);
	}

	/**
	 * 删除订单管理
	 */
	@Override
	public void delete(String id) {
		orderInfoDao.delete(id);
	}

	/**
	 * 查找所有订单管理
	 */
	@Override
	public List<OrderInfo> findAll() {
		return orderInfoDao.findAll();
	}

	/**
	 * 删除多个订单管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		orderInfoDao.deleteBatch(ids);
	}

	public PojoDomain<OrderInfo> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<OrderInfo> pojoDomain = new PojoDomain<OrderInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrderInfo> list = orderInfoDao.list(pageBounds, param);
		PageList<OrderInfo> pageList = (PageList<OrderInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public String getOrderId() {
		return IDUtil.getNumID();
	}

	private int getSeasion(String monthStr) {
		int month = Integer.parseInt(monthStr);
		if (month < 4) {
			return 1;
		} else if (month < 7) {
			return 2;
		} else if (month < 10) {
			return 3;
		}
		return 4;
	}

	@Override
	public void saveRecharge(OrderInfo info) {
		dealOrder(info);
		// 保存订单
		orderInfoDao.save(info);
		// 充值帐户
		saveBalAmt(info);
		// 记录费用
		saveFeeLog(info);
	}

	private void saveBalAmt(OrderInfo info) {
		TranLog log = new TranLog();
		log.setCashAmt(info.getPayAmt());
		log.setRemarks("会员充值");
		log.setSendAmt(MoneyUtil.subtract(info.getPayableAmt(), info.getPayAmt()));
		log.setTranAmt(info.getPayableAmt());
		log.setTranCode(AcctEnums.TranCode.add.getValue());
		log.setTranDesc("会员充值");
		log.setTranTime(info.getCommitTime());
		log.setUserid(info.getVipId());
		log.setChannelId(info.getChannelId());
		log.setOrgId(info.getOrgId());
		log.setOrgName(info.getOrgName());
		log.setOperatorCode(info.getCashManCode());
		log.setOperatorName(info.getCashMan());
		acctService.saveAmt(log);

	}

	private void dealOrder(OrderInfo info) {
		// 会员信息
		if (info.getVipId() != null && info.getVipId().length() > 4) {
			SysUser vip = sysUserService.findByUserid(info.getVipId());
			info.setVipMobile(vip.getBind_mobile());
			info.setVipName(vip.getUsername());
			info.setVipCode(vip.getUserCode());
		}
		info.setI_year(info.getCashDate().substring(0, 4));
		info.setI_month(info.getCashDate().substring(5, 7));
		info.setI_season(getSeasion(info.getI_month()) + "");
		info.setRecevieAmt(MoneyUtil.add(info.getCashAmt(), info.getWxAmt()));
		info.setRecevieAmt(MoneyUtil.add(info.getRecevieAmt(), info.getAlipayAmt()));
		info.setRecevieAmt(MoneyUtil.add(info.getRecevieAmt(), info.getOtherAmt()));
	}

	@Override
	public void saveOrder(OrderInfo info, List<OrderGood> goodList, List<String> barCodeList) {
		dealOrder(info);
		// 计算订单商品
		List<StockBatch> stockList = new ArrayList<StockBatch>();

		List<BarCode> barList = null;
		if (barCodeList != null && barCodeList.size() > 0) {
			barList = barCodeService.getBarCodeListByBarCodes(barCodeList);
			if (null != barList && barList.size() > 0) {
				for (OrderGood good : goodList) {
					for (BarCode bar : barList) {
						if (good.getGoodId().equals(bar.getGoodId())) {
							good.addBarCode(bar.getBarcode());
							good.addBarList(bar);
						}

					}
				}
			}
		}
		dealGood(info, goodList, stockList);
		// 给会员积分
		if (null != info.getVipId() && info.getVipId().length() > 4) {
			saveVipPoint(info, goodList);
		}
		if (info.getUsePoint() > 0) {
			saveVipLessPoint(info);
		}
		// 储值卡
		if (MoneyUtil.compare(info.getStoredAmt(), "0.01")) {
			saveVipLessBalAmt(info);
		}
		// 保存订单
		orderInfoDao.save(info);
		// 保存订单商品
		orderGoodDao.saveBatch(goodList);
		// 减库存
		if (stockList.size() > 0) {
			stockBatchService.updateSaleOut(stockList, barList);
		}
		// 处理会员等级等信息
		if (null != info.getVipId() && info.getVipId().length() > 4) {
			userExtService.updateVipInfoByOrder(info.getVipId(), info.getPoint(), info.getPayAmt());
		}
		if (MoneyUtil.compare(info.getRecevieAmt(), "0.01")) {
			// 记录费用
			saveFeeLog(info);
		}
	}

	private void saveFeeLog(OrderInfo info) {
		FeeLog log = new FeeLog();
		log.setCompanyId(info.getCompanyId());
		if (OrderEnums.CashType.recharge.getValue().equals(info.getCashType())) {
			log.setFeeCode(FeeEnums.FeeCode.recharge.getValue());
			log.setItemCode(FeeEnums.ItemCode.recharge.getValue());
		} else {
			log.setFeeCode(FeeEnums.FeeCode.consume.getValue());
			log.setItemCode(FeeEnums.ItemCode.consume.getValue());
		}
		log.setIdNo(info.getOrderId());
		log.setItemName(FeeEnums.ItemCode.getByKey(log.getItemCode()));
		log.setPayeeId(info.getVipId());
		log.setRemarks(info.getRemarks());
		log.setTranAmt(info.getRecevieAmt());
		log.setTranTime(info.getCommitTime());
		feeLogService.save(log);
	}

	private void saveVipLessBalAmt(OrderInfo info) {
		TranLog log = new TranLog();
		log.setCashAmt(info.getPayAmt());
		log.setRemarks("会员购买消费");
		log.setTranAmt(info.getStoredAmt());
		log.setTranCode(AcctEnums.TranCode.less.getValue());
		log.setTranDesc("会员消费");
		log.setTranTime(info.getCommitTime());
		log.setUserid(info.getVipId());
		log.setChannelId(info.getChannelId());
		log.setOrgId(info.getOrgId());
		log.setOrgName(info.getOrgName());
		log.setOperatorCode(info.getCashManCode());
		log.setOperatorName(info.getCashMan());
		acctService.saveAmt(log);
	}

	private void saveVipLessPoint(OrderInfo info) {
		PointLog log = new PointLog();
		log.setChannelId(info.getChannelId());
		log.setOperatorCode(info.getCashManCode());
		log.setOperatorName(info.getCashMan());
		log.setOrgId(info.getOrgId());
		log.setOrgName(info.getOrgName());
		log.setRemarks("抵扣购买商品金额");
		log.setTranCode(AcctEnums.TranCode.less.getValue());
		log.setTranDesc("抵扣消费");
		log.setTranPoint(info.getUsePoint());
		log.setTranTime(info.getCommitTime());
		log.setUserid(info.getVipId());
		acctService.savePoint(log);
	}

	private void saveVipPoint(OrderInfo info, List<OrderGood> goodList) {
		String pointType = "2";// 1:按商品积分 2:按订单金额积分 1元 1积分
		int goodPoint = 0;
		for (OrderGood good : goodList) {
			goodPoint += good.getPoint();
			if (!"1".equals(pointType)) {
				good.setPoint(0);
			}
			good.setUsePoint(0);
		}

		PointLog log = new PointLog();
		if ("1".equals(pointType)) {
			log.setRemarks("购买商品积分");
			log.setTranPoint(goodPoint);
		} else {
			double point = Double.parseDouble(info.getPayAmt());
			log.setTranPoint((int) point);
		}
		if (log.getTranPoint() > 0) {
			log.setTranCode(AcctEnums.TranCode.add.getValue());
			log.setTranDesc("消费积分");
			log.setTranTime(info.getCommitTime());
			log.setUserid(info.getVipId());
			log.setChannelId(info.getChannelId());
			log.setOrgId(info.getOrgId());
			log.setOrgName(info.getOrgName());
			log.setOperatorCode(info.getCashManCode());
			log.setOperatorName(info.getCashMan());
			acctService.savePoint(log);
		}
		info.setPoint(log.getTranPoint());
	}

	private void dealGood(OrderInfo info, List<OrderGood> goodList, List<StockBatch> stockList) {
		String payableAmt = "";// 应付金额
		int nums = 0;// 商品数量
		int idx = 1;
		for (OrderGood good : goodList) {
			info.setRemarks("购买" + good.getGoodName() + "等");
			good.setCompanyId(info.getCompanyId());
			good.setOrderGoodId(info.getOrderId() + idx);
			good.setOrderId(info.getOrderId());
			payableAmt = MoneyUtil.add(payableAmt, good.getPayableAmt());
			nums = nums + good.getNums();
			idx++;
		}
		info.setSimpleDiscountAmt(MoneyUtil.subtract(info.getPayableAmt(), info.getPayAmt()));
		info.setNums(nums);
		String costAmt = "";
		String countAmt = "";
		String oriPriceAmt = "";
		String mandiscountAmt = "";
		String nowPriceAmt = "";// 现价金额
		String countGoodPayableAmt = "";
		for (OrderGood good : goodList) {
			String rate = "0.000000";
			double totalPayableAmt = Double.parseDouble(payableAmt);
			if (totalPayableAmt != 0) {
				rate = String.valueOf(Double.parseDouble(good.getPayableAmt()) / totalPayableAmt);
			}
			countGoodPayableAmt = MoneyUtil.multiply(info.getPayableAmt(), rate);
			// 实付金额
			good.setPayAmt(MoneyUtil.multiply(info.getPayAmt(), rate));
			// 收款金额
			good.setRecevieAmt(MoneyUtil.multiply(info.getRecevieAmt(), rate));
			// 售价金额
			good.setCountAmt(MoneyUtil.multiply(good.getSalePrice(), String.valueOf(good.getNums())));
			// 现价金额
			good.setNowPriceAmt(MoneyUtil.multiply(good.getNowPrice(), String.valueOf(good.getNums())));
			// 原价金额
			good.setOriPriceAmt(MoneyUtil.multiply(good.getPrice(), String.valueOf(good.getNums())));
			// 支付金额
			good.setCashAmt(MoneyUtil.multiply(info.getCashAmt(), rate));
			good.setAlipayAmt(MoneyUtil.multiply(info.getAlipayAmt(), rate));
			good.setWxAmt(MoneyUtil.multiply(info.getWxAmt(), rate));
			good.setOtherAmt(MoneyUtil.multiply(info.getOtherAmt(), rate));
			good.setStoredAmt(MoneyUtil.multiply(info.getStoredAmt(), rate));

			// 积分抵扣金额
			good.setPointAmt(MoneyUtil.multiply(info.getPointAmt(), rate));

			// 促销总额=满减促销+单品促销+单品折扣
			good.setSaleAmt(MoneyUtil.subtract(good.getCountAmt(), good.getPayAmt()));
			// 单品促销
			good.setDiscountAmt(MoneyUtil.subtract(good.getCountAmt(), good.getNowPriceAmt()));
			// 单品折扣
			good.setGoodManDiscountAmt(MoneyUtil.subtract(good.getNowPriceAmt(), good.getPayableAmt()));
			// 满减促销
			good.setFullCutAmt(MoneyUtil.subtract(good.getPayableAmt(), countGoodPayableAmt));
			// 整单折扣
			good.setSimpleDiscountAmt(MoneyUtil.multiply(info.getSimpleDiscountAmt(), rate));
			// 手工总折扣
			good.setSimpleDiscountAmt(MoneyUtil.add(good.getSimpleDiscountAmt(), good.getGoodManDiscountAmt()));

			BigDecimal payRate = new BigDecimal(rate);
			payRate = payRate.setScale(18, BigDecimal.ROUND_HALF_UP);
			good.setPayRate(payRate.toString());
			stock(info, good, stockList);
			costAmt = MoneyUtil.add(costAmt, good.getCostAmt());
			countAmt = MoneyUtil.add(countAmt, good.getCountAmt());
			oriPriceAmt = MoneyUtil.add(oriPriceAmt, good.getOriPriceAmt());
			mandiscountAmt = MoneyUtil.add(mandiscountAmt, good.getGoodManDiscountAmt());
			nowPriceAmt = MoneyUtil.add(nowPriceAmt, good.getNowPriceAmt());
		}
		info.setNowPriceAmt(nowPriceAmt);
		info.setOriPriceAmt(oriPriceAmt);
		info.setCostAmt(costAmt);
		info.setCountAmt(countAmt);
		// 促销总额=满减促销+单品促销+单品折扣
		info.setSaleAmt(MoneyUtil.subtract(info.getCountAmt(), info.getPayAmt()));
		// 满减金额
		info.setFullCutAmt(MoneyUtil.subtract(payableAmt, info.getPayableAmt()));
		// 单品促销总折扣
		info.setDiscountAmt(MoneyUtil.subtract(info.getCountAmt(), info.getNowPriceAmt()));
		// 人工总折扣
		info.setSimpleDiscountAmt(MoneyUtil.add(info.getSimpleDiscountAmt(), mandiscountAmt));

	}

	private List<StockBatch> stock(OrderInfo info, OrderGood good, List<StockBatch> stockList) {
		List<StockBatch> stock = stockBatchService.getStockBatchByGood(info.getOrgId(), good);
		if (null != stock && stock.size() > 0) {
			good.setCostPrice(stock.get(0).getCostPrice());
			good.setCostAmt(MoneyUtil.multiply(good.getCostPrice(), String.valueOf(good.getNums())));
			for (StockBatch b : stock) {
				b.setOperator(info.getCashMan());
			}
			stockList.addAll(stock);
		} else {
			good.setCostPrice(good.getCostPrice());
			good.setCostAmt(MoneyUtil.multiply(good.getCostPrice(), String.valueOf(good.getNums())));
		}
		if (null != good.getBarList() && good.getBarList().size() > 0) {
			for (BarCode b : good.getBarList()) {
				b.setMobile(info.getVipMobile());
				b.setOrderGoodId(good.getOrderGoodId());
				b.setOrderId(good.getOrderId());
				b.setOrgid(info.getOrgId());
				b.setOrgname(info.getOrgName());
				b.setPrice(good.getPrice());
				b.setSalePrice(MoneyUtil.divide(good.getPayAmt(), String.valueOf(good.getNums())));
				b.setUserid(info.getVipId());
				b.setUsername(info.getVipName());
				b.setOperator(info.getCashMan());
			}
		}
		return stock;
	}

}