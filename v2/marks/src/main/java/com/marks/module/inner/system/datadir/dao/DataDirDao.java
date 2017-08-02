package com.marks.module.inner.system.datadir.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.system.datadir.pojo.DataDir;

@MapperScan
public interface DataDirDao {

	DataDir findById(@Param("ckey")String ckey,@Param("parentKey")String parentKey);

	void save(DataDir dataDir);

	void update(DataDir dataDir);

	void delete(@Param("ckey")String ckey,@Param("parentKey")String parentKey);

	List<DataDir> findAll();

	void deleteBatch(List<String> list);

	List<DataDir> list(PageBounds pageBounds, Map<String,Object> param);

	List<DataDir> listByParam(Map<String, Object> param);

	List<DataDir> findChildList(@Param("ckey")String ckey);
}