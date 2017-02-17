package com.marks.module.wxfwhao.wxmodulemsg.service;


import java.util.List;

import com.marks.common.util.JsonResult;
import com.marks.module.wxfwhao.wxmodulemsg.entity.WxbModuleMsg;

public interface WxbModuleMsgService{

	public WxbModuleMsg findById(String id);
	public void save(WxbModuleMsg wxbModuleMsg);
	public void update(WxbModuleMsg wxbModuleMsg);
	public void delete(String id);
	public List<WxbModuleMsg> findAll();
	public void deleteBatch(List<String> ids);
	public JsonResult sendTemplateMsg(String accountid, String toUser, String templateCode, String url, String data,String note);
	public void pustWxbModuleMsg();
	
}