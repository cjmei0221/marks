package com.marks.module.acct.log.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.marks.common.domain.PojoDomain;
import com.marks.module.acct.log.dao.AcctLogDao;
import com.marks.module.acct.log.pojo.AcctLog;
import com.marks.module.acct.log.service.AcctLogService;

@Service
@Transactional
public class AcctLogServiceImpl implements AcctLogService{

	private static Logger logger = Logger.getLogger( AcctLogServiceImpl.class);
	
	@Autowired
	private AcctLogDao acctLogDao;
   
/**
    private AcctLogDao acctLogDao;

    public AcctLogDao getAcctLogDao(){
        return acctLogDao;
    }
    public void setAcctLogDao(AcctLogDao acctLogDao){
        this.acctLogDao =acctLogDao;
    }

 */   
    /**
    *根据ID查找交易记录
    */
    @Override
    public AcctLog findById(String id){
      	logger.info("findById > param>"+id);
        return acctLogDao.findById(id);
    }
    

	
	public PojoDomain<AcctLog> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<AcctLog> pojoDomain = new PojoDomain<AcctLog>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<AcctLog> list = acctLogDao.list(pageBounds,param);
		PageList<AcctLog> pageList = (PageList<AcctLog>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}