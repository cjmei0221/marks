package com.marks.module.wx.manage.wxuser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.manage.wxuser.pojo.WxTags;

@MapperScan
public interface WxTagsDao {

	WxTags findById(@Param("id") String id);

	void save(WxTags wxTags);

	void update(WxTags wxTags);

	void delete(@Param("id") String id);

	List<WxTags> findAll();

	void deleteBatch(List<String> list);

	List<WxTags> list(PageBounds pageBounds, Map<String, Object> param);

	/**
	 * 通过公众号ID和名称获取标签
	 * 
	 * @param accountid
	 * @param name
	 * @return
	 */
	WxTags findByAccountIdAndName(@Param("accountid") String accountid, @Param("name") String name);

	/**
	 * 获取公众号的标签列表
	 * 
	 * @param id
	 * @return
	 */
	List<WxTags> findWxTagsByAccountid(@Param("accountid") String accountid);
}