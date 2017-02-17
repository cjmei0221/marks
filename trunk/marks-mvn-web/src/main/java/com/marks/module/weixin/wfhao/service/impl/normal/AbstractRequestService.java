package com.marks.module.weixin.wfhao.service.impl.normal;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.weixin.wfhao.dao.WxAutoReplayDao;
import com.marks.module.weixin.wfhao.message.request.WechatRequest;
import com.marks.module.weixin.wfhao.message.response.WechatResponse;
import com.marks.module.weixin.wfhao.module.ModuleController;
import com.marks.module.weixin.wfhao.pojo.WxAutoReplay;
import com.marks.module.weixin.wfhao.service.RequestService;
import com.marks.module.weixin.wfhao.service.impl.NewsHelper;

/**
 * 请求消息对象分发接口的抽象类实现 核心功能：提供统一请求消息处理
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class AbstractRequestService implements RequestService {

	private static Logger logger = Logger.getLogger(AbstractRequestService.class);

	/**
	 * 业务组件处理接口
	 * 
	 * @param requestMessage
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public WechatResponse handle(WechatRequest requestMessage, String key) throws Exception {
		WechatResponse responseMessage =null;
		WxAutoReplayDao wxAutoReplayDao = (WxAutoReplayDao) DatabaseHelper.getBean(WxAutoReplayDao.class);
		WxAutoReplay reply = wxAutoReplayDao.getWxAutoReplayByKey(key.toLowerCase(), requestMessage.getAccountId());
		if (null != reply) {
			responseMessage = new WechatResponse(requestMessage);
			String content = reply.getCreplay();
			if (Constants.weixin_replay_type_news.equals(reply.getReplayType())) {
				content = Constants.weixin_replay_type_news + ":" + reply.getCreplay();
				responseMessage = NewsHelper.Handle(requestMessage, content);
			} else if (Constants.weixin_replay_type_module.equals(reply.getReplayType())) {
				responseMessage = moduleProcess(requestMessage, content);
			} else {
				responseMessage.setContent(content);
			}
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
	private WechatResponse moduleProcess(WechatRequest requestMessage, String content) {
		logger.info("Module path:" + content);
		return ModuleController.moduleHandle(content, requestMessage);
	}
}
