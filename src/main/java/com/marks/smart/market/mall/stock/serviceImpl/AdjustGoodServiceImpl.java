package com.marks.smart.market.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.smart.market.mall.stock.dao.AdjustGoodDao;
import com.marks.smart.market.mall.stock.pojo.AdjustGood;
import com.marks.smart.market.mall.stock.service.AdjustGoodService;

@Service
@Transactional
public class AdjustGoodServiceImpl implements AdjustGoodService{

	private static Logger logger = Logger.getLogger( AdjustGoodServiceImpl.class);
	
	@Autowired
	private AdjustGoodDao adjustGoodDao;
   
/**
    private AdjustGoodDao adjustGoodDao;

    public AdjustGoodDao getAdjustGoodDao(){
        return adjustGoodDao;
    }
    public void setAdjustGoodDao(AdjustGoodDao adjustGoodDao){
        this.adjustGoodDao =adjustGoodDao;
    }

 */   
    /**
    *根据ID查找调整商品
    */
    @Override
    public AdjustGood findById(String id){
      	logger.info("findById > param>"+id);
        return adjustGoodDao.findById(id);
    }
    
    /**
    *保存调整商品
    */
    @Override
    public void save(AdjustGood info){
        logger.info("save > start>");
        adjustGoodDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新调整商品
    */
    @Override
    public void update(AdjustGood info){
        logger.info("update > start>");
        adjustGoodDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除调整商品
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        adjustGoodDao.delete(id);       
    }
    
    /**
    *查找所有调整商品
    */
    @Override
    public List<AdjustGood> findAll(){
        logger.info("findAll > start> params >");
        return adjustGoodDao.findAll();   
    }
    
    /**
    *删除多个调整商品
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		adjustGoodDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<AdjustGood> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<AdjustGood> pojoDomain = new PojoDomain<AdjustGood>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AdjustGood> list = adjustGoodDao.list(pageBounds,param);
		PageList<AdjustGood> pageList = (PageList<AdjustGood>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}

	@Override
	public List<AdjustGood> findByOrderId(String orderId) {
		return adjustGoodDao.findByOrderId(orderId);
	}
	
}