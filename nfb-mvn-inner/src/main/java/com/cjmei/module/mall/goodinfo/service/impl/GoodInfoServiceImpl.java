package com.cjmei.module.mall.goodinfo.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.mall.goodinfo.pojo.GoodInfo;
import com.cjmei.module.mall.goodinfo.dao.GoodInfoDao;
import com.cjmei.module.mall.goodinfo.service.GoodInfoService;

public class GoodInfoServiceImpl implements GoodInfoService{
   

    private GoodInfoDao goodInfoDao;

    public GoodInfoDao getGoodInfoDao(){
        return goodInfoDao;
    }
    public void setGoodInfoDao(GoodInfoDao goodInfoDao){
        this.goodInfoDao =goodInfoDao;
    }

    
    /**
    *根据ID查找商品管理
    */
    @Override
    public GoodInfo findById(String goodId){
        return goodInfoDao.findById(goodId);
    }
    
    /**
    *保存商品管理
    */
    @Override
    public void save(GoodInfo goodInfo){
        goodInfoDao.save(goodInfo);
    }
    
    /**
    *更新商品管理
    */
    @Override
    public void update(GoodInfo goodInfo){
        goodInfoDao.update(goodInfo);
    }
    
    /**
    *删除商品管理
    */
    @Override
    public void delete(String goodId){
        goodInfoDao.delete(goodId);       
    }
    
    /**
    *查找所有商品管理
    */
    @Override
    public List<GoodInfo> findAll(){
        return goodInfoDao.findAll();   
    }
    
    /**
    *删除多个商品管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		goodInfoDao.deleteBatch(ids);
	}
	
	public PojoDomain<GoodInfo> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<GoodInfo> pojoDomain = new PojoDomain<GoodInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<GoodInfo> list = goodInfoDao.list(pageBounds,param);
		PageList<GoodInfo> pageList = (PageList<GoodInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}