package com.marks.module.wxfwhao.wxmodulemsg.dao;


import java.util.List;

import com.marks.module.wxfwhao.wxmodulemsg.entity.WxbModuleMsg;

public interface WxbModuleMsgDao {

	WxbModuleMsg findById(String id);

	void save(WxbModuleMsg wxbModuleMsg);

	void update(WxbModuleMsg wxbModuleMsg);

	void delete(String id);

	List<WxbModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<WxbModuleMsg> getNeedPustMsg(int limitnum);
}