package com.marks.module.inner.supermarket.smgoodinfo.service;


import com.marks.module.inner.supermarket.smgoodinfo.pojo.SmGoodInfo;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface SmGoodInfoService{

	public SmGoodInfo findById(String goodId);
	public void save(SmGoodInfo smGoodInfo);
	public void update(SmGoodInfo smGoodInfo);
	public void delete(String goodId);
	public List<SmGoodInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SmGoodInfo> list(int page_number, int page_size,Map<String,Object> param);
	public SmGoodInfo findByskuAndOrgId(String companyId, String barCode);
}