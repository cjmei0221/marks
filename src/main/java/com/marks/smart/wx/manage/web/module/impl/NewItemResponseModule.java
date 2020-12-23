package com.marks.smart.wx.manage.web.module.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.wx.manage.mp.dao.NewsItemDao;
import com.marks.smart.wx.manage.mp.entity.NewsItem;
import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.ArticleResponse;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.module.Module;
import com.marks.smart.wx.manage.web.util.WxConstants;

public class NewItemResponseModule extends Module {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public WechatResponse syncRequest(HttpServletRequest request, WechatRequest requestMessage) throws Exception {
		WechatResponse wechatResponse = new WechatResponse(requestMessage);
		try {
			String content = requestMessage.getContent();
			//获取图文id
			NewsItemDao newsItemDao = (NewsItemDao) SpringContextHolder.getBean(NewsItemDao.class);
			if(content.startsWith(WxConstants.weixin_replay_type_news)){
				String[] newsItemIds = content.split(":")[1].split(",");
				// 关键字回复图文消息
				List<NewsItem> newsItems = newsItemDao.getNewsItemByIds(newsItemIds);
				if (newsItems != null && newsItems.size() > 0) {
					List<ArticleResponse> items = new ArrayList<ArticleResponse>();
					ArticleResponse vo=null;
					for (NewsItem item : newsItems) {
						vo=new ArticleResponse();
						vo.setDescription(item.getDescription());
						vo.setPicUrl(item.getPicUrl());
						vo.setTitle(item.getTitle());
						vo.setUrl(item.getUrl());
						items.add(vo);
					}
					wechatResponse.responseNews(items);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return wechatResponse;
	}

	@Override
	public String getOperate() {
		return "回复图文消息";
	}

}
