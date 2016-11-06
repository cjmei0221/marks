package com.cjmei.module.wx.newsitem.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.wx.newsitem.pojo.NewsItem;

public interface NewsItemDao {

	NewsItem findById(String id);

	void save(NewsItem newsItem);

	void update(NewsItem newsItem);

	void delete(String id);

	List<NewsItem> findAll();

	void deleteBatch(List<String> list);

	List<NewsItem> list(PageBounds pageBounds, Map<String,Object> param);
}