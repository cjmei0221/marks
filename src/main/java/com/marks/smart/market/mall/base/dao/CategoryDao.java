package com.marks.smart.market.mall.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.base.pojo.Category;

@MapperScan
public interface CategoryDao {

	Category findById(@Param("typeId") String cId);

	void save(@Param("info") Category category);
	
	void saveBatch(@Param("list") List<Category> list);

	void update(@Param("info") Category category);

	void delete(@Param("typeId") String cId);

	List<Category> findAll();

	void deleteBatch(@Param("list") List<String> list);

	List<Category> list(PageBounds pageBounds, Map<String,Object> param);

	void updateMoreLvlName(@Param("typeId") String cId, @Param("typeName") String cName, @Param("lvl") int lvl);

	void updateParentName(@Param("typeId") String cId, @Param("typeName") String cName);

	List<Category> getTreeGridByParentId(@Param("companyId") String companyId, @Param("parentId") String parentId);

	String getTypeId(@Param("parentId") String parentId);
}