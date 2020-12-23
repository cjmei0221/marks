package com.marks.smart.market.project.sales.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.project.sales.pojo.SalesDetail;
import com.marks.smart.market.project.sales.dao.SalesDetailDao;
import com.marks.smart.market.project.sales.service.SalesDetailService;

@Service
@Transactional
public class SalesDetailServiceImpl implements SalesDetailService{

	private static Logger logger = Logger.getLogger( SalesDetailServiceImpl.class);
	
	@Autowired
	private SalesDetailDao salesDetailDao;
   
/**
    private SalesDetailDao salesDetailDao;

    public SalesDetailDao getSalesDetailDao(){
        return salesDetailDao;
    }
    public void setSalesDetailDao(SalesDetailDao salesDetailDao){
        this.salesDetailDao =salesDetailDao;
    }

 */   
   
	
	public PojoDomain<SalesDetail> list(int page_number, int page_size, Map<String,Object> param) {
	    logger.info("list > start>");
		PojoDomain<SalesDetail> pojoDomain = new PojoDomain<SalesDetail>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SalesDetail> list = salesDetailDao.list(pageBounds,param);
		PageList<SalesDetail> pageList = (PageList<SalesDetail>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		logger.info("list > end>");
		return pojoDomain;
	}
	
}