package com.nfb.module.wxmodulemsg.dao;


import java.util.List;

import com.nfb.module.wxmodulemsg.entity.WxbModuleMsg;

public interface WxbModuleMsgDao {

	WxbModuleMsg findById(String id);

	void save(WxbModuleMsg wxbModuleMsg);

	void update(WxbModuleMsg wxbModuleMsg);

	void delete(String id);

	List<WxbModuleMsg> findAll();

	void deleteBatch(List<String> list);

	List<WxbModuleMsg> getNeedPustMsg(int limitnum);
}