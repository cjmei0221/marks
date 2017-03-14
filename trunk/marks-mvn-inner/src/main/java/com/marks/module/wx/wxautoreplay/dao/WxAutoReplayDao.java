package com.marks.module.wx.wxautoreplay.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wxautoreplay.pojo.WxAutoReplay;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WxAutoReplayDao {

	WxAutoReplay findById(String cparentType);

	void save(WxAutoReplay wxAutoReplay);

	void update(WxAutoReplay wxAutoReplay);

	void delete(String cparentType);

	List<WxAutoReplay> findAll();

	void deleteBatch(List<String> list);

	List<WxAutoReplay> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxAutoReplay> findByCkey(@Param("ckey")String ckey);
}