package com.marks.module.acct.info.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.acct.info.pojo.AcctPoint;
import com.marks.module.acct.info.dao.AcctPointDao;
import com.marks.module.acct.info.service.AcctPointService;

@Service
@Transactional
public class AcctPointServiceImpl implements AcctPointService{

	private static Logger logger = Logger.getLogger( AcctPointServiceImpl.class);
	
	@Autowired
	private AcctPointDao acctPointDao;
   
/**
    private AcctPointDao acctPointDao;

    public AcctPointDao getAcctPointDao(){
        return acctPointDao;
    }
    public void setAcctPointDao(AcctPointDao acctPointDao){
        this.acctPointDao =acctPointDao;
    }

 */   
    /**
    *根据ID查找用户积分
    */
    @Override
    public AcctPoint findById(String id){
      	logger.info("findById > param>"+id);
        return acctPointDao.findById(id);
    }
    
    /**
    *保存用户积分
    */
    @Override
    public void save(AcctPoint info){
        logger.info("save > start>");
        acctPointDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新用户积分
    */
    @Override
    public void update(AcctPoint info){
        logger.info("update > start>");
        acctPointDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除用户积分
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        acctPointDao.delete(id);       
    }
    
    /**
    *查找所有用户积分
    */
    @Override
    public List<AcctPoint> findAll(){
        logger.info("findAll > start> params >");
        return acctPointDao.findAll();   
    }
    
    /**
    *删除多个用户积分
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		acctPointDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<AcctPoint> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<AcctPoint> pojoDomain = new PojoDomain<AcctPoint>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AcctPoint> list = acctPointDao.list(pageBounds,param);
		PageList<AcctPoint> pageList = (PageList<AcctPoint>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}