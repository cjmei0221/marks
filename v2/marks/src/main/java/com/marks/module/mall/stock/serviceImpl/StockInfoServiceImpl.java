package com.marks.module.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.util.number.MoneyUtil;
import com.marks.module.mall.stock.dao.StockInfoDao;
import com.marks.module.mall.stock.pojo.StockInfo;
import com.marks.module.mall.stock.service.StockInfoService;

@Service
@Transactional
public class StockInfoServiceImpl implements StockInfoService {

	@Autowired
	private StockInfoDao stockInfoDao;

	/**
	 * private StockInfoDao stockInfoDao;
	 * 
	 * public StockInfoDao getStockInfoDao(){ return stockInfoDao; } public void
	 * setStockInfoDao(StockInfoDao stockInfoDao){ this.stockInfoDao
	 * =stockInfoDao; }
	 * 
	 */
	/**
	 * 根据ID查找库存管理
	 */
	@Override
	public StockInfo findById(String id) {
		return stockInfoDao.findById(id);
	}

	/**
	 * 保存库存管理
	 */
	@Override
	public String save(StockInfo info) {
		String stockId = "";
		StockInfo ori = stockInfoDao.findByOrgIdAndGoodNo(info.getCompanyId(), info.getOrgId(), info.getGoodNo());
		boolean updateFlag = true;
		if (ori == null) {
			updateFlag = false;
			ori = new StockInfo();
			ori.setStockId("I-" + info.getCompanyId() + "-" + info.getOrgId() + "-" + info.getGoodNo());
			ori.setBarNo(info.getBarNo());
			ori.setCompanyId(info.getCompanyId());
			ori.setGoodId(info.getGoodId());
			ori.setGoodName(info.getGoodName());
			ori.setGoodNo(info.getGoodNo());
			ori.setOrgId(info.getOrgId());
			ori.setOrgName(info.getOrgName());
		}
		ori.setGiftAmount(MoneyUtil.add(ori.getGiftAmount(), info.getGiftAmount()));
		ori.setGiftNums(ori.getGiftNums() + info.getGiftNums());
		ori.setHoldAmount(MoneyUtil.add(ori.getHoldAmount(), info.getHoldAmount()));
		ori.setHoldNums(ori.getHoldNums() + info.getHoldNums());
		ori.setScrapAmount(MoneyUtil.add(ori.getScrapAmount(), info.getScrapAmount()));
		ori.setScrapNums(ori.getScrapNums() + info.getScrapNums());
		ori.setSecondAmount(MoneyUtil.add(ori.getSecondAmount(), info.getSecondAmount()));
		ori.setSecondNums(ori.getSecondNums() + info.getSecondNums());
		ori.setStockAmount(MoneyUtil.add(ori.getStockAmount(), info.getStockAmount()));
		ori.setStockNums(ori.getStockNums() + info.getStockNums());
		ori.setTotalAmount(MoneyUtil.add(ori.getGiftAmount(), ori.getHoldAmount()));
		ori.setTotalAmount(MoneyUtil.add(ori.getTotalAmount(), ori.getStockAmount()));
		ori.setTotalNums(ori.getGiftNums() + ori.getHoldNums() + ori.getStockNums());
		ori.setSaleAmt(MoneyUtil.add(ori.getSaleAmt(), info.getSaleAmt()));
		ori.setSaleNums(ori.getSaleNums() + info.getSaleNums());
		ori.setUpdatetime(info.getUpdatetime());
		if (updateFlag) {
			stockInfoDao.update(ori);
		} else {
			stockInfoDao.save(ori);
		}
		stockId = ori.getStockId();
		return stockId;
	}

	/**
	 * 更新库存管理
	 */
	@Override
	public void update(StockInfo info) {
		stockInfoDao.update(info);
	}

	/**
	 * 删除库存管理
	 */
	@Override
	public void delete(String id) {
		stockInfoDao.delete(id);
	}

	/**
	 * 查找所有库存管理
	 */
	@Override
	public List<StockInfo> findAll() {
		return stockInfoDao.findAll();
	}

	/**
	 * 删除多个库存管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		stockInfoDao.deleteBatch(ids);
	}

	public PojoDomain<StockInfo> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<StockInfo> pojoDomain = new PojoDomain<StockInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<StockInfo> list = stockInfoDao.list(pageBounds, param);
		PageList<StockInfo> pageList = (PageList<StockInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

}