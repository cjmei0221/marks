package com.marks.module.mall.base.service;


import com.marks.module.mall.base.pojo.GoodTag;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface GoodTagService{

	public GoodTag findById(String tagId);
	public void save(GoodTag goodTag);
	public void update(GoodTag goodTag);
	public void delete(String tagId);
	public List<GoodTag> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<GoodTag> list(int page_number, int page_size,Map<String,Object> param);
}