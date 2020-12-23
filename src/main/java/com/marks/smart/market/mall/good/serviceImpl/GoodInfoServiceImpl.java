package com.marks.smart.market.mall.good.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.Enums;
import com.marks.common.enums.GoodEnums;
import com.marks.common.util.IDUtil;
import com.marks.smart.market.mall.good.dao.GoodInfoDao;
import com.marks.smart.market.mall.good.dao.GoodPriceLogDao;
import com.marks.smart.market.mall.good.pojo.GoodImg;
import com.marks.smart.market.mall.good.pojo.GoodInfo;
import com.marks.smart.market.mall.good.pojo.GoodPriceLog;
import com.marks.smart.market.mall.good.service.GoodInfoService;

@Service
public class GoodInfoServiceImpl implements GoodInfoService {
	@Autowired
	private GoodInfoDao goodInfoDao;
	@Autowired
	private GoodPriceLogDao goodPriceLogDao;
	/**
	 * 根据ID查找商品管理
	 */
	@Override
	public GoodInfo findById(String goodId) {
		return goodInfoDao.findById(goodId);
	}

	@Override
	public void save(GoodInfo goodInfo, String addMainImagePut, String addDetailImagePut) {
		goodInfoDao.save(goodInfo);
		goodInfoDao.deleteGoodImg(goodInfo.getGoodId());
		saveGoodImg(goodInfo.getGoodId(), addMainImagePut, GoodEnums.GoodImgType.Main.getValue());
		saveGoodImg(goodInfo.getGoodId(), addDetailImagePut, GoodEnums.GoodImgType.Detail.getValue());
		
		savePriceLog(goodInfo);
	}

	public void saveGoodImg(String goodId, String imgStr, int type) {
		if (null != imgStr && imgStr.length() > 5) {
			String[] arr = imgStr.split(",");
			if (arr.length > 0) {
				GoodImg img = null;
				int num = 0;
				for (String imageurl : arr) {
					num = num + 1;
					img = new GoodImg();
					img.setGoodId(goodId);
					img.setId(IDUtil.getUUID());
					img.setImgName("image"+num);
					img.setImgType(type);
					img.setSort(num);
					img.setImgUrl(imageurl);
					goodInfoDao.saveGoodImg(img);
				}
			}
		}
	}

	@Override
	public void update(GoodInfo goodInfo, String addMainImagePut, String addDetailImagePut) {
		goodInfoDao.update(goodInfo);
		goodInfoDao.deleteGoodImg(goodInfo.getGoodId());
		saveGoodImg(goodInfo.getGoodId(), addMainImagePut, GoodEnums.GoodImgType.Main.getValue());
		saveGoodImg(goodInfo.getGoodId(), addDetailImagePut, GoodEnums.GoodImgType.Detail.getValue());
		
		savePriceLog(goodInfo);
	}

	@Override
	public GoodInfo getGoodInfoByGoodNo(String companyId, String goodNo, String helpCode) {
		return goodInfoDao.getGoodInfoByGoodNo(companyId, goodNo, helpCode);
	}
	
	private void savePriceLog(GoodInfo info) {
		GoodPriceLog log=new GoodPriceLog();
		log.setId(IDUtil.getNumID());
		log.setBatchId(IDUtil.getNumID());
		log.setCheckStatus(Enums.CheckStatus.noCheck.getValue());
		log.setCompanyId(info.getCompanyId());
		log.setCostPrice(info.getCostPrice());
		log.setCreator(info.getUpdater());
		int idx=info.getUpdater().indexOf("-");
		if(idx>0) {
			log.setCreatorCode(info.getUpdater().substring(0, idx));
		}
		log.setDispatchPrice(info.getDispatchPrice());
		log.setGoodId(info.getGoodId());
		log.setGoodName(info.getGoodName());
		log.setGoodNo(info.getGoodNo());
		log.setMinPrice(info.getMinPrice());
		log.setRemarks("商品资料维护");
		log.setSalePrice(info.getSalePrice());
		log.setShopId(info.getShopId());
		log.setShopName(info.getShopName());
		log.setTradePrice(info.getTradePrice());
		log.setTypeCode(0);
		log.setTypeName("商品档案");
		log.setVipPrice(info.getVipPrice());
		log.setOnsale_status(info.getOnsale_status());
		goodPriceLogDao.save(log);
	}

	/**
	 * 删除商品管理
	 */
	@Override
	public void delete(String goodId) {
		goodInfoDao.delete(goodId);
		goodInfoDao.deleteGoodImg(goodId);
	}

	/**
	 * 查找所有商品管理
	 */
	@Override
	public List<GoodInfo> findAll() {
		return goodInfoDao.findAll();
	}

	/**
	 * 删除多个商品管理
	 */
	@Override
	public void deleteBatch(List<String> ids) {
		goodInfoDao.deleteBatch(ids);
	}

	public PojoDomain<GoodInfo> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<GoodInfo> pojoDomain = new PojoDomain<GoodInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<GoodInfo> list = goodInfoDao.list(pageBounds, param);
		PageList<GoodInfo> pageList = (PageList<GoodInfo>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

	@Override
	public List<GoodImg> findGoodImgByGoodId(String goodId) {
		return goodInfoDao.getGoodImgByGoodId(goodId);
	}

	@Override
	public void updateStatus(String goodId, int state) {
		goodInfoDao.onSale(goodId,state);
	}

	@Override
	public List<GoodInfo> listGoodByTypeId(String typeId) {
		return goodInfoDao.listGoodByTypeId(typeId);
	}

	@Override
	public List<GoodInfo> listGoodByBrandId(String brandId) {
		return goodInfoDao.listGoodByBrandId(brandId);
	}

	@Override
	public String getGoodNo(String companyId) {
		String orgId = goodInfoDao.getGoodNo(companyId);
		int num = 0;
		if (null != orgId && !"".equals(orgId)) {
			num = Integer.parseInt(orgId);
		} else {
			num = 1000;
		}
		orgId = String.valueOf(num + 1);
		return orgId;
	}

	@Override
	public GoodInfo getGoodInfoByLike(String companyId, String goodNo) {
		List<GoodInfo> list = goodInfoDao.getGoodInfoByLike(companyId, goodNo);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}