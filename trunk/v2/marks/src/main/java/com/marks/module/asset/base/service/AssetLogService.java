package com.marks.module.asset.base.service;


import com.marks.module.asset.base.pojo.AssetLog;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface AssetLogService{

	public AssetLog findById(String id);
	public void save(AssetLog assetLog);
	public void update(AssetLog assetLog);
	public void delete(String id);
	public List<AssetLog> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AssetLog> list(int page_number, int page_size,Map<String,Object> param);
}