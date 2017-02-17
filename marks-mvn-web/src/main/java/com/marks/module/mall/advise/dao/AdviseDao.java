package com.cjmei.module.mall.advise.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.mall.advise.pojo.Advise;

public interface AdviseDao {

	Advise findById(String ID);

	void save(Advise advise);

	void update(Advise advise);

	void delete(String ID);

	List<Advise> findAll();

	void deleteBatch(List<String> list);

	List<Advise> list(PageBounds pageBounds, Map<String,Object> param);
}