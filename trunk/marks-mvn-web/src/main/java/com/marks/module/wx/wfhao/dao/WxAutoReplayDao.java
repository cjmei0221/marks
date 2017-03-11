package com.marks.module.wx.wfhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marks.module.wx.wfhao.pojo.NewsItem;
import com.marks.module.wx.wfhao.pojo.WxAutoReplay;

public interface WxAutoReplayDao {

	WxAutoReplay getWxAutoReplayByKey(@Param("ckey")String ckey, @Param("accountId")String accountId);

	List<NewsItem> getNewsItemByIds(@Param("newsItemIds") String[] newsItemIds);

}
