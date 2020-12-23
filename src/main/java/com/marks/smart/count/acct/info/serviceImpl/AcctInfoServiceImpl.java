package com.marks.smart.count.acct.info.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.count.acct.info.pojo.AcctInfo;
import com.marks.smart.count.acct.info.dao.AcctInfoDao;
import com.marks.smart.count.acct.info.service.AcctInfoService;

@Service
@Transactional
public class AcctInfoServiceImpl implements AcctInfoService{

	private static Logger logger = Logger.getLogger( AcctInfoServiceImpl.class);
	
	@Autowired
	private AcctInfoDao acctInfoDao;
   
/**
    private AcctInfoDao acctInfoDao;

    public AcctInfoDao getAcctInfoDao(){
        return acctInfoDao;
    }
    public void setAcctInfoDao(AcctInfoDao acctInfoDao){
        this.acctInfoDao =acctInfoDao;
    }

 */   
    /**
    *根据ID查找帐户信息
    */
    @Override
    public AcctInfo findById(String id){
      	logger.info("findById > param>"+id);
        return acctInfoDao.findById(id);
    }
    
    /**
    *保存帐户信息
    */
    @Override
    public void save(AcctInfo info){
        logger.info("save > start>");
        acctInfoDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新帐户信息
    */
    @Override
    public void update(AcctInfo info){
        logger.info("update > start>");
        acctInfoDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除帐户信息
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        acctInfoDao.delete(id);       
    }
    
    /**
    *查找所有帐户信息
    */
    @Override
    public List<AcctInfo> findAll(){
        logger.info("findAll > start> params >");
        return acctInfoDao.findAll();   
    }
    
    /**
    *删除多个帐户信息
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		acctInfoDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<AcctInfo> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<AcctInfo> pojoDomain = new PojoDomain<AcctInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AcctInfo> list = acctInfoDao.list(pageBounds,param);
		PageList<AcctInfo> pageList = (PageList<AcctInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}