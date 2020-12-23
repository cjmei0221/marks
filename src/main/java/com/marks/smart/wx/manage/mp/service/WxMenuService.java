package com.marks.smart.wx.manage.mp.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.smart.wx.manage.mp.entity.MyWxMenu;


public interface WxMenuService{

	public MyWxMenu findById(String id);

	public void save(MyWxMenu wxMenu);

	public void update(MyWxMenu wxMenu);
	public void delete(String id) throws Exception ;

	public List<MyWxMenu> findAll();
	public void deleteBatch(List<String> ids);

	public PojoDomain<MyWxMenu> list(int page_number, int page_size, Map<String, Object> param);

	public List<MyWxMenu> listTree(Map<String, Object> param);

	public List<MyWxMenu> getChildWxMenuList(String id);
	public Result syncWx(String id) throws Exception;
}