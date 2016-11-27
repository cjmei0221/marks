package com.cjmei.module.system.datadir.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.system.datadir.pojo.DataDir;

public interface DataDirDao {

	DataDir findById(String ckey);

	void save(DataDir dataDir);

	void update(DataDir dataDir);

	void delete(String ckey);

	List<DataDir> findAll();

	void deleteBatch(List<String> list);

	List<DataDir> list(PageBounds pageBounds, Map<String,Object> param);
}