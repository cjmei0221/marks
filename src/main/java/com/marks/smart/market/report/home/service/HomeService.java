package com.marks.smart.market.report.home.service;

import java.util.List;
import java.util.Map;

import com.marks.smart.market.report.home.pojo.CoreData;
import com.marks.smart.market.report.home.pojo.SalesData;

public interface HomeService {

	/**
	 * 查询指标数据
	 * 
	 * @param param
	 * @return
	 */
	CoreData getCoreData(Map<String, Object> param);

	/**
	 * 每日销售列表
	 * 
	 * @param param
	 * @return
	 */
	List<SalesData> getSalesForDate(Map<String, Object> param);

	List<SalesData> getSalesForSeason(Map<String, Object> param);

	List<SalesData> getSalesForMonth(Map<String, Object> param);

}
