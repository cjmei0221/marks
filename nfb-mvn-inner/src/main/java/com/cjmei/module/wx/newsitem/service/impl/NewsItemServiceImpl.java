package com.cjmei.module.wx.newsitem.service.impl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.cjmei.module.wx.newsitem.pojo.NewsItem;
import com.cjmei.module.wx.newsitem.dao.NewsItemDao;
import com.cjmei.module.wx.newsitem.service.NewsItemService;

public class NewsItemServiceImpl implements NewsItemService{
   

    private NewsItemDao newsItemDao;

    public NewsItemDao getNewsItemDao(){
        return newsItemDao;
    }
    public void setNewsItemDao(NewsItemDao newsItemDao){
        this.newsItemDao =newsItemDao;
    }

    
    /**
    *根据ID查找回复图文管理
    */
    @Override
    public NewsItem findById(String id){
        return newsItemDao.findById(id);
    }
    
    /**
    *保存回复图文管理
    */
    @Override
    public void save(NewsItem newsItem){
        newsItemDao.save(newsItem);
    }
    
    /**
    *更新回复图文管理
    */
    @Override
    public void update(NewsItem newsItem){
        newsItemDao.update(newsItem);
    }
    
    /**
    *删除回复图文管理
    */
    @Override
    public void delete(String id){
        newsItemDao.delete(id);       
    }
    
    /**
    *查找所有回复图文管理
    */
    @Override
    public List<NewsItem> findAll(){
        return newsItemDao.findAll();   
    }
    
    /**
    *删除多个回复图文管理
    */
    @Override
   public void deleteBatch(List<String> ids) {
		newsItemDao.deleteBatch(ids);
	}
	
	public PojoDomain<NewsItem> list(int page_number, int page_size, Map<String,Object> param) {
		PojoDomain<NewsItem> pojoDomain = new PojoDomain<NewsItem>();
		PageBounds pageBounds = new PageBounds(page_number, page_size);
		List<NewsItem> list = newsItemDao.list(pageBounds,param);
		PageList<NewsItem> pageList = (PageList<NewsItem>)list; 
		pojoDomain.setPojolist(list);
		pojoDomain.setPage_number(page_number);
		pojoDomain.setPage_size(page_size);
		pojoDomain.setTotal_count(pageList.getPaginator().getTotalCount());
		return pojoDomain;
	}
	
}