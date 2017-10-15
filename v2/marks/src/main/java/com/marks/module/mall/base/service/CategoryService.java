package com.marks.module.mall.base.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.base.pojo.Category;
import com.marks.module.org.area.pojo.Area;

public interface CategoryService{

	public Category findById(String cId);
	public void save(Category category);
	public void update(Category category);
	public void delete(String cId);
	public List<Category> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Category> list(int page_number, int page_size,Map<String,Object> param);

	public List<Area> treeGrid(String companyId, String parentId);
}