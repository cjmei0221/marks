package com.cjmei.module.note.transaction.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.note.transaction.pojo.Transaction;
import com.cjmei.module.note.transaction.dao.TransactionDao;
import com.cjmei.module.note.transaction.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{
   

    private TransactionDao transactionDao;

    public TransactionDao getTransactionDao(){
        return transactionDao;
    }
    public void setTransactionDao(TransactionDao transactionDao){
        this.transactionDao =transactionDao;
    }

    
    /**
    *根据ID查找事务提醒
    */
    @Override
    public Transaction findById(String id){
        return transactionDao.findById(id);
    }
    
    /**
    *保存事务提醒
    */
    @Override
    public void save(Transaction transaction){
        transactionDao.save(transaction);
    }
    
    /**
    *更新事务提醒
    */
    @Override
    public void update(Transaction transaction){
        transactionDao.update(transaction);
    }
    
    /**
    *删除事务提醒
    */
    @Override
    public void delete(String id){
        transactionDao.delete(id);       
    }
    
    /**
    *查找所有事务提醒
    */
    @Override
    public List<Transaction> findAll(){
        return transactionDao.findAll();   
    }
    
    /**
    *删除多个事务提醒
    */
    @Override
   public void deleteBatch(List<String> ids) {
		transactionDao.deleteBatch(ids);
	}
	
	public PojoDomain<Transaction> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Transaction> pojoDomain = new PojoDomain<Transaction>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Transaction> list = transactionDao.list(pageBounds,param);
		PageList<Transaction> pageList = (PageList<Transaction>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}