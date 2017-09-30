package com.marks.module.vip.coupon.service;


import com.marks.module.vip.coupon.pojo.VipCoupon;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface VipCouponService{

	public VipCoupon findById(String idNo);
	public void save(VipCoupon vipCoupon);
	public void update(VipCoupon vipCoupon);
	public void delete(String idNo);
	public List<VipCoupon> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<VipCoupon> list(int page_number, int page_size,Map<String,Object> param);
}