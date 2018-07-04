package com.marks.module.mall.dispatch.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.DispatchEnums;
import com.marks.common.enums.Enums;
import com.marks.common.enums.StockEnums;
import com.marks.common.util.date.DateUtil;
import com.marks.common.util.number.MoneyUtil;
import com.marks.module.mall.dispatch.dao.DispatchGoodDao;
import com.marks.module.mall.dispatch.dao.DispatchInfoDao;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.pojo.DispatchInfo;
import com.marks.module.mall.dispatch.service.DispatchInfoService;
import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.pojo.StockBatchForm;
import com.marks.module.mall.stock.service.StockBatchService;
import com.marks.module.org.orginfo.pojo.OrgInfo;
import com.marks.module.org.orginfo.service.OrgInfoService;

@Service("dispatchInfoService")
@Transactional
public class DispatchInfoServiceImpl implements DispatchInfoService {

	private static Logger logger = Logger.getLogger(DispatchInfoServiceImpl.class);
	@Autowired
	private OrgInfoService orgInfoService;
	@Autowired
	private DispatchInfoDao dispatchInfoDao;
	@Autowired
	private DispatchGoodDao dispatchGoodDao;
	@Autowired
	private StockBatchService stockBatchService;

	/**
	 * private DispatchInfoDao dispatchInfoDao;
	 * 
	 * public DispatchInfoDao getDispatchInfoDao(){ return dispatchInfoDao; }
	 * public void setDispatchInfoDao(DispatchInfoDao dispatchInfoDao){
	 * this.dispatchInfoDao =dispatchInfoDao; }
	 * 
	 */
	/**
	 * 根据ID查找采购单
	 */
	@Override
	public DispatchInfo findById(String id) {
		logger.info("findById > param>" + id);
		return dispatchInfoDao.findById(id);
	}

