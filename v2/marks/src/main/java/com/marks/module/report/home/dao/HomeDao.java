package com.marks.module.report.home.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.report.home.pojo.CoreData;
import com.marks.module.report.home.pojo.SalesData;

@MapperScan
public interface HomeDao {

	CoreData getIncome(Map<String, Object> param);

	CoreData getConsume(Map<String, Object> param);

	List<SalesData> getSalesForDate(Map<String, Object> param);

	List<SalesData> getSalesForSeason(Map<String, Object> param);

	List<SalesData> getSalesForMonth(Map<String, Object> param);

}
