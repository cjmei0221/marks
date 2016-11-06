package com.cjmei.module.wx.wxmenu.service;


import com.cjmei.module.wx.wxmenu.pojo.WxMenu;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface WxMenuService{

	public WxMenu findById(String id);
	public void save(WxMenu wxMenu);
	public void update(WxMenu wxMenu);
	public void delete(String id);
	public List<WxMenu> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxMenu> list(int page_number, int page_size,Map<String,Object> param);
}