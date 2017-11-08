package com.marks.module.wx.manage.service.chat;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.wx.manage.entity.chat.WxChatCount;
import com.marks.module.wx.manage.entity.chat.WxChatSession;

public interface WxChatSessionService{

	public WxChatSession findById(String session_id);
	public void save(WxChatSession wxChatSession);
	public void update(WxChatSession wxChatSession);
	public void delete(String session_id);
	public List<WxChatSession> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<WxChatSession> list(int page_number, int page_size,Map<String,Object> param);
	public PojoDomain<WxChatCount> getCountList(int page_number, int page_size, Map<String, Object> param);
}