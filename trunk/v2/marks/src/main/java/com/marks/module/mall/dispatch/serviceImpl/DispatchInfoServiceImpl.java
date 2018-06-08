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

import com.marks.module.mall.dispatch.pojo.DispatchInfo;
import com.marks.module.mall.dispatch.dao.DispatchInfoDao;
import com.marks.module.mall.dispatch.service.DispatchInfoService;

@Service
@Transactional
public class DispatchInfoServiceImpl implements DispatchInfoService{

	private static Logger logger = Logger.getLogger( DispatchInfoServiceImpl.class);
	
	@Autowired
	private DispatchInfoDao dispatchInfoDao;
   
/**
    private DispatchInfoDao dispatchInfoDao;

    public DispatchInfoDao getDispatchInfoDao(){
        return dispatchInfoDao;
    }
    public void setDispatchInfoDao(DispatchInfoDao dispatchInfoDao){
        this.dispatchInfoDao =dispatchInfoDao;
    }

 */   
    /**
    *根据ID查找采购单
    */
    @Override
    public DispatchInfo findById(String id){
      	logger.info("findById > param>"+id);
        return dispatchInfoDao.findById(id);
    }
    
    /**
    *保存采购单
    */
    @Override
    public void save(DispatchInfo info){
        logger.info("save > start>");
        dispatchInfoDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新采购单
    */
    @Override
    public void update(DispatchInfo info){
        logger.info("update > start>");
        dispatchInfoDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除采购单
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        dispatchInfoDao.delete(id);       
    }
    
    /**
    *查找所有采购单
    */
    @Override
    public List<DispatchInfo> findAll(){
        logger.info("findAll > start> params >");
        return dispatchInfoDao.findAll();   
    }
    
    /**
    *删除多个采购单
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		dispatchInfoDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<DispatchInfo> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<DispatchInfo> pojoDomain = new PojoDomain<DispatchInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<DispatchInfo> list = dispatchInfoDao.list(pageBounds,param);
		PageList<DispatchInfo> pageList = (PageList<DispatchInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}