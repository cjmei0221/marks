package com.cjmei.module.wx.wxautoreplay.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjmei.module.wx.wxautoreplay.pojo.WxAutoReplay;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WxAutoReplayDao {

	WxAutoReplay findById(String cparentType);

	void save(WxAutoReplay wxAutoReplay);

	void update(WxAutoReplay wxAutoReplay);

	void delete(String cparentType);

	List<WxAutoReplay> findAll();

	void deleteBatch(List<String> list);

	List<WxAutoReplay> list(PageBounds pageBounds, Map<String,Object> param);

	WxAutoReplay findByCkey(@Param("ckey")String ckey);
}