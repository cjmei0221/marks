package com.marks.module.system.datadir.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.system.datadir.pojo.DataDir;

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