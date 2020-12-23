package com.marks.smart.market.mall.good.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.mall.good.pojo.GoodPriceLog;
import com.marks.smart.market.mall.good.dao.GoodPriceLogDao;
import com.marks.smart.market.mall.good.service.GoodPriceLogService;

@Service
@Transactional
public class GoodPriceLogServiceImpl implements GoodPriceLogService{

	private static Logger logger = Logger.getLogger( GoodPriceLogServiceImpl.class);
	
	@Autowired
	private GoodPriceLogDao goodPriceLogDao;
   
/**
    private GoodPriceLogDao goodPriceLogDao;

    public GoodPriceLogDao getGoodPriceLogDao(){
        return goodPriceLogDao;
    }
    public void setGoodPriceLogDao(GoodPriceLogDao goodPriceLogDao){
        this.goodPriceLogDao =goodPriceLogDao;
    }

 */   
    /**
    *根据ID查找调价单
    */
    @Override
    public GoodPriceLog findById(String id){
      	logger.info("findById > param>"+id);
        return goodPriceLogDao.findById(id);
    }
    
    /**
    *保存调价单
    */
    @Override
    public void save(GoodPriceLog info){
        logger.info("save > start>");
        goodPriceLogDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新调价单
    */
    @Override
    public void update(GoodPriceLog info){
        logger.info("update > start>");
        goodPriceLogDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除调价单
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        goodPriceLogDao.delete(id);       
    }
    
    /**
    *查找所有调价单
    */
    @Override
    public List<GoodPriceLog> findAll(){
        logger.info("findAll > start> params >");
        return goodPriceLogDao.findAll();   
    }
    
    /**
    *删除多个调价单
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		goodPriceLogDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<GoodPriceLog> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<GoodPriceLog> pojoDomain = new PojoDomain<GoodPriceLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<GoodPriceLog> list = goodPriceLogDao.list(pageBounds,param);
		PageList<GoodPriceLog> pageList = (PageList<GoodPriceLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}