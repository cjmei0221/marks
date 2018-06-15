package com.marks.module.mall.stock.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.stock.dao.BarCodeDao;
import com.marks.module.mall.stock.dao.TraceDao;
import com.marks.module.mall.stock.dao.TraceLogDao;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.pojo.Trace;
import com.marks.module.mall.stock.pojo.TraceLog;
import com.marks.module.mall.stock.service.BarCodeService;

@Service
@Transactional
public class BarCodeServiceImpl implements BarCodeService {
	private static Logger logger = Logger.getLogger(BarCodeServiceImpl.class);
	@Autowired
	private BarCodeDao barCodeDao;
	@Autowired
	private TraceLogDao traceLogDao;
	@Autowired
	private TraceDao traceDao;

	/**
	 * private BarCodeDao barCodeDao;
	 * 
	 * public BarCodeDao getBarCodeDao(){ return barCodeDao; } public void
	 * setBarCodeDao(BarCodeDao barCodeDao){ this.barCodeDao =barCodeDao; }
	 * 
	 */
	/**
	 * 根据ID查找条码管理
	 */
	@Override
	public BarCode findById(String id) {
		return barCodeDao.findById(id);
	}

	/**
	 * 首次入库
	 */
	public Result saveBarCode(StockBatch info, GoodInfo good) {
		String batchId = info.getBatchId();
		Result result = new Result();
		int nums = info.getNums();
		List<String> codeList = barCodeDao.getInvalidCode();
		int hasNums = 0;
		if (null != codeList && codeList.size() > 0) {
			hasNums = codeList.size();
		}
		long initcode = 0;
		if (hasNums < nums) {
			String maxCode = barCodeDao.getMaxCode();
			if (null != maxCode && maxCode.length() > 4) {
				
			} else {
				maxCode = "100000";
			}
			initcode = Long.parseLong(maxCode);
		}
		logger.info("save 条码信息：" + hasNums + " - " + initcode + " - " + nums);
		Trace vo = null;
		BarCode code = null;
		// 库存状态
		int stockStatus = StockEnums.StockStatus.stockIn.getValue();
		List<BarCode> codelist = new ArrayList<BarCode>();
		List<Trace> tracelist = new ArrayList<Trace>();
		List<TraceLog> loglist = new ArrayList<TraceLog>();
		boolean updateFlag = false;
		for (int i = 0; i < nums; i++) {
			String barCode = "";
			if (hasNums > 0 && hasNums >= nums) {
				updateFlag = true;
				barCode = codeList.get(i);
			} else {
				barCode = String.valueOf(initcode + (i + 1));
			}
			String traceId = barCode + "_" + IDUtil.getSecondID() + IDUtil.getRandom(1000, 9999)
					+ IDUtil.getRandom(1000, 9999);
			code = new BarCode();
			code.setBatchId(batchId);
			code.setActiveStatus(1);
			code.setBarcode(barCode);
			code.setBarNo(good.getBarNo());
			code.setCompanyId(info.getCompanyId());
			code.setGoodId(info.getGoodId());
			code.setGoodName(good.getGoodName());
			code.setGoodNo(good.getGoodNo());
			code.setOrgid(info.getOrgId());
			code.setOrgname(info.getOrgName());
			code.setProductDate(info.getProductDate());
			code.setStockStatus(stockStatus);
			code.setTraceId(traceId);
			code.setBeforeWarnDays(good.getBeforeWarnDays());
			if (good.getValidDays() > 0) {
				code.setExpireDate(DateUtil.getAfterDateByDays(code.getProductDate(), good.getValidDays()));
			}
			code.setIsWarnDays(good.getIsWarnDays());
			code.setTypeId(good.getTypeId());
			code.setTypeName(good.getTypeName());
			code.setBrandId(good.getBrandId());
			code.setBrandName(good.getBrandName());
			code.setCostPrice(info.getCostPrice());
			code.setOperator(info.getOperator());
			code.setTradePrice(code.getCostPrice());
			codelist.add(code);

			// 追踪记录
			vo = new Trace();
			vo.setBatchId(batchId);
			vo.setBarcode(barCode);
			vo.setBarNo(good.getBarNo());
			vo.setBrandId(good.getBrandId());
			vo.setBrandName(good.getBrandName());
			vo.setCgNo(info.getOrderId());
			vo.setCompanyId(info.getCompanyId());
			vo.setGoodId(info.getGoodId());
			vo.setGoodName(good.getGoodName());
			vo.setGoodNo(good.getGoodNo());
			vo.setIsGift(0);
			vo.setOrgid(info.getOrgId());
			vo.setOrgname(info.getOrgName());
			vo.setPrice(good.getSalePrice());
			vo.setProductDate(info.getProductDate());
			vo.setSalePrice(good.getSalePrice());
			vo.setStockInDate(DateUtil.parseDate(new Date(), "yyyy-MM-dd"));
			vo.setCostPrice(info.getCostPrice());
			vo.setStockStatus(stockStatus);
			vo.setSupplierId(info.getSupplierId());
			vo.setSupplierName(info.getSupplierName());
			vo.setTraceId(traceId);
			vo.setTypeId(good.getTypeId());
			vo.setTypeName(good.getTypeName());
			vo.setExpireDate(code.getExpireDate());
			vo.setTradePrice(code.getTradePrice());
			tracelist.add(vo);
			TraceLog log = getTraceLog(code);
			loglist.add(log);
		}
		logger.info("save 条码信息 updateFlag：" + updateFlag);
		if (updateFlag) {
			// List<String> blist = new ArrayList<String>();
			for (BarCode b : codelist) {
				// blist.add(b.getBarcode());
				barCodeDao.update(b);
			}
			// barCodeDao.deleteBatch(blist);
			// // barCodeDao.updateBatch(codelist);
			// barCodeDao.saveBatch(codelist);
		} else {
			barCodeDao.saveBatch(codelist);
		}
		traceDao.saveBatch(tracelist);
		traceLogDao.saveBatch(loglist);
		return result;
	}

