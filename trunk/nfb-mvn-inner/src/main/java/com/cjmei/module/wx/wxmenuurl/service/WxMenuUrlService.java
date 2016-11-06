package com.cjmei.module.wx.wxmenuurl.service;


import com.cjmei.module.wx.wxmenuurl.pojo.WxMenuUrl;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface WxMenuUrlService{

	public WxMenuUrl findById(String id);
	public void save(WxMenuUrl wxMenuUrl);
	public void update(WxMenuUrl wxMenuUrl);
	public void delete(String id);
	public List<WxMenuUrl> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxMenuUrl> list(int page_number, int page_size,Map<String,Object> param);
}