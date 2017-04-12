package com.marks.module.inner.supermarket.smgoodinfo.service.impl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.marks.module.inner.supermarket.smgoodinfo.pojo.SmGoodInfo;
import com.marks.module.inner.supermarket.smgoodinfo.dao.SmGoodInfoDao;
import com.marks.module.inner.supermarket.smgoodinfo.service.SmGoodInfoService;

public class SmGoodInfoServiceImpl implements SmGoodInfoService{
   

    private SmGoodInfoDao smGoodInfoDao;

    public SmGoodInfoDao getSmGoodInfoDao(){
        return smGoodInfoDao;
    }
    public void setSmGoodInfoDao(SmGoodInfoDao smGoodInfoDao){
        this.smGoodInfoDao =smGoodInfoDao;
    }

    
    /**
    *根据ID查找超市商品
    */
    @Override
    public SmGoodInfo findById(String goodId){
        return smGoodInfoDao.findById(goodId);
    }
    
    /**
    *保存超市商品
    */
    @Override
    public void save(SmGoodInfo smGoodInfo){
        smGoodInfoDao.save(smGoodInfo);
    }
    
    /**
    *更新超市商品
    */
    @Override
    public void update(SmGoodInfo smGoodInfo){
        smGoodInfoDao.update(smGoodInfo);
    }
    
    /**
    *删除超市商品
    */
    @Override
    public void delete(String goodId){
        smGoodInfoDao.delete(goodId);       
    }
    
    /**
    *查找所有超市商品
    */
    @Override
    public List<SmGoodInfo> findAll(){
        return smGoodInfoDao.findAll();   
    }
    
    /**
    *删除多个超市商品
    */
    @Override
   public void deleteBatch(List<String> ids) {
		smGoodInfoDao.deleteBatch(ids);
	}
	
	public PojoDomain<SmGoodInfo> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<SmGoodInfo> pojoDomain = new PojoDomain<SmGoodInfo>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<SmGoodInfo> list = smGoodInfoDao.list(pageBounds,param);
		PageList<SmGoodInfo> pageList = (PageList<SmGoodInfo>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}