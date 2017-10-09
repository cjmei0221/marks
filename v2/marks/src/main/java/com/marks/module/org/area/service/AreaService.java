package com.marks.module.org.area.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.org.area.pojo.Area;

public interface AreaService{

	public Area findById(String areaId);
	public void save(Area area);
	public void update(Area area);
	public void delete(String areaId);
	public List<Area> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Area> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 通过父ID获取集合
	 * 
	 * @param companyId
	 * @return
	 */
	public List<Area> findByParentId(String companyId);

	public List<Area> treeGrid(String parentId);
}