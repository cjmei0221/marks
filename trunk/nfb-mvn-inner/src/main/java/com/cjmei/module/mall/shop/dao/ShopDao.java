package com.cjmei.module.mall.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.mall.shop.pojo.ShopInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface ShopDao {

	List<ShopInfo> getShopList(PageBounds pageBounds,@Param("shopids") List<String> shopList,@Param("is_company") int is_company,@Param("keyword") String keyword);

}
