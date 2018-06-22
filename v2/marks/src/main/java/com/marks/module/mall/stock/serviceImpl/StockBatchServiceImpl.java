package com.marks.module.mall.stock.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.common.enums.StockEnums;
import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.module.mall.good.dao.GoodInfoDao;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.pojo.OrderInfo;
import com.marks.module.mall.stock.dao.StockBatchDao;
import com.marks.module.mall.stock.dao.TraceLogDao;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.pojo.StockBatchForm;
import com.marks.module.mall.stock.pojo.StockInfo;
import com.marks.module.mall.stock.pojo.TraceLog;
import com.marks.module.mall.stock.service.BarCodeService;
import com.marks.module.mall.stock.service.StockBatchService;
import com.marks.module.mall.stock.service.StockInfoService;

@Service
@Transactional
public class StockBatchServiceImpl implements StockBatchService {

	@Autowired
	private BarCodeService barCodeService;
	@Autowired
	private TraceLogDao traceLogDao;

	@Autowired
	private GoodInfoDao goodInfoDao;

	@Autowired
	private StockInfoService stockInfoService;
	@Autowired
	private StockBatchDao stockBatchDao;

	/**
	 * private StockBatchDao stockBatchDao;
	 * 
	 * public StockBatchDao getStockBatchDao(){ return stockBatchDao; } public
	 * void setStockBatchDao(StockBatchDao stockBatchDao){ this.stockBatchDao
	 * =stockBatchDao; }
	 * 
	 */
	/**
	 * 根据ID查找库存批次
	 */
	@Override
	public StockBatch findById(String id) {
		return stockBatchDao.findById(id);
	}


