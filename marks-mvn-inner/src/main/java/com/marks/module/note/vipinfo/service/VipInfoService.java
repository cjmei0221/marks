package com.cjmei.module.note.vipinfo.service;


import com.cjmei.module.note.vipinfo.pojo.VipInfo;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface VipInfoService{

	public VipInfo findById(String userid);
	public void save(VipInfo vipInfo);
	public void update(VipInfo vipInfo);
	public void delete(String userid);
	public List<VipInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<VipInfo> list(int page_number, int page_size,Map<String,Object> param);
}