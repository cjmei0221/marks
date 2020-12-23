package com.marks.smart.market.project.sales.service;


import com.marks.smart.market.project.sales.pojo.SalesForm;
import com.marks.smart.market.project.sales.pojo.SalesInfo;
import com.marks.smart.market.project.sales.pojo.SalesItem;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface SalesInfoService{

	public SalesInfo findById(String projectCode);
	public void save(SalesInfo info,List<SalesItem> list );
	public void update(SalesInfo info,List<SalesItem> list );
	public void delete(String id);
	public List<SalesInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<SalesInfo> list(int page_number, int page_size,Map<String,Object> param);
	/**
	 * 审核
	 * @param map
	 */
	public void updateCheckStatus(Map<String, String> map);
	
	public SalesInfo findActiveSalesInfo(Map<String, String> params);
	/**
	 * 保存明细
	 * @param vipId
	 * @param sales
	 */
	public void saveDetail(SalesForm info, SalesInfo sales);
	
	public List<SalesItem> findSalesItemListByProjectCode(String projectCode);
}