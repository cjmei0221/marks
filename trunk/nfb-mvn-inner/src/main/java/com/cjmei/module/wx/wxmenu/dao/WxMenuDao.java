package com.cjmei.module.wx.wxmenu.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.wx.wxmenu.pojo.WxMenu;

public interface WxMenuDao {

	WxMenu findById(String id);

	void save(WxMenu wxMenu);

	void update(WxMenu wxMenu);

	void delete(String id);

	List<WxMenu> findAll();

	void deleteBatch(List<String> list);

	List<WxMenu> list(PageBounds pageBounds, Map<String,Object> param);
}