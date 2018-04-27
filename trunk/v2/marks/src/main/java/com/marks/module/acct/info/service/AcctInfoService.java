package com.marks.module.acct.info.service;


import com.marks.module.acct.info.pojo.AcctInfo;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface AcctInfoService{

	public AcctInfo findById(String userid);
	public void save(AcctInfo info);
	public void update(AcctInfo info);
	public void delete(String id);
	public List<AcctInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<AcctInfo> list(int page_number, int page_size,Map<String,Object> param);
}