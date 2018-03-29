package com.marks.module.mall.good.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.common.enums.GoodEnums;
import com.marks.common.util.IDUtil;
import com.marks.module.mall.good.dao.GoodInfoDao;
import com.marks.module.mall.good.pojo.GoodImg;
import com.marks.module.mall.good.pojo.GoodInfo;
import com.marks.module.mall.good.service.GoodInfoService;

@Service
public class GoodInfoServiceImpl implements GoodInfoService {
	@Autowired
	private GoodInfoDao goodInfoDao;

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
	}

	@Override
	public GoodInfo getGoodInfoByGoodNo(String companyId, String goodNo) {
		return goodInfoDao.getGoodInfoByGoodNo(companyId, goodNo);
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
}