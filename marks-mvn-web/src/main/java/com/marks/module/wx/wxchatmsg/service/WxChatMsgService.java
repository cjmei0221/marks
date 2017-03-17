package com.marks.module.wx.wxchatmsg.service;


import com.marks.module.wx.wxchatmsg.pojo.WxChatMsg;
import com.marks.module.wx.wxchatmsg.pojo.WxChatSession;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface WxChatMsgService{

	public WxChatMsg findById(String id);
	public void save(WxChatSession wxSession);
	public void update(WxChatMsg wxChatMsg);
	public void delete(String id);
	public List<WxChatMsg> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxChatMsg> list(int page_number, int page_size,Map<String,Object> param);
}