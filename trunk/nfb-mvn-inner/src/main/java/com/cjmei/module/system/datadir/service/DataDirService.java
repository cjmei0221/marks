package com.cjmei.module.system.datadir.service;


import com.cjmei.module.system.datadir.pojo.DataDir;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface DataDirService{

	public DataDir findById(String ckey,String parentKey);
	public void save(DataDir dataDir);
	public void update(DataDir dataDir);
	public void delete(String ckey,String parentKey);
	public List<DataDir> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<DataDir> list(int page_number, int page_size,Map<String,Object> param);
	public List<DataDir> listTree(Map<String, Object> param);
	public List<DataDir> findChildList(String ckey);
}