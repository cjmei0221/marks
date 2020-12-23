package com.marks.smart.market.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.mall.stock.pojo.Trace;
import com.marks.smart.market.mall.stock.dao.TraceDao;
import com.marks.smart.market.mall.stock.service.TraceService;

@Service
@Transactional
public class TraceServiceImpl implements TraceService{

	@Autowired
	private TraceDao traceDao;
   
/**
    private TraceDao traceDao;

    public TraceDao getTraceDao(){
        return traceDao;
    }
    public void setTraceDao(TraceDao traceDao){
        this.traceDao =traceDao;
    }

 */   
    /**
    *根据ID查找追踪码管理
    */
    @Override
    public Trace findById(String id){
        return traceDao.findById(id);
    }
    
    /**
    *保存追踪码管理
    */
    @Override
    public void save(Trace info){
        traceDao.save(info);
    }
    
    /**
    *更新追踪码管理
    */
    @Override
    public void update(Trace info){
        traceDao.update(info);
    }
    
    /**
    *删除追踪码管理
    */
    @Override
    public void delete(String id){
        traceDao.delete(id);       
    }
    
    /**
    *查找所有追踪码管理
    */
    @Override
    public List<Trace> findAll(){
        return traceDao.findAll();   
    }
    
    /**
    *删除多个追踪码管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		traceDao.deleteBatch(ids);
	}
	
	public PojoDomain<Trace> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Trace> pojoDomain = new PojoDomain<Trace>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Trace> list = traceDao.list(pageBounds,param);
		PageList<Trace> pageList = (PageList<Trace>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}