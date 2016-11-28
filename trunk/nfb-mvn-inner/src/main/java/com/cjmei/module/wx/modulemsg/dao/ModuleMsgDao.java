package com.cjmei.module.wx.modulemsg.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.cjmei.module.wx.modulemsg.pojo.ModuleMsg;

public interface ModuleMsgDao {

	ModuleMsg findById(String id);

	void save(ModuleMsg moduleMsg);

	void update(ModuleMsg moduleMsg);

	void delete(String id);

	List<ModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<ModuleMsg> list(PageBounds pageBounds, Map<String,Object> param);
}