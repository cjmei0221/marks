package com.marks.smart.market.mall.pay.service;


import com.marks.smart.market.mall.pay.pojo.PayAcct;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface PayAcctService{

	public PayAcct findById(String id);
	public void save(PayAcct info);
	public void update(PayAcct info);
	public void delete(String id);
	public List<PayAcct> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<PayAcct> list(int page_number, int page_size,Map<String,Object> param);
}