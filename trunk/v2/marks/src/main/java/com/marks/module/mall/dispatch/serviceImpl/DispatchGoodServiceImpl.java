package com.marks.module.mall.dispatch.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.dispatch.dao.DispatchGoodDao;
import com.marks.module.mall.dispatch.pojo.DispatchGood;
import com.marks.module.mall.dispatch.service.DispatchGoodService;

@Service
@Transactional
public class DispatchGoodServiceImpl implements DispatchGoodService{

	private static Logger logger = Logger.getLogger( DispatchGoodServiceImpl.class);
	
	@Autowired
	private DispatchGoodDao dispatchGoodDao;
   
/**
    private DispatchGoodDao dispatchGoodDao;

    public DispatchGoodDao getDispatchGoodDao(){
        return dispatchGoodDao;
    }
    public void setDispatchGoodDao(DispatchGoodDao dispatchGoodDao){
        this.dispatchGoodDao =dispatchGoodDao;
    }

 */   
    /**
    *根据ID查找采购商品
    */
    @Override
    public DispatchGood findById(String id){
      	logger.info("findById > param>"+id);
        return dispatchGoodDao.findById(id);
    }
    
    /**
    *保存采购商品
    */
    @Override
    public void save(DispatchGood info){
        logger.info("save > start>");
        dispatchGoodDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新采购商品
    */
    @Override
    public void update(DispatchGood info){
        logger.info("update > start>");
        dispatchGoodDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除采购商品
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        dispatchGoodDao.delete(id);       
    }
    
    /**
    *查找所有采购商品
    */
    @Override
    public List<DispatchGood> findAll(){
        logger.info("findAll > start> params >");
        return dispatchGoodDao.findAll();   
    }
    
    /**
    *删除多个采购商品
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		dispatchGoodDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<DispatchGood> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<DispatchGood> pojoDomain = new PojoDomain<DispatchGood>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<DispatchGood> list = dispatchGoodDao.list(pageBounds,param);
		PageList<DispatchGood> pageList = (PageList<DispatchGood>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public List<DispatchGood> findByOrderId(String orderId) {
		return dispatchGoodDao.findByOrderId(orderId);
	}
	
}