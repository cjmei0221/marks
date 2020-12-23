package com.marks.smart.market.mall.report.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.smart.market.mall.report.pojo.OrderLog;

@MapperScan
public interface OrderLogDao {

	List<OrderLog> list(PageBounds pageBounds, Map<String, Object> param);
	
}