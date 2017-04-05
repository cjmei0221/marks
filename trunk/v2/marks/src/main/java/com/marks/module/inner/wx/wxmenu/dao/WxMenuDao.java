package com.marks.module.inner.wx.wxmenu.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.center.wxfwhao.common.entity.WxMenu;

public interface WxMenuDao {

	WxMenu findById(String id);

	void save(WxMenu wxMenu);

	void update(WxMenu wxMenu);

	void delete(String id);

	List<WxMenu> findAll();

	void deleteBatch(List<String> list);

	List<WxMenu> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxMenu> getParentMenu(Map<String, Object> param);

	List<WxMenu> getWxMenuList();

	List<WxMenu> getChildWxMenuList(@Param("parent_id")String id);

	List<WxMenu> getWxMenuListByAccountId(@Param("accountid")String accountid);
}