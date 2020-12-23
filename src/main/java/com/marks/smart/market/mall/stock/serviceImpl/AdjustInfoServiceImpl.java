package com.marks.smart.market.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.Enums;
import com.marks.common.enums.StockAdjustEnums;
import com.marks.common.enums.StockEnums;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.smart.market.mall.stock.dao.AdjustGoodDao;
import com.marks.smart.market.mall.stock.dao.AdjustInfoDao;
import com.marks.smart.market.mall.stock.dao.StockInfoDao;
import com.marks.smart.market.mall.stock.pojo.AdjustGood;
import com.marks.smart.market.mall.stock.pojo.AdjustInfo;
import com.marks.smart.market.mall.stock.pojo.StockBatch;
import com.marks.smart.market.mall.stock.pojo.StockBatchForm;
import com.marks.smart.market.mall.stock.pojo.StockInfo;
import com.marks.smart.market.mall.stock.service.AdjustInfoService;
import com.marks.smart.market.mall.stock.service.StockBatchService;
import com.marks.smart.system.org.orginfo.pojo.OrgInfo;
import com.marks.smart.system.org.orginfo.service.OrgInfoService;

@Service
@Transactional
public class AdjustInfoServiceImpl implements AdjustInfoService {

	private static Logger logger = Logger.getLogger(AdjustInfoServiceImpl.class);

	@Autowired
	private AdjustInfoDao adjustInfoDao;
	@Autowired
	private OrgInfoService orgInfoService;
	@Autowired
	private AdjustGoodDao adjustGoodDao;
	@Autowired
	private StockBatchService stockBatchService;

	@Autowired
	private StockInfoDao stockInfoDao;

	/**
	 * private AdjustInfoDao adjustInfoDao;
	 * 
	 * public AdjustInfoDao getAdjustInfoDao(){ return adjustInfoDao; } public
	 * void setAdjustInfoDao(AdjustInfoDao adjustInfoDao){ this.adjustInfoDao
	 * =adjustInfoDao; }
	 * 
	 */
	/**
	 * 根据ID查找库存调整单
	 */
	@Override
	public AdjustInfo findById(String id) {
		logger.info("findById > param>" + id);
		return adjustInfoDao.findById(id);
	}

