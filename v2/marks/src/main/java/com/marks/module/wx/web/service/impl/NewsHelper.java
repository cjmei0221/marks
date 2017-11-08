package com.marks.module.wx.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.system.upload.util.FTPUtil;
import com.marks.module.wx.manage.dao.msg.NewsItemDao;
import com.marks.module.wx.manage.entity.msg.NewsItem;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.ArticleResponse;
import com.marks.module.wx.web.message.response.WechatResponse;

public class NewsHelper {
	private static Logger logger = Logger.getLogger(NewsHelper.class);
	public static WechatResponse returnNews(WechatRequest requestMessage, String content,
			Map<String, String> replaceParams) {
		logger.info("NewsHelper deal start content>" + content);
		WechatResponse wechatResponse = new WechatResponse(requestMessage);
		try {
			// 获取图文id
			NewsItemDao newsItemDao = (NewsItemDao) SpringContextHolder.getBean(NewsItemDao.class);
			String[] newsItemIds = content.split(",");
			// 关键字回复图文消息
			List<NewsItem> newsItems = newsItemDao.getNewsItemByIds(newsItemIds);
			if (newsItems != null && newsItems.size() > 0) {
				List<ArticleResponse> items = new ArrayList<ArticleResponse>();
				ArticleResponse vo = null;
				for (NewsItem item : newsItems) {
					vo = new ArticleResponse();
					vo.setDescription(item.getDescription());
					vo.setPicUrl(FTPUtil.ftp_url + item.getPicUrl());
					vo.setTitle(item.getTitle());
					String url = item.getUrl();
					if (null != replaceParams && replaceParams.size() > 0) {
						for (Entry<String, String> entry : replaceParams.entrySet()) {
							url = url.replace(entry.getKey(), entry.getValue());
						}
					}
					vo.setUrl(url);
					items.add(vo);
				}
				wechatResponse.responseNews(items);
			}

		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		return wechatResponse;
	}

}
