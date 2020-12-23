package com.marks.smart.wx.manage.mp.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.smart.wx.manage.mp.entity.WxChatMsg;

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