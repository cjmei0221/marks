package com.marks.module.wx.manage.base.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.manage.base.pojo.MyWxMenu;

@MapperScan
public interface WxMenuDao {

	MyWxMenu findById(String id);

	void save(MyWxMenu wxMenu);

	void update(MyWxMenu wxMenu);

	void delete(String id);

	List<MyWxMenu> findAll();

	void deleteBatch(List<String> list);

	List<MyWxMenu> list(PageBounds pageBounds, Map<String, Object> param);

	List<MyWxMenu> getParentMenu(Map<String, Object> param);

	List<MyWxMenu> getWxMenuList();

	List<MyWxMenu> getChildWxMenuList(@Param("parent_id") String id);

	List<MyWxMenu> getWxMenuListByAccountId(@Param("accountid") String accountid);
}