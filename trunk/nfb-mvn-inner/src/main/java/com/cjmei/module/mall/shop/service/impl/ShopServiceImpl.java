package com.cjmei.module.mall.shop.service.impl;

import java.util.List;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.mall.shop.dao.ShopDao;
import com.cjmei.module.mall.shop.pojo.ShopInfo;
import com.cjmei.module.mall.shop.service.ShopService;
import com.cjmei.module.system.sys.pojo.SysUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class ShopServiceImpl implements ShopService{

	private ShopDao shopDao;


	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}



	@Override
	public PojoDomain<ShopInfo> getShopList(SysUser user, int is_company, int page_number, int page_size,
			String keyword) {
		PojoDomain<ShopInfo> pojoDomain = new PojoDomain<ShopInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<ShopInfo> list = shopDao.getShopList(pageBounds,user.getShopList(),is_company,keyword);
		PageList<ShopInfo> pageList = (PageList<ShopInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}

}
