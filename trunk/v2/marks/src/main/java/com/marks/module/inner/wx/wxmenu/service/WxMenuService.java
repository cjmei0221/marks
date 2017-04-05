package com.marks.module.inner.wx.wxmenu.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.common.domain.Result;
import com.marks.module.center.wxfwhao.common.entity.WxMenu;

public interface WxMenuService{

	public WxMenu findById(String id);
	public void save(WxMenu wxMenu);
	public void update(WxMenu wxMenu);
	public void delete(String id);
	public List<WxMenu> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxMenu> list(int page_number, int page_size,Map<String,Object> param);
	public List<WxMenu> listTree(Map<String, Object> param);
	public List<WxMenu> getChildWxMenuList(String id);
	public Result syncWx(String accountid) throws Exception;
}