package com.marks.module.wx.wxchatmsg.dao;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import com.marks.module.wx.wxchatmsg.pojo.WxChatMsg;

public interface WxChatMsgDao {

	WxChatMsg findById(String id);

	void save(WxChatMsg wxChatMsg);

	void update(WxChatMsg wxChatMsg);

	void delete(String id);

	List<WxChatMsg> findAll();

	void deleteBatch(List<String> list);

	List<WxChatMsg> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxChatMsg> getReplayList(String session_id);
}