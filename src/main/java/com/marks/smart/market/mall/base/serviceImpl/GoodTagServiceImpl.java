package com.marks.smart.market.mall.base.serviceImpl;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marks.smart.market.mall.base.pojo.GoodTag;
import com.marks.smart.market.mall.base.dao.GoodTagDao;
import com.marks.smart.market.mall.base.service.GoodTagService;

@Service
@Transactional
public class GoodTagServiceImpl implements GoodTagService{

	@Autowired
	private GoodTagDao goodTagDao;
   
/**
    private GoodTagDao goodTagDao;

    public GoodTagDao getGoodTagDao(){
        return goodTagDao;
    }
    public void setGoodTagDao(GoodTagDao goodTagDao){
        this.goodTagDao =goodTagDao;
    }

 */   
    /**
    *根据ID查找商品标签
    */
    @Override
    public GoodTag findById(String id){
        return goodTagDao.findById(id);
    }
    
    /**
    *保存商品标签
    */
    @Override
    public void save(GoodTag info){
        goodTagDao.save(info);
    }
    
    /**
    *更新商品标签
    */
    @Override
    public void update(GoodTag info){
        goodTagDao.update(info);
    }
    
    /**
    *删除商品标签
    */
    @Override
    public void delete(String id){
        goodTagDao.delete(id);       
    }
    
    /**
    *查找所有商品标签
    */
    @Override
    public List<GoodTag> findAll(){
        return goodTagDao.findAll();   
    }
    
    /**
    *删除多个商品标签
    */
    @Override
   public void deleteBatch(List<String> ids) {
		goodTagDao.deleteBatch(ids);
	}
	
	public PojoDomain<GoodTag> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<GoodTag> pojoDomain = new PojoDomain<GoodTag>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<GoodTag> list = goodTagDao.list(pageBounds,param);
		PageList<GoodTag> pageList = (PageList<GoodTag>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}