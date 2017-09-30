package com.marks.module.vip.coupon.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.vip.coupon.pojo.VipCoupon;

@MapperScan
public interface VipCouponDao {

	VipCoupon findById(@Param("idNo") String idNo);

	void save(VipCoupon vipCoupon);
	
	void saveBatch(@Param("list") List<VipCoupon> list);

	void update(VipCoupon vipCoupon);

	void delete(@Param("idNo") String idNo);

	List<VipCoupon> findAll();

	void deleteBatch(List<String> list);

	List<VipCoupon> list(PageBounds pageBounds, Map<String,Object> param);
}