	@Override
	public void updateBarCodeStockOut(List<BarCode> list) {
		if (null != list && list.size() > 0) {
			for (BarCode barCode : list) {
				barCode.setActiveStatus(0);
				barCode.setUpdatetime(DateUtil.getCurrDateStr());
				barCode.setStockStatus(StockEnums.StockStatus.stockOut.getValue());
				barCode.setEndDate(DateUtil.getCurrDateStr().substring(0, 10));
				updateTrace(barCode);
			}
		}

	}

	private void updateTrace(BarCode vo) {
		barCodeDao.update(vo);
		Trace trace = new Trace();
		trace.setEndDate(vo.getEndDate());
		trace.setMobile(vo.getMobile());
		trace.setOrderId(vo.getOrderId());
		trace.setOrderGoodId(vo.getOrderGoodId());
		trace.setOrgid(vo.getOrgid());
		trace.setOrgname(vo.getOrgname());
		trace.setPrice(vo.getPrice());
		trace.setSalePrice(vo.getSalePrice());
		trace.setStockStatus(vo.getStockStatus());
		trace.setUserid(vo.getUserid());
		trace.setUsername(vo.getUsername());
		trace.setMobile(vo.getMobile());
		trace.setTraceId(vo.getTraceId());
		traceDao.update(trace);
		TraceLog log = getTraceLog(vo);
		log.setAmount(vo.getSalePrice());
		traceLogDao.save(log);
	}

	private TraceLog getTraceLog(BarCode vo) {
		TraceLog log = new TraceLog();
		log.setBatchId(vo.getBatchId());
		log.setOperateCode(StockEnums.OperateCode.barCode.getValue());
		log.setOperate(StockEnums.OperateCode.barCode.getName());
		log.setBarCode(vo.getBarcode());
		log.setBarNo(vo.getBarNo());
		log.setBrandId(vo.getBrandId());
		log.setBrandName(vo.getBrandName());
		log.setCompanyId(vo.getCompanyId());
		log.setGoodId(vo.getGoodId());
		log.setGoodName(vo.getGoodName());
		log.setGoodNo(vo.getGoodNo());
		log.setId(IDUtil.getUUID());
		log.setOperator(vo.getOperator());
		log.setOrgid(vo.getOrgid());
		log.setOrgname(vo.getOrgname());
		log.setStockStatus(vo.getStockStatus());
		log.setRemarks(StockEnums.StockStatus.getByKey(log.getStockStatus()));
		log.setTraceId(vo.getTraceId());
		log.setTypeId(vo.getTypeId());
		log.setTypeName(vo.getTypeName());
		log.setAmount(vo.getCostPrice());
		log.setNums(1);
		return log;
	}

	/**
	 * 更新条码管理
	 */
	@Override
	public void update(BarCode info) {
		barCodeDao.update(info);
	}

	/**
	 * 删除条码管理
	 */
	@Override
	public void delete(String id) {
		barCodeDao.delete(id);
	}

	/**
	 * 查找所有条码管理
	 */
	@Override
	public List<BarCode> findAll() {
		return barCodeDao.findAll();
	}

	/**
	 * 删除多个条码管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		barCodeDao.deleteBatch(ids);
	}

	public PojoDomain<BarCode> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<BarCode> pojoDomain = new PojoDomain<BarCode>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<BarCode> list = barCodeDao.list(pageBounds, param);
		PageList<BarCode> pageList = (PageList<BarCode>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<BarCode> getBarCodeListByBarCodes(List<String> barCodeList) {
		return barCodeDao.getBarCodeListByBarCodes(barCodeList);
	}

}