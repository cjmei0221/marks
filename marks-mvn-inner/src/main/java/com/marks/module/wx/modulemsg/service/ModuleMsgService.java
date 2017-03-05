package com.marks.module.wx.modulemsg.service;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.modulemsg.pojo.ModuleMsg;
import com.marks.module.wx.wxuser.pojo.WxUser;

public interface ModuleMsgService {

	public ModuleMsg findById(String id);

	public void save(ModuleMsg moduleMsg);

	public void update(ModuleMsg moduleMsg);

	public void delete(String id);

	public List<ModuleMsg> findAll();

	public void deleteBatch(List<String> ids);

	public PojoDomain<ModuleMsg> list(int page_number, int page_size, Map<String, Object> param);
	
	public void pushDairyWxMsg(WxUser wxUser);
}