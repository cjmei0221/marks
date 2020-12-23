package com.marks.smart.market.mall.good.serviceImpl;

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
import com.marks.common.util.IDUtil;
import com.marks.smart.market.mall.good.dao.GoodInfoDao;
import com.marks.smart.market.mall.good.dao.GoodPriceLogDao;
import com.marks.smart.market.mall.good.dao.GoodShopDao;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.pojo.GoodPriceLog;
import com.marks.smart.market.mall.good.pojo.GoodShop;
import com.marks.smart.market.mall.good.service.GoodShopService;
import com.marks.smart.system.org.orginfo.dao.OrgInfoDao;

@Service
@Transactional
public class GoodShopServiceImpl implements GoodShopService {

	private static Logger logger = Logger.getLogger(GoodShopServiceImpl.class);
	@Autowired
	private GoodInfoDao goodInfoDao;
	@Autowired
	private GoodShopDao goodShopDao;
	@Autowired
	private OrgInfoDao orgInfoDao;
	
	@Autowired
	private GoodPriceLogDao goodPriceLogDao;

	/**
	 * private GoodShopDao goodShopDao;
	 * 
	 * public GoodShopDao getGoodShopDao(){ return goodShopDao; } public void
	 * setGoodShopDao(GoodShopDao goodShopDao){ this.goodShopDao =goodShopDao; }
	 * 
	 */
	/**
	 * 根据ID查找门店商品
	 */
	@Override
	public GoodShop findById(String id) {
		logger.info("findById > param>" + id);
		return goodShopDao.findById(id);
	}

	@Override
	public void save(GoodShop info) {
		goodShopDao.save(info);
		savePriceLog( info);
	}

	/**
	 * 更新门店商品
	 */
	@Override
	public void update(GoodShop info) {
		logger.info("update > start>");
		goodShopDao.update(info);
		savePriceLog( info);
		logger.info("update > end>");
	}

	private void savePriceLog(GoodShop info) {
		GoodPriceLog log=new GoodPriceLog();
		log.setId(IDUtil.getNumID());
		log.setBatchId(IDUtil.getNumID());
		log.setCheckStatus(Enums.CheckStatus.noCheck.getValue());
		log.setCompanyId(info.getCompanyId());
		log.setCostPrice("");
		log.setCreator(info.getUpdater());
		
			log.setCreatorCode(info.getUpdaterCode());
	
		log.setDispatchPrice(info.getDispatchPrice());
		log.setGoodId(info.getGoodShopId());
		log.setGoodName(info.getGoodName());
		log.setGoodNo(info.getGoodNo());
		log.setMinPrice("");
		log.setRemarks("门店商品修改");
		log.setSalePrice(info.getSalePrice());
		log.setShopId(info.getShopId());
		log.setShopName(info.getShopName());
		log.setTradePrice("");
		log.setTypeCode(1);
		log.setTypeName("门店商品");
		log.setVipPrice(info.getVipPrice());
		log.setOnsale_status(info.getOnsale_status());
		goodPriceLogDao.save(log);
	}
	/**
	 * 删除门店商品
	 */
	@Override
	public void delete(String id) {
		logger.info("delete > start> params >" + id);
		goodShopDao.delete(id);
	}

	/**
	 * 查找所有门店商品
	 */
	@Override
	public List<GoodShop> findAll() {
		logger.info("findAll > start> params >");
		return goodShopDao.findAll();
	}

	public PojoDomain<GoodInfo> list(int page_number, int page_size, Map<String, Object> param) {
		logger.info("list > start>");
		PojoDomain<GoodInfo> pojoDomain = new PojoDomain<GoodInfo>();

		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<GoodInfo> list = null;

			list=goodShopDao.list(pageBounds, param);

		PageList<GoodInfo> pageList = (PageList<GoodInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public GoodShop findGoodShopByGoodNo(String companyId,String goodNo,String shopId) {
		List<GoodInfo> list=goodInfoDao.getGoodInfoByLike(companyId, goodNo);
		if(null != list && list.size()>0) {
			GoodInfo info=list.get(0);
			GoodShop sgood=goodShopDao.findById(shopId+info.getGoodNo());
			if(null == sgood) {
				sgood=new GoodShop();
				sgood.setGoodShopId(shopId+info.getGoodNo());
				sgood.setSalePrice(info.getSalePrice());
				sgood.setVipPrice(info.getVipPrice());
				sgood.setDispatchPrice(info.getDispatchPrice());
				sgood.setOnsale_status(info.getOnsale_status());
				sgood.setShopId(shopId);
				sgood.setShopName(info.getShopName());
				sgood.setGoodNo(info.getGoodNo());
				sgood.setGoodName(info.getGoodName());
			}
			return sgood;
		}
		return null;
	}

	@Override
	public GoodInfo findGoodInfoByGoodNo(String companyId, String goodNo, String shopId) {
		List<GoodInfo> list=goodInfoDao.getGoodInfoByLike(companyId, goodNo);
		if(null != list && list.size()>0) {
			GoodInfo info=list.get(0);
			GoodShop sgood=goodShopDao.findById(shopId+info.getGoodNo());
			if(null != sgood) {
				info.setGoodId(shopId+info.getGoodNo());
				info.setSalePrice(sgood.getSalePrice());
				info.setVipPrice(sgood.getVipPrice());
				info.setDispatchPrice(sgood.getDispatchPrice());
				info.setOnsale_status(sgood.getOnsale_status());
				info.setShopId(shopId);
				info.setShopName(sgood.getShopName());
			}
			return info;
		}
		return null;
	}
	
}