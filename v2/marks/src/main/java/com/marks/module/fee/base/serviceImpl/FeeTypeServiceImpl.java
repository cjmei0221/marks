package com.marks.module.fee.base.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.fee.base.pojo.FeeType;
import com.marks.module.fee.base.dao.FeeTypeDao;
import com.marks.module.fee.base.service.FeeTypeService;

@Service
@Transactional
public class FeeTypeServiceImpl implements FeeTypeService{

	private static Logger logger = Logger.getLogger( FeeTypeServiceImpl.class);
	
	@Autowired
	private FeeTypeDao feeTypeDao;
   
/**
    private FeeTypeDao feeTypeDao;

    public FeeTypeDao getFeeTypeDao(){
        return feeTypeDao;
    }
    public void setFeeTypeDao(FeeTypeDao feeTypeDao){
        this.feeTypeDao =feeTypeDao;
    }

 */   
    /**
    *根据ID查找费用科目
    */
    @Override
    public FeeType findById(String id){
      	logger.info("findById > param>"+id);
        return feeTypeDao.findById(id);
    }
    
    /**
    *保存费用科目
    */
    @Override
    public void save(FeeType info){
        logger.info("save > start>");
        feeTypeDao.save(info);
        logger.info("save > end>");
    }
    
    /**
    *更新费用科目
    */
    @Override
    public void update(FeeType info){
        logger.info("update > start>");
        feeTypeDao.update(info);
        logger.info("update > end>");
    }
    
    /**
    *删除费用科目
    */
    @Override
    public void delete(String id){
        logger.info("delete > start> params >" +id);
        feeTypeDao.delete(id);       
    }
    
    /**
    *查找所有费用科目
    */
    @Override
    public List<FeeType> findAll(){
        logger.info("findAll > start> params >");
        return feeTypeDao.findAll();   
    }
    
    /**
    *删除多个费用科目
    */
    @Override
   public void deleteBatch(List<String> ids) {
        logger.info("deleteBatch > start> params >"+ids);
		feeTypeDao.deleteBatch(ids);
		logger.info("deleteBatch > end> params >"+ids);
	}
	
	public PojoDomain<FeeType> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<FeeType> pojoDomain = new PojoDomain<FeeType>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<FeeType> list = feeTypeDao.list(pageBounds,param);
		PageList<FeeType> pageList = (PageList<FeeType>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}