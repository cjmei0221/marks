package com.marks.module.wx.modulemsg.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.modulemsg.pojo.ModuleMsg;

public interface ModuleMsgDao {

	ModuleMsg findById(String id);

	void save(ModuleMsg moduleMsg);

	void update(ModuleMsg moduleMsg);

	void delete(String id);

	List<ModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<ModuleMsg> list(PageBounds pageBounds, Map<String,Object> param);

	void deleteData(@Param("clearDate") String clearDate);
}