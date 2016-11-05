package com.cjmei.module.mall.advise.service;


import com.cjmei.module.mall.advise.pojo.Advise;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface AdviseService{

	public Advise findById(String ID);
	public void save(Advise advise);
	public void update(Advise advise);
	public void delete(String ID);
	public List<Advise> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Advise> list(int page_number, int page_size,Map<String,Object> param);
}