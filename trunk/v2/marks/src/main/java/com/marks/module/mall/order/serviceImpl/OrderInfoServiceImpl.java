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
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.service.StockBatchService;
import com.marks.module.user.sysuser.pojo.SysUser;
import com.marks.module.user.sysuser.service.SysUserService;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private OrderGoodDao orderGoodDao;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private StockBatchService stockBatchService;
   
/**
    private OrderInfoDao orderInfoDao;

    public OrderInfoDao getOrderInfoDao(){
        return orderInfoDao;
    }
    public void setOrderInfoDao(OrderInfoDao orderInfoDao){
        this.orderInfoDao =orderInfoDao;
    }

 */   
    /**
    *根据ID查找订单管理
    */
    @Override
    public OrderInfo findById(String id){
        return orderInfoDao.findById(id);
    }
    
    /**
    *更新订单管理
    */
    @Override
    public void update(OrderInfo info){
        orderInfoDao.update(info);
    }
    
    /**
    *删除订单管理
    */
    @Override
    public void delete(String id){
        orderInfoDao.delete(id);       
    }
    
    /**
    *查找所有订单管理
    */
    @Override
    public List<OrderInfo> findAll(){
        return orderInfoDao.findAll();   
    }
    
    /**
    *删除多个订单管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		orderInfoDao.deleteBatch(ids);
	}
	
	public PojoDomain<OrderInfo> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<OrderInfo> pojoDomain = new PojoDomain<OrderInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrderInfo> list = orderInfoDao.list(pageBounds,param);
		PageList<OrderInfo> pageList = (PageList<OrderInfo>)list; 
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
	public void saveOrder(OrderInfo info, List<OrderGood> goodList) {
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
		countOrder(info, goodList, stockList);

		// 保存订单
		orderInfoDao.save(info);
		// 保存订单商品
		orderGoodDao.saveBatch(goodList);
		// 减库存
		if (stockList.size() > 0) {
			stockBatchService.updateSaleOut(stockList);
		}
	}

	private void countOrder(OrderInfo info, List<OrderGood> goodList, List<StockBatch> stockList) {
		String payableAmt = "";// 应付金额
		int nums = 0;// 商品数量
		for (OrderGood good : goodList) {
			good.setOrderGoodId(info.getOrderId() + "_" + good.getGoodId());
			good.setOrderId(info.getOrderId());
			payableAmt = MoneyUtil.add(payableAmt, good.getPayableAmt());
			nums = nums + good.getNums();
		}
		info.setPayableAmt(payableAmt);
		info.setSimpleDiscountAmt(MoneyUtil.subtract(info.getPayableAmt(), info.getPayAmt()));
		info.setNums(nums);
		String costAmt = "";
		String saleAmt = "";
		String countAmt="";
		String oriPriceAmt="";
		for (OrderGood good : goodList) {
			String rate = String
					.valueOf(Double.parseDouble(good.getPayableAmt()) / Double.parseDouble(info.getPayableAmt()));
			good.setCashAmt(MoneyUtil.multiply(info.getPayAmt(), rate));
			good.setPayAmt(MoneyUtil.multiply(info.getPayAmt(), rate));
			good.setCountAmt(MoneyUtil.multiply(good.getNowPrice(), String.valueOf(good.getNums())));
			good.setOriPriceAmt(MoneyUtil.multiply(good.getSalePrice(), String.valueOf(good.getNums())));
			good.setSimpleDiscountAmt(MoneyUtil.multiply(info.getSimpleDiscountAmt(), rate));
			good.setSaleAmt(MoneyUtil.subtract(good.getCountAmt(), good.getPayAmt()));
			good.setGoodManDiscountAmt(MoneyUtil.subtract(good.getCountAmt(), good.getPayableAmt()));
			good.setSimpleDiscountAmt(MoneyUtil.add(good.getSimpleDiscountAmt(), good.getGoodManDiscountAmt()));
			BigDecimal payRate = new BigDecimal(rate);
			payRate = payRate.setScale(6, BigDecimal.ROUND_HALF_UP);
			good.setPayRate(payRate.toString());
			stock(info.getOrgId(), good, stockList);
			costAmt = MoneyUtil.add(costAmt, good.getCostAmt());
			saleAmt = MoneyUtil.add(saleAmt, good.getSaleAmt());
			countAmt=MoneyUtil.add(countAmt, good.getCountAmt());
			oriPriceAmt = MoneyUtil.add(oriPriceAmt, good.getOriPriceAmt());
		}
		info.setSaleAmt(saleAmt);
		info.setCostAmt(costAmt);
		info.setCountAmt(countAmt);
		info.setOriPriceAmt(oriPriceAmt);

	}

	private List<StockBatch> stock(String orgId, OrderGood good, List<StockBatch> stockList) {
		List<StockBatch> stock = stockBatchService.getStockBatchByGoodIdAndNums(orgId, good);
		if(null !=stock && stock.size()>0){
			good.setCostPrice(stock.get(0).getCostPrice());
			good.setCostAmt(MoneyUtil.multiply(good.getCostPrice(), String.valueOf(good.getNums())));
			stockList.addAll(stock);
		}
		return stock;
	}
	
}