	public PojoDomain<StockBatch> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<StockBatch> pojoDomain = new PojoDomain<StockBatch>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<StockBatch> list = stockBatchDao.list(pageBounds, param);
		PageList<StockBatch> pageList = (PageList<StockBatch>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	public String getBatchId() {
		return "B-" + IDUtil.getDateID() + "-" + IDUtil.getID(8);
	}

	@Override
	public Result saveFirstStockIn(StockBatchForm info) {
		Result result = new Result();
		int nums = info.getNums();
		if (nums > 0) {
			GoodInfo good = goodInfoDao.findById(info.getGoodId());
			String batchId = getBatchId();
			// 保存批次
			StockBatch b = new StockBatch();
			b.setAmount(MoneyUtil.multiply(info.getCostPrice(), String.valueOf(info.getNums())));
			b.setBarNo(good.getBarNo());
			b.setBatchId(batchId);
			b.setCompanyId(info.getCompanyId());
			b.setGoodId(good.getGoodId());
			b.setGoodName(good.getGoodName());
			b.setGoodNo(good.getGoodNo());
			b.setNums(info.getNums());
			b.setOrgId(info.getOrgid());
			b.setOrgName(info.getOrgname());
			b.setProductDate(info.getProductDate());
			b.setRemarks(StockEnums.StockManageType.getByKey(info.getStockManageType()) + " 入库");
			b.setCostPrice(info.getCostPrice());
			b.setStockType(info.getStockManageType());
			b.setSupplierId(info.getSupplierId2());
			b.setSupplierName(info.getSupplier2());
			b.setUpdater(info.getOperator());
			b.setYwCode(info.getYwCode());
			b.setGoodType(StockEnums.GoodType.good.getValue());
			if (good.getValidDays() > 0) {
				b.setExpireDate(DateUtil.getAfterDateByDays(info.getProductDate(), good.getValidDays()));
			}
			b.setBalAmt(b.getAmount());
			b.setBalNums(b.getNums());
			b.setTranAmt(b.getAmount());
			b.setTranNums(b.getNums());
			b.setTranStatus(StockEnums.StockStatus.stockIn.getValue());
			b.setTradePrice(info.getDispatchPrice());
			b.setTradePriceAmt(MoneyUtil.multiply(b.getTradePrice(), String.valueOf(info.getNums())));
			b.setOrderId(info.getOrderId());
			b.setOperator(info.getOperator());
			dealStock(b);
			// 更新商品进货价和供应商
			good.setCostPrice(info.getCostPrice());
			good.setStockManageType(info.getStockManageType());
			good.setSupplier(info.getSupplier2());
			good.setSupplierId(info.getSupplierId2());
			goodInfoDao.update(good);

			// 一品一码
			if (StockEnums.StockManageType.simple.getValue() == info.getStockManageType()) {
				barCodeService.saveBarCode(b, good);
			}
		}
		return result;
	}

	public List<StockBatch> getStockBatchByGood(OrderInfo order, OrderGood good) {
		List<StockBatch> returnList = null;
		int nums = good.getNums();// 减去条码的数量
		List<StockBatch> list = new ArrayList<StockBatch>();
		// 一瓶一码管理
		if (null != good.getBarCodeList() && good.getBarCodeList().size() > 0) {
			List<StockBatch> barlist = getStockBatchByBarCodeList(good);
			if (null != barlist && barlist.size() > 0) {
				list.addAll(barlist);
				for (StockBatch b : barlist) {
					nums = nums - b.getTranNums();
				}
			}
		}
		// 数量管理
		if (nums > 0) {
			List<StockBatch> numslist = getStockBatchByNums(order.getOrgId(), good.getGoodId(), nums);
			if (null != numslist && numslist.size() > 0) {
				list.addAll(numslist);
				for (StockBatch b : numslist) {
					nums = nums - b.getTranNums();
				}
			}
		}
		// 负卖
		if (nums > 0) {
			List<StockBatch> lesslist = getlessStockList(order, good, nums);
			list.addAll(lesslist);
		}

		returnList = countStockBatch(good, list);

		return returnList;
	}

	private List<StockBatch> getlessStockList(OrderInfo order, OrderGood good, int nums) {
		List<StockBatch> list = new ArrayList<StockBatch>();
		String salePrice = MoneyUtil.divide(good.getPayAmt(), String.valueOf(good.getNums()));
		StockBatch b = new StockBatch();
		b.setAmount("0");
		b.setBalAmt("0");
		b.setBalNums(0);
		b.setBarNo(good.getBarNo());
		b.setBatchId(getBatchId());
		b.setBrandId(good.getBrandId());
		b.setBrandName(good.getBrandName());
		b.setCompanyId(good.getCompanyId());
		b.setCostPrice(good.getCostPrice());
		b.setGoodId(good.getGoodId());
		b.setGoodName(good.getGoodName());
		b.setGoodNo(good.getGoodNo());
		b.setNums(0);
		b.setOperator(order.getCashMan());
		b.setOrgId(order.getOrgId());
		b.setOrgName(order.getOrgName());
		b.setRemarks("负卖，库存不足");
		b.setSaleAmount("");
		b.setSaleNums(0);
		b.setStockType(StockEnums.StockManageType.nums.getValue());
		b.setTradePrice(b.getCostPrice());
		b.setTradePriceAmt(b.getAmount());
		b.setTranAmt(MoneyUtil.multiply(nums + "", good.getCostPrice()));
		b.setTranNums(nums);
		b.setTranSaleAmt(MoneyUtil.multiply(nums + "", salePrice));
		b.setTranStatus(StockEnums.StockStatus.stockOut.getValue());
		b.setGoodType(StockEnums.GoodType.good.getValue());
		b.setTypeId(good.getTypeId());
		b.setTypeName(good.getTypeName());
		b.setYwCode(StockEnums.YwCode.sale_stockOut.getValue());
		list.add(b);
		return list;
	}

	private List<StockBatch> getStockBatchByBarCodeList(OrderGood good) {
		List<StockBatch> list = stockBatchDao.getStockBatchByBarCodeList(good.getBarCodeList());
		return list;
	}

	private List<StockBatch> countStockBatch(OrderGood good, List<StockBatch> list) {
		List<StockBatch> returnList = null;
		if (null != list && list.size() > 0) {
			String costAmt = "";
			int totalBatchNums = 0;
			returnList = new ArrayList<StockBatch>();
			for (int i = 0; i < list.size(); i++) {
				StockBatch batch = list.get(i);
				String salePrice = MoneyUtil.divide(good.getPayAmt(), String.valueOf(good.getNums()));
				batch.setTranAmt(MoneyUtil.multiply(String.valueOf(batch.getTranNums()), batch.getCostPrice()));
				batch.setTranSaleAmt(MoneyUtil.multiply(String.valueOf(batch.getTranNums()), salePrice));
				costAmt = MoneyUtil.add(costAmt, batch.getTranAmt());
				batch.setBalAmt(MoneyUtil.subtract(batch.getBalAmt(), batch.getTranAmt()));
				batch.setBalNums(batch.getBalNums() - batch.getTranNums());
				batch.setSaleNums(batch.getSaleNums() + batch.getTranNums());
				batch.setSaleAmount(MoneyUtil.add(batch.getSaleAmount(), batch.getTranSaleAmt()));
				totalBatchNums = totalBatchNums + batch.getTranNums();
				returnList.add(batch);
			}
			costAmt = MoneyUtil.add(costAmt,
					MoneyUtil.multiply(good.getCostPrice(), String.valueOf(good.getNums() - totalBatchNums)));
			for (StockBatch batch : returnList) {
				batch.setCostPrice(MoneyUtil.divide(costAmt, String.valueOf(good.getNums())));
				batch.setTypeId(good.getTypeId());
				batch.setTypeName(good.getTypeName());
				batch.setBrandId(good.getBrandId());
				batch.setBrandName(good.getBrandName());
			}
		}
		return returnList;
	}


	public List<StockBatch> getStockBatchByNums(String orgId, String goodId, int nums) {
		List<StockBatch> list = stockBatchDao.getStockBatchByGoodIdAndOrgId(orgId, goodId);
		List<StockBatch> returnList = null;
		if (null != list && list.size() > 0) {
			returnList = new ArrayList<StockBatch>();
			for (int i = 0; i < list.size(); i++) {
				StockBatch batch = list.get(i);
				if (nums - batch.getBalNums() <= 0) {
					batch.setTranNums(nums);
					returnList.add(batch);
					break;
				} else {
					nums = nums - batch.getBalNums();
					batch.setTranNums(batch.getBalNums());
					returnList.add(batch);
				}
			}
		}
		return returnList;
	}

	@Override
	public void updateSaleOut(List<StockBatch> stockList, List<BarCode> barCodeList) {
		for (StockBatch batch : stockList) {
			batch.setTranStatus(StockEnums.StockStatus.stockOut.getValue());
			batch.setYwCode(StockEnums.YwCode.sale_stockOut.getValue());
			dealStock(batch);
		}
		if (null != barCodeList && barCodeList.size() > 0) {
			barCodeService.updateBarCodeStockOut(barCodeList);
		}
	}

	@Override
	public void updateStockOut(List<StockBatch> stockList, List<BarCode> barCodeList) {
		for (StockBatch batch : stockList) {
			batch.setTranStatus(StockEnums.StockStatus.stockOut.getValue());
			dealStock(batch);
		}
		if (null != barCodeList && barCodeList.size() > 0) {
			barCodeService.updateBarCodeStockOut(barCodeList);
		}
	}

	public void dealStock(StockBatch info) {
		// 减少库存
		StockInfo stock = new StockInfo();
		stock.setCompanyId(info.getCompanyId());
		stock.setGoodId(info.getGoodId());
		stock.setOrgId(info.getOrgId());
		stock.setOrgName(info.getOrgName());
		stock.setBarNo(info.getBarNo());
		stock.setGoodNo(info.getGoodNo());
		stock.setGoodName(info.getGoodName());
		if (StockEnums.StockStatus.stockIn.getValue() == info.getTranStatus()
				|| StockEnums.StockStatus.transferIn.getValue() == info.getTranStatus()) {
			stock.setStockAmount(info.getTranAmt());
			stock.setStockNums(info.getTranNums());
		} else {
			stock.setStockAmount("-" + info.getTranAmt());
			stock.setStockNums(-info.getTranNums());
		}
		if (StockEnums.YwCode.sale_stockOut.getValue() == info.getYwCode()) {
			stock.setSaleNums(info.getTranNums());
			stock.setSaleAmt(info.getTranSaleAmt());
		}
		String stockId = stockInfoService.save(stock);
		// 更新库存批次
		StockBatch ori = stockBatchDao.findById(info.getBatchId());
		if (ori == null) {
			info.setStockId(stockId);
			stockBatchDao.save(info);
		} else {
			stockBatchDao.update(info);
		}
		/*
		 * 保存日志
		 */
		TraceLog log = new TraceLog();
		log.setTraceId(info.getBatchId());
		log.setBatchId(info.getBatchId());
		log.setOperateCode(StockEnums.OperateCode.batch.getValue());
		log.setOperate(StockEnums.OperateCode.batch.getName());
		log.setBarNo(info.getBarNo());
		log.setBrandId(info.getBrandId());
		log.setBrandName(info.getBrandName());
		log.setCompanyId(info.getCompanyId());
		log.setGoodId(info.getGoodId());
		log.setGoodName(info.getGoodName());
		log.setGoodNo(info.getGoodNo());
		log.setId(IDUtil.getUUID());
		log.setOperator(info.getOperator());
		log.setOrgid(info.getOrgId());
		log.setOrgname(info.getOrgName());
		log.setStockStatus(info.getTranStatus());
		log.setRemarks(StockEnums.StockStatus.getByKey(log.getStockStatus()));
		log.setTypeId(info.getTypeId());
		log.setTypeName(info.getTypeName());
		log.setAmount(info.getTranAmt());
		log.setNums(info.getTranNums());
		log.setGoodType(info.getGoodType());
		log.setYwCode(info.getYwCode());
		log.setOrderId(info.getOrderId());
		traceLogDao.save(log);
	}
}