	/**
	 * 保存采购单
	 */
	@Override
	public void save(DispatchInfo info, List<DispatchGood> goodList) {
		logger.info("save > start>");
		info.setCashDate(DateUtil.getCurrDateStr().substring(0, 10));
		info.setCheckStatus(Enums.CheckStatus.noCheck.getValue());
		info.setCommitTime(DateUtil.getCurrDateStr());
		info.setI_month(Integer.parseInt(info.getCashDate().substring(5, 7)));
		info.setI_year(Integer.parseInt(info.getCashDate().substring(0, 4)));
		info.setI_season(DateUtil.getSeason(info.getI_month()));
		if (null != info.getSendOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getSendOrgId());
			if (null != sendOrg) {
				info.setSendOrgName(sendOrg.getOrgname());
			}
		}
		if (null != info.getReceiveOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getReceiveOrgId());
			if (null != sendOrg) {
				info.setReceiveOrgName(sendOrg.getOrgname());
			}
		}

		dealGood(info, goodList);
		dispatchInfoDao.save(info);
		logger.info("save > end>");
	}

	private void dealGood(DispatchInfo info, List<DispatchGood> goodList) {
		if (null != goodList && goodList.size() > 0) {
			for (DispatchGood good : goodList) {
				good.setCompanyId(info.getCompanyId());
				// good.setDispatchNums(good.getNums() + good.getSendNums());
				good.setPurchaseNums(good.getNums() + good.getSendNums());
				good.setOrderId(info.getOrderId());
				good.setPayableAmt(good.getAmt());
				good.setPayPrice(MoneyUtil.divide(good.getAmt(), good.getPurchaseNums() + ""));
				// good.setReceiveNums(good.getDispatchNums());
				good.setSaleAmt(MoneyUtil.multiply(good.getSalePrice(), good.getPurchaseNums() + ""));
				good.setUnpayAmt(MoneyUtil.subtract(good.getPayableAmt(), good.getPayAmt()));
				// info.setDispatchNums(dispatchNums);
				info.setPayableAmt(MoneyUtil.add(info.getPayableAmt(), good.getPayableAmt()));
				info.setPayAmt(MoneyUtil.add(good.getPayAmt(), good.getPayAmt()));
				info.setUnpayAmt(MoneyUtil.subtract(info.getPayableAmt(), info.getPayAmt()));
				// info.setReceiveNums(receiveNums);

				info.setSalesAmt(MoneyUtil.add(info.getSalesAmt(), good.getSaleAmt()));
				info.setSendNums(info.getSendNums() + good.getSendNums());

				info.setTotalAmt(MoneyUtil.add(info.getTotalAmt(), good.getAmt()));
				info.setTotalNums(info.getTotalNums() + good.getPurchaseNums());
			}
			saveDispatchGood(info.getOrderId(), goodList);
		}
	}

	private void saveDispatchGood(String orderId, List<DispatchGood> goodList) {
		dispatchGoodDao.deleteByOrderId(orderId);
		// for (DispatchGood good : goodList) {
		// dispatchGoodDao.save(good);
		// }
		dispatchGoodDao.saveBatch(goodList);
	}

	/**
	 * 更新采购单
	 */
	@Override
	public void update(DispatchInfo info, List<DispatchGood> goodList) {
		logger.info("update > start>");
		if (null != info.getSendOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getSendOrgId());
			if (null != sendOrg) {
				info.setSendOrgName(sendOrg.getOrgname());
			}
		}
		if (null != info.getReceiveOrgId()) {
			OrgInfo sendOrg = orgInfoService.findById(info.getReceiveOrgId());
			if (null != sendOrg) {
				info.setReceiveOrgName(sendOrg.getOrgname());
			}
		}
		dealGood(info, goodList);
		dispatchInfoDao.update(info);
		logger.info("update > end>");
	}

	/**
	 * 删除采购单
	 */
	@Override
	public void delete(String id) {
		logger.info("delete > start> params >" + id);
		dispatchInfoDao.delete(id);
		dispatchGoodDao.deleteByOrderId(id);
	}

	/**
	 * 查找所有采购单
	 */
	@Override
	public List<DispatchInfo> findAll() {
		logger.info("findAll > start> params >");
		return dispatchInfoDao.findAll();
	}

	/**
	 * 删除多个采购单
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		logger.info("deleteBatch > start> params >" + ids);
		dispatchInfoDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >" + ids);
	}

	public PojoDomain<DispatchInfo> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<DispatchInfo> pojoDomain = new PojoDomain<DispatchInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<DispatchInfo> list = dispatchInfoDao.list(pageBounds, param);
		PageList<DispatchInfo> pageList = (PageList<DispatchInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public void updateCheckStatus(Map<String, String> map) {
		dispatchInfoDao.updateCheckStatus(map);
	}

	@Override
	public void updateReceiveGood(DispatchInfo info, List<DispatchGood> goodList) {
		for (DispatchGood good : goodList) {
			good.setHadReceiveNums(good.getHadDispatchNums() + good.getReceiveNums());
			info.setReceiveNums(info.getReceiveNums() + good.getReceiveNums());
			dispatchGoodDao.updateRecevieNums(good.getOrderGoodId(), good.getReceiveNums());
			good.setOrderId(info.getOrderId());
			// 保存入库批次
			saveStockBatch(info, good);
		}
		int balNums = info.getTotalNums() - info.getReceiveNums() - info.getRefundNums();
		if (balNums <= 0) {
			info.setStatus(DispatchEnums.Status.end.getValue());
		} else {
			info.setStatus(DispatchEnums.Status.part.getValue());
		}
		dispatchInfoDao.updateRecevieNums(info);
	}

	private void saveStockBatch(DispatchInfo vo, DispatchGood good) {
		if (good.getNums() <= 0) {
			return;
		}
		StockBatchForm info = new StockBatchForm();
		info.setCompanyId(vo.getCompanyId());
		info.setCostPrice(good.getPayPrice());
		info.setGoodId(good.getGoodId());
		info.setNums(good.getReceiveNums());
		info.setOperator(vo.getCreator());
		info.setOrderId(vo.getOrderId());
		info.setOrgid(vo.getReceiveOrgId());
		info.setOrgname(vo.getReceiveOrgName());
		info.setProductDate(DateUtil.getCurrDateStr().substring(0, 10));
		info.setStockManageType(StockEnums.StockManageType.nums.getValue());
		info.setSupplier2(vo.getSendOrgName());
		info.setSupplierId2(vo.getSendOrgId());
		info.setYwCode(StockEnums.YwCode.cg_stockIn.getValue());
		info.setDispatchPrice(good.getPayPrice());
		logger.info("saveBarCode > param>" + info.getGoodId() + " - " + info.getNums());
		info.setStockStatus(StockEnums.StockStatus.stockIn.getValue());
		info.setRemarks("采购入库");
		stockBatchService.saveFirstStockIn(info);
	}

	@Override
	public void approveOk(Map<String, String> params) {
		params.put("checkStatus", Enums.CheckStatus.checkOk.toString());
		updateCheckStatus(params);
	}

	@Override
	public void approveFail(Map<String, String> params) {
		params.put("checkStatus", Enums.CheckStatus.checkFail.toString());
		updateCheckStatus(params);
	}

	@Override
	public void updateReceiveGoodForPh(DispatchInfo info, List<DispatchGood> goodList) {
		for (DispatchGood good : goodList) {
			good.setHadReceiveNums(good.getHadDispatchNums() + good.getReceiveNums());
			info.setReceiveNums(info.getReceiveNums() + good.getReceiveNums());
			dispatchGoodDao.updateRecevieNums(good.getOrderGoodId(), good.getReceiveNums());
			good.setOrderId(info.getOrderId());
			// 保存入库批次
			saveStockBatchForPh(info, good);
		}
		int balNums = info.getTotalNums() - info.getReceiveNums() - info.getRefundNums();
		if (balNums <= 0) {
			info.setStatus(DispatchEnums.Status.end.getValue());
		} else {
			info.setStatus(DispatchEnums.Status.part.getValue());
		}
		dispatchInfoDao.updateRecevieNums(info);
	}

	/**
	 * 调货收货
	 * 
	 * @param info
	 * @param good
	 */
	private void saveStockBatchForPh(DispatchInfo info, DispatchGood good) {
		List<StockBatch> list = stockBatchService.getStockBatchByNums(info.getSendOrgId(), good.getGoodId(),
				good.getReceiveNums());
		int nums = good.getReceiveNums();
		String costAmt = "";
		if (null != list && list.size() > 0) {
			for (StockBatch batch : list) {
				nums = nums - batch.getTranNums();
				batch.setTranAmt(MoneyUtil.multiply(String.valueOf(batch.getTranNums()), batch.getCostPrice()));
				costAmt = MoneyUtil.add(costAmt, batch.getTranAmt());
				batch.setBalAmt(MoneyUtil.subtract(batch.getBalAmt(), batch.getTranAmt()));
				batch.setBalNums(batch.getBalNums() - batch.getTranNums());
				batch.setYwCode(StockEnums.YwCode.dh_stockOut.getValue());
			}
			stockBatchService.updateStockOut(list, null);
		}
		// 防止库存不足
		if (nums > 0) {
			costAmt = MoneyUtil.add(costAmt, MoneyUtil.multiply(good.getCostPrice(), String.valueOf(nums)));
		}
		String costPrice = MoneyUtil.divide(costAmt, String.valueOf(good.getReceiveNums()));
		StockBatchForm batch = new StockBatchForm();
		batch.setCompanyId(info.getCompanyId());
		batch.setCostPrice(costPrice);
		batch.setGoodId(good.getGoodId());
		batch.setNums(good.getReceiveNums());
		batch.setOperator(info.getCreator());
		batch.setOrderId(info.getOrderId());
		batch.setOrgid(info.getReceiveOrgId());
		batch.setOrgname(info.getReceiveOrgName());
		batch.setProductDate(DateUtil.getCurrDateStr().substring(0, 10));
		batch.setStockManageType(StockEnums.StockManageType.nums.getValue());
		batch.setSupplier2(info.getSendOrgName());
		batch.setSupplierId2(info.getSendOrgId());
		batch.setYwCode(StockEnums.YwCode.dh_stockIn.getValue());
		batch.setDispatchPrice(good.getPayPrice());
		batch.setStockStatus(StockEnums.StockStatus.stockIn.getValue());
		batch.setRemarks("调货入库");
		stockBatchService.saveFirstStockIn(batch);
	}

}