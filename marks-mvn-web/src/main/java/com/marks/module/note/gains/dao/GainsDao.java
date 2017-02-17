package com.marks.module.note.gains.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.note.gains.pojo.Gains;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface GainsDao {

	Gains findById(String id);

	void save(Gains gains);

	void update(Gains gains);

	void delete(String id);

	List<Gains> findAll();

	void deleteBatch(List<String> list);

	List<Gains> list(PageBounds pageBounds, Map<String,Object> param);

	Gains findByTitle(@Param("title")String title);
}