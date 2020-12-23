package com.marks.smart.wx.manage.web.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.smart.wx.manage.mp.entity.WxAutoReplay;
import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.module.ModuleController;
import com.marks.smart.wx.manage.web.util.WxConstants;

public class ReplyHelper {
	private static Logger logger = Logger.getLogger(ReplyHelper.class);
	private static ReplyHelper util = null;

	private ReplyHelper() {
	};

	public static ReplyHelper getInstance() {
		if (util == null) {
			util = new ReplyHelper();
		}
		return util;
	}

	public WechatResponse replay(HttpServletRequest request, WechatRequest requestMessage, WxAutoReplay reply,
			Map<String, String> replaceParams) {
		WechatResponse responseMessage = null;
		responseMessage = new WechatResponse(requestMessage);
		if(null ==reply.getCreplay() || "".equals(reply.getCreplay())){
			return null;
		}
		String content = reply.getCreplay();
		if (WxConstants.weixin_replay_type_news.equals(reply.getReplayType())) {
			content =  reply.getCreplay();
			responseMessage = NewsHelper.returnNews(requestMessage, content, replaceParams);
		} else if (WxConstants.weixin_replay_type_module.equals(reply.getReplayType())) {
			responseMessage = moduleProcess(request, requestMessage, content);
		} else {
			// 替换首行／尾行／链接中的参数
			if (null != replaceParams && replaceParams.size() > 0) {
				for (Entry<String, String> entry : replaceParams.entrySet()) {
					content = content.replace(entry.getKey(), entry.getValue());
				}
			}
			responseMessage.setContent(content);
		}
		return responseMessage;
	}
	/**
	 * 业务组件处理
	 * 
	 * @param requestMessage
	 * @param content
	 * @return
	 */
	private WechatResponse moduleProcess(HttpServletRequest request, WechatRequest requestMessage, String content) {
		logger.info("Module path:" + content);
		return ModuleController.moduleHandle(request, content, requestMessage);
	}
}
