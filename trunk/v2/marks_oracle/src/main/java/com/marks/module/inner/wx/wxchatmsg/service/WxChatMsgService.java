package com.marks.module.inner.wx.wxchatmsg.service;


import com.marks.module.inner.wx.wxchatmsg.pojo.WxChatMsg;

import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;

public interface WxChatMsgService{

	public WxChatMsg findById(String id);
	public void save(WxChatMsg wxChatMsg);
	public void update(WxChatMsg wxChatMsg);
	public void delete(String id);
	public List<WxChatMsg> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxChatMsg> list(int page_number, int page_size,Map<String,Object> param);
	public List<WxChatMsg> getReplayList(String session_id);
}