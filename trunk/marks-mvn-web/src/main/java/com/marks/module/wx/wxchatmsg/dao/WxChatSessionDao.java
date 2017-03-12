package com.marks.module.wx.wxchatmsg.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.wxchatmsg.pojo.WxChatSession;

public interface WxChatSessionDao {

	WxChatSession findById(@Param("session_id")String session_id);

	void save(WxChatSession wxChatSession);

	void update(WxChatSession wxChatSession);

	void delete(@Param("session_id")String session_id);

	List<WxChatSession> findAll();

	void deleteBatch(List<String> list);

	List<WxChatSession> list(PageBounds pageBounds, Map<String,Object> param);

	WxChatSession findByAccountidAndOpenid(@Param("accountid")String accountid,@Param("openid") String openid, @Param("timeLong")long timeLong, @Param("sessionTimes")int sessionTimes,@Param("flag")int flag);
}