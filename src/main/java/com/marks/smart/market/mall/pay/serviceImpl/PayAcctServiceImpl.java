package com.marks.smart.market.mall.pay.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.mall.pay.pojo.PayAcct;
import com.marks.smart.market.mall.pay.dao.PayAcctDao;
import com.marks.smart.market.mall.pay.service.PayAcctService;

@Service
@Transactional
public class PayAcctServiceImpl implements PayAcctService{

	@Autowired
	private PayAcctDao payAcctDao;
   
/**
    private PayAcctDao payAcctDao;

    public PayAcctDao getPayAcctDao(){
        return payAcctDao;
    }
    public void setPayAcctDao(PayAcctDao payAcctDao){
        this.payAcctDao =payAcctDao;
    }

 */   
    /**
    *根据ID查找支付账户
    */
    @Override
    public PayAcct findById(String id){
        return payAcctDao.findById(id);
    }
    
    /**
    *保存支付账户
    */
    @Override
    public void save(PayAcct info){
        payAcctDao.save(info);
    }
    
    /**
    *更新支付账户
    */
    @Override
    public void update(PayAcct info){
        payAcctDao.update(info);
    }
    
    /**
    *删除支付账户
    */
    @Override
    public void delete(String id){
        payAcctDao.delete(id);       
    }
    
    /**
    *查找所有支付账户
    */
    @Override
    public List<PayAcct> findAll(){
        return payAcctDao.findAll();   
    }
    
    /**
    *删除多个支付账户
    */
    @Override
   public void deleteBatch(List<String> ids) {
		payAcctDao.deleteBatch(ids);
	}
	
	public PojoDomain<PayAcct> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<PayAcct> pojoDomain = new PojoDomain<PayAcct>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<PayAcct> list = payAcctDao.list(pageBounds,param);
		PageList<PayAcct> pageList = (PageList<PayAcct>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}