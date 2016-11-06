package com.cjmei.module.wx.wxautoreplay.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.wx.wxautoreplay.pojo.WxAutoReplay;

public interface WxAutoReplayDao {

	WxAutoReplay findById(String cparentType);

	void save(WxAutoReplay wxAutoReplay);

	void update(WxAutoReplay wxAutoReplay);

	void delete(String cparentType);

	List<WxAutoReplay> findAll();

	void deleteBatch(List<String> list);

	List<WxAutoReplay> list(PageBounds pageBounds, Map<String,Object> param);
}