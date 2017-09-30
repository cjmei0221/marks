package com.marks.module.wx.manage.template.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.template.pojo.WxTemplate;

public interface WxTemplateService{

	public WxTemplate findById(String ywType,String accountid);
	public void save(WxTemplate wxTemplate);
	public void update(WxTemplate wxTemplate);
	public void delete(String ywType,String accountid);
	public List<WxTemplate> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxTemplate> list(int page_number, int page_size,Map<String,Object> param);
}