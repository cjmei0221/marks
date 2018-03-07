package com.marks.module.mall.order.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.dao.OrderGoodDao;
import com.marks.module.mall.order.service.OrderGoodService;

@Service
@Transactional
public class OrderGoodServiceImpl implements OrderGoodService{

	@Autowired
	private OrderGoodDao orderGoodDao;
   
/**
    private OrderGoodDao orderGoodDao;

    public OrderGoodDao getOrderGoodDao(){
        return orderGoodDao;
    }
    public void setOrderGoodDao(OrderGoodDao orderGoodDao){
        this.orderGoodDao =orderGoodDao;
    }

 */   
    /**
    *根据ID查找订单商品
    */
    @Override
    public OrderGood findById(String id){
        return orderGoodDao.findById(id);
    }
    
    /**
    *保存订单商品
    */
    @Override
    public void save(OrderGood info){
        orderGoodDao.save(info);
    }
    
    /**
    *更新订单商品
    */
    @Override
    public void update(OrderGood info){
        orderGoodDao.update(info);
    }
    
    /**
    *删除订单商品
    */
    @Override
    public void delete(String id){
        orderGoodDao.delete(id);       
    }
    
    /**
    *查找所有订单商品
    */
    @Override
    public List<OrderGood> findAll(){
        return orderGoodDao.findAll();   
    }
    
    /**
    *删除多个订单商品
    */
    @Override
   public void deleteBatch(List<String> ids) {
		orderGoodDao.deleteBatch(ids);
	}
	
	public PojoDomain<OrderGood> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<OrderGood> pojoDomain = new PojoDomain<OrderGood>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<OrderGood> list = orderGoodDao.list(pageBounds,param);
		PageList<OrderGood> pageList = (PageList<OrderGood>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}