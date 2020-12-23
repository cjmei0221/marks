package com.marks.smart.market.mall.report.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.report.dao.OrderLogDao;
import com.marks.smart.market.mall.report.pojo.OrderLog;
import com.marks.smart.market.mall.report.service.OrderLogService;

@Service
@Transactional
public class OrderLogServiceImpl implements OrderLogService{

	@Autowired
	private OrderLogDao orderLogDao;

	@Override
	public PojoDomain<OrderLog> list(int page_number, int page_size, Map<String, Object> param) {
		PojoDomain<OrderLog> pojoDomain = new PojoDomain<OrderLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrderLog> list = orderLogDao.list(pageBounds, param);
		PageList<OrderLog> pageList = (PageList<OrderLog>) list;
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}