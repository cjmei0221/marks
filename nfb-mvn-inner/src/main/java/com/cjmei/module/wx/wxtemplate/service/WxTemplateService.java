package com.cjmei.module.wx.wxtemplate.service;


import com.cjmei.module.wx.wxtemplate.pojo.WxTemplate;

import java.util.List;
import java.util.Map;

import com.cjmei.common.domain.PojoDomain;

public interface WxTemplateService{

	public WxTemplate findById(String ywType,String accountid);
	public void save(WxTemplate wxTemplate);
	public void update(WxTemplate wxTemplate);
	public void delete(String ywType,String accountid);
	public List<WxTemplate> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxTemplate> list(int page_number, int page_size,Map<String,Object> param);
}