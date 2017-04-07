package com.marks.module.inner.wx.modulemsg.dao;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.wx.modulemsg.pojo.ModuleMsg;

public interface ModuleMsgDao {

	ModuleMsg findById(String id);

	void save(ModuleMsg moduleMsg);

	void update(ModuleMsg moduleMsg);

	void delete(String id);

	List<ModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<ModuleMsg> list(PageBounds pageBounds, Map<String,Object> param);

	void deleteData(@Param("clearDate") String clearDate);

	List<ModuleMsg> getNeedPustMsg(@Param("limitnum")int limitnum, @Param("pushlimitnum")int pushlimitnum, @Param("timelimit") int timelimit, @Param("nowtime")long nowtime);

	void updateResultForModuleMsg(@Param("accountid") String accountid, @Param("msgId") String msgId,@Param("createtime") Timestamp createtime,@Param("resultCode") String resultCode,
			@Param("status")String status);
}