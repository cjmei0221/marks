package com.marks.smart.market.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.mall.stock.pojo.TraceLog;
import com.marks.smart.market.mall.stock.dao.TraceLogDao;
import com.marks.smart.market.mall.stock.service.TraceLogService;

@Service
@Transactional
public class TraceLogServiceImpl implements TraceLogService{

	@Autowired
	private TraceLogDao traceLogDao;
   
/**
    private TraceLogDao traceLogDao;

    public TraceLogDao getTraceLogDao(){
        return traceLogDao;
    }
    public void setTraceLogDao(TraceLogDao traceLogDao){
        this.traceLogDao =traceLogDao;
    }

 */   
   
	
	public PojoDomain<TraceLog> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<TraceLog> pojoDomain = new PojoDomain<TraceLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<TraceLog> list = traceLogDao.list(pageBounds,param);
		PageList<TraceLog> pageList = (PageList<TraceLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}