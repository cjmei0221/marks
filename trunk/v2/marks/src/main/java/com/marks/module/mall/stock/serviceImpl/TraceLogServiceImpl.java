package com.marks.module.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.mall.stock.pojo.TraceLog;
import com.marks.module.mall.stock.dao.TraceLogDao;
import com.marks.module.mall.stock.service.TraceLogService;

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
    /**
    *根据ID查找追踪日志
    */
    @Override
    public TraceLog findById(String id){
        return traceLogDao.findById(id);
    }
    
    /**
    *保存追踪日志
    */
    @Override
    public void save(TraceLog info){
        traceLogDao.save(info);
    }
    
    /**
    *更新追踪日志
    */
    @Override
    public void update(TraceLog info){
        traceLogDao.update(info);
    }
    
    /**
    *删除追踪日志
    */
    @Override
    public void delete(String id){
        traceLogDao.delete(id);       
    }
    
    /**
    *查找所有追踪日志
    */
    @Override
    public List<TraceLog> findAll(){
        return traceLogDao.findAll();   
    }
    
    /**
    *删除多个追踪日志
    */
    @Override
   public void deleteBatch(List<String> ids) {
		traceLogDao.deleteBatch(ids);
	}
	
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