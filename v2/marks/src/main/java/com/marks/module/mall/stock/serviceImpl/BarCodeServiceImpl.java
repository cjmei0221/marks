package com.marks.module.mall.stock.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
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
import com.marks.module.mall.good.dao.GoodInfoDao;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.stock.dao.BarCodeDao;
import com.marks.module.mall.stock.dao.TraceDao;
import com.marks.module.mall.stock.dao.TraceLogDao;
import com.marks.module.mall.stock.pojo.BarCode;
import com.marks.module.mall.stock.pojo.BarCodeForm;
import com.marks.module.mall.stock.pojo.Trace;
import com.marks.module.mall.stock.pojo.TraceLog;
import com.marks.module.mall.stock.service.BarCodeService;

@Service
@Transactional
public class BarCodeServiceImpl implements BarCodeService {

	@Autowired
	private BarCodeDao barCodeDao;
	@Autowired
	private TraceLogDao traceLogDao;
	@Autowired
	private TraceDao traceDao;

	@Autowired
	private GoodInfoDao goodInfoDao;

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
	 * 保存条码管理
	 * 
	 * @throws Exception
	 */
	@Override
	public Result save(BarCodeForm info) throws Exception {
		Result result = new Result();
		int nums = info.getNums();
		if (nums > 0) {

			GoodInfo good = goodInfoDao.findById(info.getGoodId());
			List<String> codeList = barCodeDao.getInvalidCode();
			int hasNums = 0;
			if (null != codeList && codeList.size() > 0) {
				hasNums = codeList.size();
			}
			long initcode = 0;
			if (hasNums < nums) {
				String maxCode = barCodeDao.getMaxCode();
				if (null == maxCode) {
					maxCode = "1000";
				}
				initcode = Long.parseLong(maxCode);
			}
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
				if (hasNums > 0 && hasNums > nums) {
					updateFlag = true;
					barCode = codeList.get(0);
				} else {
					barCode = String.valueOf(initcode + i);
				}
				String traceId = barCode + "_" + IDUtil.getSecondID() + IDUtil.getRandom(1000, 9999)
						+ IDUtil.getRandom(1000, 9999);
				code = new BarCode();
				code.setActiveStatus(1);
				code.setBarcode(barCode);
				code.setBarNo(good.getBarNo());
				code.setCompanyId(info.getCompanyId());
				code.setGoodId(info.getGoodId());
				code.setGoodName(info.getCompanyId());
				code.setGoodNo(good.getGoodNo());
				code.setOrgid(info.getOrgid());
				code.setOrgname(info.getOrgname());
				code.setProductDate(info.getProductDate());
				code.setStockStatus(stockStatus);
				code.setTraceId(traceId);
				code.setBeforeWarnDays(good.getBeforeWarnDays());
				if (good.getValidDays() > 0) {
					code.setExpireDate(DateUtil.getAfterDateByDays(code.getProductDate(), good.getValidDays()));
				}
				code.setIsWarnDays(good.getIsWarnDays());
				codelist.add(code);

				// 追踪记录
				vo = new Trace();
				vo.setBarcode(barCode);
				vo.setBarNo(good.getBarNo());
				vo.setBrandId(good.getBrandId());
				vo.setBrandName(good.getBrandName());
				vo.setCgNo(info.getCgNo());
				vo.setCompanyId(info.getCompanyId());
				vo.setGoodId(info.getGoodId());
				vo.setGoodName(good.getGoodName());
				vo.setGoodNo(good.getGoodNo());
				vo.setIsGift(0);
				vo.setOrgid(info.getOrgid());
				vo.setOrgname(info.getOrgname());
				vo.setPrice(good.getPrice());
				vo.setProductDate(info.getProductDate());
				vo.setSalePrice(good.getSalePrice());
				vo.setStockInDate(DateUtil.parseDate(new Date(), "yyyy-MM-dd"));
				vo.setStockPrice(info.getStockPrice());
				vo.setStockStatus(stockStatus);
				vo.setSupplierId(good.getSupplierId());
				vo.setSupplierName(good.getSupplier());
				vo.setTraceId(traceId);
				vo.setTypeId(good.getTypeId());
				vo.setTypeName(good.getTypeName());
				vo.setVipPrice(good.getVipPrice());
				vo.setExpireDate(code.getExpireDate());
				tracelist.add(vo);

				TraceLog log = new TraceLog();
				log.setBarCode(code.getBarcode());
				log.setBarNo(vo.getBarNo());
				log.setBrandId(vo.getBrandId());
				log.setBrandName(vo.getBrandName());
				log.setCompanyId(vo.getCompanyId());
				log.setGoodId(vo.getGoodId());
				log.setGoodName(vo.getGoodName());
				log.setGoodNo(vo.getGoodNo());
				log.setId(IDUtil.getUUID());
				log.setOperator(info.getOperator());
				log.setOrgid(vo.getOrgid());
				log.setOrgname(vo.getOrgname());
				log.setRemarks(StockEnums.StockStatus.stockIn.getName());
				log.setStockStatus(stockStatus);
				log.setTraceId(vo.getTraceId());
				log.setTypeId(vo.getTypeId());
				log.setTypeName(vo.getTypeName());
				loglist.add(log);
			}
			if (updateFlag) {
				barCodeDao.updateBatch(codelist);
			} else {
				barCodeDao.saveBatch(codelist);
			}
			traceDao.saveBatch(tracelist);
			traceLogDao.saveBatch(loglist);
		}
		return result;
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

}