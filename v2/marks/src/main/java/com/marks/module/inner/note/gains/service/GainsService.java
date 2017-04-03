package com.marks.module.inner.note.gains.service;


import com.marks.module.inner.note.gains.pojo.Gains;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface GainsService{

	public Gains findById(String id);
	public void save(Gains gains);
	public void update(Gains gains);
	public void delete(String id);
	public List<Gains> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Gains> list(int page_number, int page_size,Map<String,Object> param);
	public Gains findByTitle(String title);
}