package com.cjmei.module.note.gains.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.note.gains.pojo.Gains;
import com.cjmei.module.note.gains.dao.GainsDao;
import com.cjmei.module.note.gains.service.GainsService;

public class GainsServiceImpl implements GainsService{
   

    private GainsDao gainsDao;

    public GainsDao getGainsDao(){
        return gainsDao;
    }
    public void setGainsDao(GainsDao gainsDao){
        this.gainsDao =gainsDao;
    }

    
    /**
    *根据ID查找心得记录
    */
    @Override
    public Gains findById(String id){
        return gainsDao.findById(id);
    }
    
    /**
    *保存心得记录
    */
    @Override
    public void save(Gains gains){
        gainsDao.save(gains);
    }
    
    /**
    *更新心得记录
    */
    @Override
    public void update(Gains gains){
        gainsDao.update(gains);
    }
    
    /**
    *删除心得记录
    */
    @Override
    public void delete(String id){
        gainsDao.delete(id);       
    }
    
    /**
    *查找所有心得记录
    */
    @Override
    public List<Gains> findAll(){
        return gainsDao.findAll();   
    }
    
    /**
    *删除多个心得记录
    */
    @Override
   public void deleteBatch(List<String> ids) {
		gainsDao.deleteBatch(ids);
	}
	
	public PojoDomain<Gains> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<Gains> pojoDomain = new PojoDomain<Gains>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<Gains> list = gainsDao.list(pageBounds,param);
		PageList<Gains> pageList = (PageList<Gains>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	@Override
	public Gains findByTitle(String title) {
		return gainsDao.findByTitle(title);
	}
	
}