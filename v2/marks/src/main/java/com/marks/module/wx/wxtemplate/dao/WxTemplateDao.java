package com.marks.module.wx.wxtemplate.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wxtemplate.pojo.WxTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WxTemplateDao {

	WxTemplate findById(@Param("ywType")String ywType,@Param("accountid")String accountid);

	void save(WxTemplate wxTemplate);

	void update(WxTemplate wxTemplate);

	void delete(@Param("ywType")String ywType,@Param("accountid")String accountid);

	List<WxTemplate> findAll();

	void deleteBatch(List<String> list);

	List<WxTemplate> list(PageBounds pageBounds, Map<String,Object> param);
}