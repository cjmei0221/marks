package com.marks.smart.market.report.home.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.marks.smart.market.report.home.pojo.CoreData;
import com.marks.smart.market.report.home.pojo.SalesData;

@MapperScan
public interface HomeDao {

	CoreData getIncome(Map<String, Object> param);

	CoreData getConsume(Map<String, Object> param);

	List<SalesData> getSalesForDate(Map<String, Object> param);

	List<SalesData> getSalesForSeason(Map<String, Object> param);

	List<SalesData> getSalesForMonth(Map<String, Object> param);

}
