package com.marks.module.wxfwhao.wxmodulemsg.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wxfwhao.wxmodulemsg.entity.WxbModuleMsg;

public interface WxbModuleMsgDao {

	WxbModuleMsg findById(String id);

	void save(WxbModuleMsg wxbModuleMsg);

	void update(WxbModuleMsg wxbModuleMsg);

	void delete(String id);

	List<WxbModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<WxbModuleMsg> getNeedPustMsg(@Param("limitnum")int limitnum, @Param("pushlimitnum")int pushlimitnum, @Param("timelimit") int timelimit, @Param("nowtime")long nowtime);
}