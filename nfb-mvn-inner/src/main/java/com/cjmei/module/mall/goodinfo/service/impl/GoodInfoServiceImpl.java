package com.cjmei.module.mall.goodinfo.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.common.enums.Enums;
import com.cjmei.common.util.IDUtil;
import com.cjmei.module.mall.goodinfo.dao.GoodInfoDao;
import com.cjmei.module.mall.goodinfo.pojo.GoodImg;
import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;
import com.cjmei.module.mall.goodinfo.service.GoodInfoService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class GoodInfoServiceImpl implements GoodInfoService {

	private GoodInfoDao goodInfoDao;

	public GoodInfoDao getGoodInfoDao() {
		return goodInfoDao;
	}

	public void setGoodInfoDao(GoodInfoDao goodInfoDao) {
		this.goodInfoDao = goodInfoDao;
	}

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
		saveGoodImg(goodInfo.getGoodId(), addMainImagePut, Enums.GoodImgType.Main.getValue());
		saveGoodImg(goodInfo.getGoodId(), addDetailImagePut, Enums.GoodImgType.Detail.getValue());
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
		saveGoodImg(goodInfo.getGoodId(), addMainImagePut, Enums.GoodImgType.Main.getValue());
		saveGoodImg(goodInfo.getGoodId(), addDetailImagePut, Enums.GoodImgType.Detail.getValue());
	}

	@Override
	public GoodInfo getGoodInfoBySkuNum(String sku_num) {
		return goodInfoDao.getGoodInfoBySkuNum(sku_num);
	}

	/**
	 * 删除商品管理
	 */
	@Override
	public void delete(String goodId) {
		goodInfoDao.delete(goodId);
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
	public void onsale(String goodId, int state) {
		goodInfoDao.onSale(goodId,state);
	}

	
}