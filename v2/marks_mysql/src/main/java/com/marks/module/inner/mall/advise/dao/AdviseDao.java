package com.marks.module.inner.mall.advise.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.marks.module.inner.mall.advise.pojo.Advise;

@MapperScan
public interface AdviseDao {

	Advise findById(String ID);

	void save(Advise advise);

	void update(Advise advise);

	void delete(String ID);

	List<Advise> findAll();

	void deleteBatch(List<String> list);

	List<Advise> list(PageBounds pageBounds, Map<String,Object> param);
}