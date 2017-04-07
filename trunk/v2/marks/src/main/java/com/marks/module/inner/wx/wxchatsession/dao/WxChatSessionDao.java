package com.marks.module.inner.wx.wxchatsession.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.marks.module.inner.wx.wxchatsession.pojo.WxChatCount;
import com.marks.module.inner.wx.wxchatsession.pojo.WxChatSession;

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