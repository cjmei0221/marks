package com.marks.module.mall.dispatch.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.mall.dispatch.pojo.DispatchLog;
import com.marks.module.mall.dispatch.dao.DispatchLogDao;
import com.marks.module.mall.dispatch.service.DispatchLogService;

@Service
@Transactional
public class DispatchLogServiceImpl implements DispatchLogService{

	private static Logger logger = Logger.getLogger( DispatchLogServiceImpl.class);
	
	@Autowired
	private DispatchLogDao dispatchLogDao;
   
/**
    private DispatchLogDao dispatchLogDao;

    public DispatchLogDao getDispatchLogDao(){
        return dispatchLogDao;
    }
    public void setDispatchLogDao(DispatchLogDao dispatchLogDao){
        this.dispatchLogDao =dispatchLogDao;
    }

 */   
    /**
    *根据ID查找配送记录
    */
    @Override
    public DispatchLog findById(String id){
      	logger.info("findById > param>"+id);
        return dispatchLogDao.findById(id);
    }
    
    /**
    *保存配送记录
    */
    @Override
    public void save(DispatchLog info){
        logger.info("save > start>");
        dispatchLogDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新配送记录
    */
    @Override
    public void update(DispatchLog info){
        logger.info("update > start>");
        dispatchLogDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除配送记录
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        dispatchLogDao.delete(id);       
    }
    
    /**
    *查找所有配送记录
    */
    @Override
    public List<DispatchLog> findAll(){
        logger.info("findAll > start> params >");
        return dispatchLogDao.findAll();   
    }
    
    /**
    *删除多个配送记录
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		dispatchLogDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<DispatchLog> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<DispatchLog> pojoDomain = new PojoDomain<DispatchLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<DispatchLog> list = dispatchLogDao.list(pageBounds,param);
		PageList<DispatchLog> pageList = (PageList<DispatchLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}