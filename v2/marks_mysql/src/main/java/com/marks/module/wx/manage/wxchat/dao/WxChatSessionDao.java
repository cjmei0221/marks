package com.marks.module.wx.manage.wxchat.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.wx.manage.wxchat.pojo.WxChatCount;
import com.marks.module.wx.manage.wxchat.pojo.WxChatSession;
@MapperScan
public interface WxChatSessionDao {

	WxChatSession findById(String session_id);

	void save(WxChatSession wxChatSession);

	void update(WxChatSession wxChatSession);

	void delete(String session_id);

	List<WxChatSession> findAll();

	void deleteBatch(List<String> list);

	List<WxChatSession> list(PageBounds pageBounds, Map<String,Object> param);

	List<WxChatCount> getCountList(PageBounds pageBounds, Map<String, Object> param);

	WxChatSession findByAccountidAndOpenid(@Param("accountid")String accountid,@Param("openid") String openid, @Param("timeLong")long timeLong, @Param("sessionTimes")int sessionTimes,@Param("flag")int flag);
}