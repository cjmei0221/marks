package com.marks.module.wx.wxautoreplay.service;


import com.marks.module.wx.wxautoreplay.pojo.WxAutoReplay;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface WxAutoReplayService{

	public WxAutoReplay findById(String cparentType);
	public void save(WxAutoReplay wxAutoReplay);
	public void update(WxAutoReplay wxAutoReplay);
	public void delete(String cparentType);
	public List<WxAutoReplay> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxAutoReplay> list(int page_number, int page_size,Map<String,Object> param);
	public List<WxAutoReplay> findByCkey(String ckey);
}