	/**
	 * 保存库存调整单
	 */
	@Override
	public void save(AdjustInfo info, List<AdjustGood> goodList) {
		logger.info("save > start>");
		if (null != info.getOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getOrgId());
			if (null != sendOrg) {
				info.setOrgName(sendOrg.getOrgname());
			}
		}
		saveAdjustGood(info, goodList);
		adjustInfoDao.save(info);
		logger.info("save > end>");
	}

	private void saveAdjustGood(AdjustInfo info, List<AdjustGood> goodList) {
		if (null != goodList && goodList.size() > 0) {
			adjustGoodDao.deleteByOrderId(info.getOrderId());
			for (AdjustGood good : goodList) {
				good.setCompanyId(info.getCompanyId());
				good.setOrderId(info.getOrderId());
				info.setTotalAmt(
						MoneyUtil.add(info.getTotalAmt(), MoneyUtil.add(good.getCostPrice(), good.getNums() + "")));
				info.setTotalNums(info.getTotalNums() + good.getNums());
			}
			adjustGoodDao.saveBatch(goodList);
		}
	}

	/**
	 * 更新库存调整单
	 */
	@Override
	public void update(AdjustInfo info, List<AdjustGood> goodList) {
		logger.info("update > start>");
		if (null != info.getOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getOrgId());
			if (null != sendOrg) {
				info.setOrgName(sendOrg.getOrgname());
			}
		}
		info.setCreateDate(DateUtil.getCurrDateStr().substring(0, 10));
		saveAdjustGood(info, goodList);
		adjustInfoDao.update(info);
		logger.info("update > end>");
	}

	/**
	 * 删除库存调整单
	 */
	@Override
	public void delete(String id) {
		logger.info("delete > start> params >" + id);
		adjustInfoDao.delete(id);
	}

	/**
	 * 查找所有库存调整单
	 */
	@Override
	public List<AdjustInfo> findAll() {
		logger.info("findAll > start> params >");
		return adjustInfoDao.findAll();
	}

	/**
	 * 删除多个库存调整单
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		logger.info("deleteBatch > start> params >" + ids);
		adjustInfoDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >" + ids);
	}

	public PojoDomain<AdjustInfo> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<AdjustInfo> pojoDomain = new PojoDomain<AdjustInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AdjustInfo> list = adjustInfoDao.list(pageBounds, param);
		PageList<AdjustInfo> pageList = (PageList<AdjustInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public void updateCheckStatus(Map<String, String> map) {
		adjustInfoDao.updateCheckStatus(map);
		String checkStatus = map.get("checkStatus");
		AdjustInfo info = adjustInfoDao.findById(map.get("idNo"));
		// 审核通过处理库存
		if (Enums.CheckStatus.checkOk.toString().equals(checkStatus)) {
			List<AdjustGood> list = adjustGoodDao.findByOrderId(map.get("idNo"));
			if (null != list && list.size() > 0) {
				StockInfo stock = null;
				int nums = 0;
				for (AdjustGood good : list) {
					if(StockAdjustEnums.TypeCode.typeCode_3.getValue().equals(info.getTypeCode())) {
						StockBatchForm batch = new StockBatchForm();
						batch.setCompanyId(info.getCompanyId());
						batch.setCostPrice(good.getCostPrice());
						batch.setGoodId(good.getGoodId());
						batch.setNums(good.getNums());
						batch.setOperator(info.getCreatorName());
						batch.setOrderId(info.getOrderId());
						batch.setOrgid(info.getOrgId());
						batch.setOrgname(info.getOrgName());
						batch.setProductDate(DateUtil.getCurrDateStr().substring(0, 10));
						batch.setStockManageType(StockEnums.StockManageType.nums.getValue());
						batch.setSupplier2("");
						batch.setSupplierId2("");
						batch.setYwCode(StockEnums.YwCode.dz_stockIn.getValue());
						batch.setStockStatus(StockEnums.StockStatus.stockIn.getValue());
						
						batch.setStockType(StockEnums.StockType.scrap.getValue());
						batch.setRemarks(info.getTypeName()+"调整入库");
						stockBatchService.saveFirstStockIn(batch);
						//正品库出库
						List<StockBatch> stocklist = stockBatchService.getStockBatchByNums(batch.getOrgid(),
								batch.getGoodId(), batch.getNums(),StockEnums.StockType.good.getValue());
						if (null != stocklist && stocklist.size() > 0) {
							for (StockBatch vo : stocklist) {
								vo.setTranAmt(MoneyUtil.multiply(String.valueOf(vo.getTranNums()), vo.getCostPrice()));
								vo.setYwCode(StockEnums.YwCode.dz_stockOut.getValue());
								vo.setTranOutAmt("0.00");
							}
							stockBatchService.updateStockOut(stocklist, null);
						}
					}else {//库存调整
						nums = good.getNums();
						stock = stockInfoDao.findByOrgIdAndGoodNo(info.getCompanyId(), info.getOrgId(), good.getGoodNo());
						if (stock != null) {
							nums = nums - stock.getStockNums();
						}
						// 差异库存不为0，则需调整库存,大于0加库存 小于0减库存
						if (nums > 0) {
							StockBatchForm batch = new StockBatchForm();
							batch.setCompanyId(info.getCompanyId());
							batch.setCostPrice(good.getCostPrice());
							batch.setGoodId(good.getGoodId());
							batch.setNums(nums);
							batch.setOperator(info.getCreatorName());
							batch.setOrderId(info.getOrderId());
							batch.setOrgid(info.getOrgId());
							batch.setOrgname(info.getOrgName());
							batch.setProductDate(DateUtil.getCurrDateStr().substring(0, 10));
							batch.setStockManageType(StockEnums.StockManageType.nums.getValue());
							batch.setSupplier2("");
							batch.setSupplierId2("");
							batch.setYwCode(StockEnums.YwCode.dz_stockIn.getValue());
							batch.setStockStatus(StockEnums.StockStatus.stockIn.getValue());
							batch.setRemarks("库存调整入库");
							batch.setStockType(StockEnums.StockType.good.getValue());
							stockBatchService.saveFirstStockIn(batch);
						} else if (nums < 0) {
							StockBatchForm batch = new StockBatchForm();
							batch.setCompanyId(info.getCompanyId());
							batch.setCostPrice(good.getCostPrice());
							batch.setGoodId(good.getGoodId());
							batch.setNums(-nums);
							batch.setOperator(info.getCreatorName());
							batch.setOrderId(info.getOrderId());
							batch.setOrgid(info.getOrgId());
							batch.setOrgname(info.getOrgName());
							batch.setProductDate(DateUtil.getCurrDateStr().substring(0, 10));
							batch.setStockManageType(StockEnums.StockManageType.nums.getValue());
							batch.setSupplier2("");
							batch.setSupplierId2("");
							batch.setYwCode(StockEnums.YwCode.dz_stockOut.getValue());
							batch.setStockStatus(StockEnums.StockStatus.stockOut.getValue());
							batch.setRemarks("库存调整入库");
							// stockBatchService.saveFirstStockIn(batch);

							List<StockBatch> stocklist = stockBatchService.getStockBatchByNums(batch.getOrgid(),
									batch.getGoodId(), batch.getNums(),StockEnums.StockType.good.getValue());
							if (null != stocklist && stocklist.size() > 0) {
								for (StockBatch vo : stocklist) {
									vo.setTranAmt(MoneyUtil.multiply(String.valueOf(vo.getTranNums()), vo.getCostPrice()));
									vo.setYwCode(StockEnums.YwCode.dz_stockOut.getValue());
									vo.setTranOutAmt("0.00");
								}
								stockBatchService.updateStockOut(stocklist, null);
							}
						}
					}
				}
			}
		}
	}

}