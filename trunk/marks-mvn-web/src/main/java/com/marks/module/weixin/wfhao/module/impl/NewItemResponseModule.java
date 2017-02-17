package com.cjmei.module.weixin.wfhao.module.impl;

import java.util.ArrayList;
import java.util.List;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WxAutoReplayDao;
import com.cjmei.module.weixin.wfhao.message.request.WechatRequest;
import com.cjmei.module.weixin.wfhao.message.response.ArticleResponse;
import com.cjmei.module.weixin.wfhao.message.response.WechatResponse;
import com.cjmei.module.weixin.wfhao.module.Module;
import com.cjmei.module.weixin.wfhao.pojo.NewsItem;

public class NewItemResponseModule extends Module {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public WechatResponse syncRequest(WechatRequest requestMessage)throws Exception {
		WechatResponse wechatResponse = new WechatResponse(requestMessage);
		try {
			String content = requestMessage.getContent();
			//获取图文id
			WxAutoReplayDao wxAutoReplayDao = (WxAutoReplayDao) DatabaseHelper.getBean(WxAutoReplayDao.class);
			if(content.startsWith(Constants.weixin_replay_type_news)){
				String[] newsItemIds = content.split(":")[1].split(",");
				// 关键字回复图文消息
				List<NewsItem> newsItems = wxAutoReplayDao.getNewsItemByIds(newsItemIds);
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
