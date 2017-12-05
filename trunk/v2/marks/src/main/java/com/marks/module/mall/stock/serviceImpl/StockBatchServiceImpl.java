package com.marks.module.mall.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.mall.stock.pojo.StockBatch;
import com.marks.module.mall.stock.dao.StockBatchDao;
import com.marks.module.mall.stock.service.StockBatchService;

@Service
@Transactional
public class StockBatchServiceImpl implements StockBatchService{

	@Autowired
	private StockBatchDao stockBatchDao;
   
/**
    private StockBatchDao stockBatchDao;

    public StockBatchDao getStockBatchDao(){
        return stockBatchDao;
    }
    public void setStockBatchDao(StockBatchDao stockBatchDao){
        this.stockBatchDao =stockBatchDao;
    }

 */   
    /**
    *根据ID查找库存批次
    */
    @Override
    public StockBatch findById(String id){
        return stockBatchDao.findById(id);
    }
    
    /**
    *保存库存批次
    */
    @Override
    public void save(StockBatch info){
        stockBatchDao.save(info);
    }
    
    /**
    *更新库存批次
    */
    @Override
    public void update(StockBatch info){
        stockBatchDao.update(info);
    }
    
    /**
    *删除库存批次
    */
    @Override
    public void delete(String id){
        stockBatchDao.delete(id);       
    }
    
    /**
    *查找所有库存批次
    */
    @Override
    public List<StockBatch> findAll(){
        return stockBatchDao.findAll();   
    }
    
    /**
    *删除多个库存批次
    */
    @Override
   public void deleteBatch(List<String> ids) {
		stockBatchDao.deleteBatch(ids);
	}
	
	public PojoDomain<StockBatch> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<StockBatch> pojoDomain = new PojoDomain<StockBatch>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<StockBatch> list = stockBatchDao.list(pageBounds,param);
		PageList<StockBatch> pageList = (PageList<StockBatch>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}