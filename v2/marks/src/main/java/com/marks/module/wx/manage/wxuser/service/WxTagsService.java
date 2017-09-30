package com.marks.module.wx.manage.wxuser.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.wxuser.pojo.WxTags;

public interface WxTagsService{

	public WxTags findById(String id);
	public void save(WxTags wxTags);
	public void update(WxTags wxTags);
	public void delete(String id);
	public List<WxTags> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxTags> list(int page_number, int page_size,Map<String,Object> param);
	/**
	 * 通过公众号ID和名称获取标签
	 * @param accountid
	 * @param name
	 * @return
	 */
	public WxTags findByAccountIdAndName(String accountid, String name);
	/**
	 * 获取公众号的标签
	 * @param id
	 * @return
	 */
	public List<WxTags> findWxTagsByAccountid(String id);
}