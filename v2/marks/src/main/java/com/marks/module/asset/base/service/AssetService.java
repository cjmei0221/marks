package com.marks.module.asset.base.service;


import com.marks.module.asset.base.pojo.Asset;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface AssetService{

	public Asset findById(String idNo);
	public void save(Asset info);
	public void update(Asset info);
	public void delete(String id);
	public List<Asset> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Asset> list(int page_number, int page_size,Map<String,Object> param);
}