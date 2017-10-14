package com.marks.module.org.area.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

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

	List<Area> findByParentId(@Param("parentId") String parentId);

	List<Area> getTreeGridByParentId(@Param("companyId") String companyId, @Param("parentId") String parentId);

	void updateMoreLvlName(@Param("areaId") String areaId, @Param("areaName") String areaName, @Param("lvl") int lvl);

	void updateParentName(@Param("areaId") String areaId, @Param("areaName") String areaName);

}