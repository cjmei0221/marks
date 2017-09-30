package com.marks.module.org.area.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.org.area.pojo.Area;

@MapperScan
public interface AreaDao {

	Area findById(@Param("areaId") String areaId);

	void save(Area area);

	void update(Area area);

	void delete(@Param("areaId") String areaId);

	List<Area> findAll();

	void deleteBatch(List<String> list);

	List<Area> list(PageBounds pageBounds, Map<String,Object> param);
}