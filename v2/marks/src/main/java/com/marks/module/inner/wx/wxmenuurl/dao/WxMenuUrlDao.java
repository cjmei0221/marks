package com.marks.module.inner.wx.wxmenuurl.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.marks.module.inner.wx.wxmenuurl.pojo.WxMenuUrl;

public interface WxMenuUrlDao {

	WxMenuUrl findById(String id);

	void save(WxMenuUrl wxMenuUrl);

	void update(WxMenuUrl wxMenuUrl);

	void delete(String id);

	List<WxMenuUrl> findAll();

	void deleteBatch(List<String> list);

	List<WxMenuUrl> list(PageBounds pageBounds, Map<String,Object> param);
}