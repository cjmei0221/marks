package com.cjmei.module.weixin.wfhao.module.impl;

import java.util.List;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WeixinAccountDao;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.NewsResponseMessage;
import com.cjmei.module.weixin.wfhao.module.Module;
import com.cjmei.module.weixin.wfhao.pojo.NewsItem;

public class NewItemResponseModule extends Module {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResponseMessage syncRequest(RequestMessage requestMessage)throws Exception {
		NewsResponseMessage newsResponseMessage = new NewsResponseMessage(requestMessage);
		try {
			//获取图文id
			WeixinAccountDao weixinAccountDao = (WeixinAccountDao) DatabaseHelper.getBean(WeixinAccountDao.class);
			String content = requestMessage.getContent();
			if(!requestMessage.getContent().contains("newsitem")){
				 content = "";//weixinAccountDao.getReplayContentByKey(requestMessage.getContent());
			}
			String[] newsItemIds = content.split(":")[1].split(",");
			// 关键字回复图文消息
			List<NewsItem> newsItems =null; //weixinAccountDao.getNewsItemByIds(newsItemIds);
			if (newsItems != null && newsItems.size() > 0) {
				for (NewsItem item : newsItems) {
					newsResponseMessage.addData(item);
					newsResponseMessage.setContent(newsResponseMessage.toString());
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return newsResponseMessage;
	}

	@Override
	public String getOperate() {
		return "回复图文消息";
	}

}
