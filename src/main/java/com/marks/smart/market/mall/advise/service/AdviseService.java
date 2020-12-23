package com.marks.smart.market.mall.advise.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.advise.pojo.Advise;

public interface AdviseService{

	public Advise findById(String ID);
	public void save(Advise advise);
	public void update(Advise advise);
	public void delete(String ID);
	public List<Advise> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<Advise> list(int page_number, int page_size,Map<String,Object> param);
}