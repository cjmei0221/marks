package com.cjmei.module.weixin.wfhao.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cjmei.common.util.Constants;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WxAutoReplayDao;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.NewsResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;
import com.cjmei.module.weixin.wfhao.pojo.NewsItem;

public class NewsHelper {
	private static Logger logger = Logger.getLogger(NewsHelper.class);
	public static ResponseMessage Handle(RequestMessage requestMessage, String content) {
		ResponseMessage responseMessage=null;
		try {
			//获取图文id
			WxAutoReplayDao wxAutoReplayDao = (WxAutoReplayDao) DatabaseHelper.getBean(WxAutoReplayDao.class);
			if(content.startsWith(Constants.weixin_replay_type_news)){
				String[] newsItemIds = content.split(":")[1].split(",");
				// 关键字回复图文消息
				List<NewsItem> newsItems = wxAutoReplayDao.getNewsItemByIds(newsItemIds);
				if (newsItems != null && newsItems.size() > 0) {
					NewsResponseMessage newsResponseMessage = new NewsResponseMessage(requestMessage);
					for (NewsItem item : newsItems) {
						newsResponseMessage.addData(item);
						newsResponseMessage.setContent(newsResponseMessage.toString());
					}
					responseMessage=newsResponseMessage;
				}else{
					TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);			
					textResponseMessage.setContent("");
					responseMessage=textResponseMessage;		
				}
			}
		} catch (Exception e) {
			logger.error("Exception:",e);
			TextResponseMessage textResponseMessage = new TextResponseMessage(requestMessage);			
			textResponseMessage.setContent("");
			responseMessage=textResponseMessage;		
		}
		return responseMessage;
	}

}
