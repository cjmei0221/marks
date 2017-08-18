package com.marks.module.inner.user.vipinfo.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.inner.user.vipinfo.pojo.VipInfo;

public interface VipInfoService{

	public VipInfo findById(String userid);
	public void save(VipInfo vipInfo);
	public void update(VipInfo vipInfo);
	public void delete(String userid);
	public List<VipInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<VipInfo> list(int page_number, int page_size,Map<String,Object> param);
	public VipInfo findVipDetailInfoById(String userid);
}