package com.marks.module.mall.stock.serviceImpl;

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
import com.marks.module.mall.stock.dao.StockBatchDao;
import com.marks.module.mall.stock.dao.TraceLogDao;
import com.marks.module.mall.stock.pojo.BarCodeForm;
import com.marks.module.mall.stock.pojo.StockBatch;
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

	/**
	 * 保存库存批次
	 */
	@Override
	public void save(StockBatch info) {
		stockBatchDao.save(info);
	}

	/**
	 * 更新库存批次
	 */
	@Override
	public void update(StockBatch info) {
		stockBatchDao.update(info);
	}

	/**
	 * 删除库存批次
	 */
	@Override
	public void delete(String id) {
		stockBatchDao.delete(id);
	}

	/**
	 * 查找所有库存批次
	 */
	@Override
	public List<StockBatch> findAll() {
		return stockBatchDao.findAll();
	}

	/**
	 * 删除多个库存批次
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		stockBatchDao.deleteBatch(ids);
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

	@Override
	public Result saveFirstStockIn(BarCodeForm info) throws Exception {
		Result result = new Result();
		int nums = info.getNums();
		if (nums > 0) {
			GoodInfo good = goodInfoDao.findById(info.getGoodId());
			String batchId = "Batch_" + IDUtil.getDateID() + "_" + IDUtil.getID(8);
			// 添加库存
			StockInfo stock = new StockInfo();
			stock.setCompanyId(info.getCompanyId());
			stock.setGoodId(info.getGoodId());
			stock.setOrgId(info.getOrgid());
			stock.setOrgName(info.getOrgname());
			stock.setStockAmount(MoneyUtil.multiply(info.getStockPrice(), String.valueOf(info.getNums())));
			stock.setStockNums(info.getNums());
			stockInfoService.save(stock);
			// 保存批次
			StockBatch b = new StockBatch();
			b.setAmount(MoneyUtil.multiply(info.getStockPrice(), String.valueOf(info.getNums())));
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
			b.setStockPrice(info.getStockPrice());
			b.setStockType(info.getStockManageType());
			b.setSupplierId(info.getSupplierId2());
			b.setSupplierName(info.getSupplier2());
			b.setUpdater(info.getOperatorId() + "-" + info.getOperator());
			b.setYwCode(StockEnums.YwCode.good.getValue());
			if (good.getValidDays() > 0) {
				b.setExpireDate(DateUtil.getAfterDateByDays(info.getProductDate(), good.getValidDays()));
			}
			stockBatchDao.save(b);
			TraceLog log = new TraceLog();
			log.setTraceId(batchId);
			log.setBatchId(batchId);
			log.setOperateCode(StockEnums.OperateCode.batch.getValue());
			log.setOperate(StockEnums.OperateCode.batch.getName());
			log.setBarNo(good.getBarNo());
			log.setBrandId(good.getBrandId());
			log.setBrandName(good.getBrandName());
			log.setCompanyId(good.getCompanyId());
			log.setGoodId(good.getGoodId());
			log.setGoodName(good.getGoodName());
			log.setGoodNo(good.getGoodNo());
			log.setId(IDUtil.getUUID());
			log.setOperator(info.getOperator());
			log.setOrgid(info.getOrgid());
			log.setOrgname(info.getOrgname());
			log.setRemarks(StockEnums.StockStatus.stockIn.getName());
			log.setStockStatus(StockEnums.StockStatus.stockIn.getValue());
			log.setTypeId(good.getTypeId());
			log.setTypeName(good.getTypeName());
			log.setAmount(b.getAmount());
			log.setNums(b.getNums());
			traceLogDao.save(log);
			// 更新商品进货价和供应商
			good.setStockPrice(info.getStockPrice());
			good.setStockManageType(info.getStockManageType());
			good.setSupplier(info.getSupplier2());
			good.setSupplierId(info.getSupplierId2());
			goodInfoDao.update(good);

			// 数量管理
			if (StockEnums.StockManageType.simple.getValue() == info.getStockManageType()) {
				info.setBatchId(batchId);
				barCodeService.saveBarCode(info, good);
			}
		}
		return result;
	}


}