package com.cjmei.module.mall.shop.service;

import com.cjmei.common.domain.PojoDomain;
import com.cjmei.module.mall.shop.pojo.ShopInfo;
import com.cjmei.module.system.sys.pojo.SysUser;

public interface ShopService {

	PojoDomain<ShopInfo> getShopList(SysUser admin, int is_company, int page_number, int page_size, String keyword);

}
