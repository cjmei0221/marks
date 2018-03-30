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
import com.marks.common.util.IDUtil;
import com.marks.common.util.number.MoneyUtil;
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
	public void saveOrder(OrderInfo info, List<OrderGood> goodList, List<String> barCodeList) {
		// 会员信息
		if (info.getVipId() != null && info.getVipId().length() > 4) {
			SysUser vip = sysUserService.findById(info.getVipId());
			info.setVipMobile(vip.getBind_mobile());
			info.setVipName(vip.getUsername());
		}
		info.setI_year(info.getCashDate().substring(0, 4));
		info.setI_month(info.getCashDate().substring(5, 7));
		info.setI_season(getSeasion(info.getI_month()) + "");
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
		countOrder(info, goodList, stockList);
		// 保存订单
		orderInfoDao.save(info);
		// 保存订单商品
		orderGoodDao.saveBatch(goodList);
		// 减库存
		if (stockList.size() > 0) {
			stockBatchService.updateSaleOut(stockList, barList);
		}
	}

	private void countOrder(OrderInfo info, List<OrderGood> goodList, List<StockBatch> stockList) {
		String payableAmt = "";// 应付金额
		int nums = 0;// 商品数量
		int idx = 1;
		for (OrderGood good : goodList) {
			good.setCompanyId(info.getCompanyId());
			good.setOrderGoodId(info.getOrderId() + idx);
			good.setOrderId(info.getOrderId());
			payableAmt = MoneyUtil.add(payableAmt, good.getPayableAmt());
			nums = nums + good.getNums();
			idx++;
		}
		info.setPayableAmt(payableAmt);
		info.setSimpleDiscountAmt(MoneyUtil.subtract(info.getPayableAmt(), info.getPayAmt()));
		info.setNums(nums);
		String costAmt = "";
		String saleAmt = "";
		String countAmt = "";
		String oriPriceAmt = "";
		String mandiscountAmt = "";
		for (OrderGood good : goodList) {
			String rate = "0.000000";
			double totalPayableAmt = Double.parseDouble(info.getPayableAmt());
			if (totalPayableAmt > 0) {
				rate = String.valueOf(Double.parseDouble(good.getPayableAmt()) / totalPayableAmt);
			}
			good.setCashAmt(MoneyUtil.multiply(info.getPayAmt(), rate));
			good.setPayAmt(MoneyUtil.multiply(info.getPayAmt(), rate));
			good.setCountAmt(MoneyUtil.multiply(good.getSalePrice(), String.valueOf(good.getNums())));
			good.setOriPriceAmt(MoneyUtil.multiply(good.getPrice(), String.valueOf(good.getNums())));
			good.setSimpleDiscountAmt(MoneyUtil.multiply(info.getSimpleDiscountAmt(), rate));
			good.setSaleAmt(MoneyUtil.subtract(good.getCountAmt(), good.getPayAmt()));
			good.setGoodManDiscountAmt(MoneyUtil.subtract(good.getCountAmt(), good.getPayableAmt()));
			good.setSimpleDiscountAmt(MoneyUtil.add(good.getSimpleDiscountAmt(), good.getGoodManDiscountAmt()));
			BigDecimal payRate = new BigDecimal(rate);
			payRate = payRate.setScale(18, BigDecimal.ROUND_HALF_UP);
			good.setPayRate(payRate.toString());
			stock(info, good, stockList);
			costAmt = MoneyUtil.add(costAmt, good.getCostAmt());
			saleAmt = MoneyUtil.add(saleAmt, good.getSaleAmt());
			countAmt = MoneyUtil.add(countAmt, good.getCountAmt());
			oriPriceAmt = MoneyUtil.add(oriPriceAmt, good.getOriPriceAmt());
			mandiscountAmt = MoneyUtil.add(mandiscountAmt, good.getGoodManDiscountAmt());
		}
		// info.setSaleAmt(saleAmt);
		info.setSimpleDiscountAmt(MoneyUtil.add(info.getSimpleDiscountAmt(), mandiscountAmt));
		info.setCostAmt(costAmt);
		info.setCountAmt(countAmt);
		info.setSaleAmt(MoneyUtil.subtract(info.getCountAmt(), info.getPayAmt()));
		info.setOriPriceAmt(oriPriceAmt);

	}

	private List<StockBatch> stock(OrderInfo info, OrderGood good, List<StockBatch> stockList) {
		List<StockBatch> stock = stockBatchService.getStockBatchByGood(info.getOrgId(), good);
		if (null != stock && stock.size() > 0) {
			good.setCostPrice(stock.get(0).getCostPrice());
			good.setCostAmt(MoneyUtil.multiply(good.getCostPrice(), String.valueOf(good.getNums())));
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
			}
		}
		return stock;
	}

}