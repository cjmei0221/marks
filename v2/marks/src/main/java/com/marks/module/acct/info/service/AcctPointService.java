package com.marks.module.acct.info.service;


import com.marks.module.acct.info.pojo.AcctPoint;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface AcctPointService{

	public AcctPoint findById(String userid);
	public void save(AcctPoint info);
	public void update(AcctPoint info);
	public void delete(String id);
	public List<AcctPoint> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AcctPoint> list(int page_number, int page_size,Map<String,Object> param);
}