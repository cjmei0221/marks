package com.marks.module.web.wx.wfhao.service.impl.normal;

import java.util.List;

import org.apache.log4j.Logger;

import com.marks.module.inner.wx.wxautoreplay.dao.WxAutoReplayDao;
import com.marks.module.inner.wx.wxautoreplay.pojo.WxAutoReplay;
import com.marks.module.sys.system.core.common.SpringContextHolder;
import com.marks.module.web.wx.util.WxConstants;
import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;
import com.marks.module.web.wx.wfhao.module.ModuleController;
import com.marks.module.web.wx.wfhao.service.RequestService;
import com.marks.module.web.wx.wfhao.service.impl.NewsHelper;

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
		WechatResponse responseMessage = null;
		WxAutoReplayDao wxAutoReplayDao = (WxAutoReplayDao) SpringContextHolder.getBean(WxAutoReplayDao.class);
		List<WxAutoReplay> replyList = wxAutoReplayDao.getWxAutoReplayByKey(key.toLowerCase(),requestMessage.getAccountId());
		boolean isEquels = false;
		WxAutoReplay reply = null;
		StringBuffer sb = null;
		if (null != replyList && replyList.size() == 1) {
			isEquels = true;
			reply = replyList.get(0);
		} else if (null != replyList && replyList.size() > 1) {
			sb = new StringBuffer();
			sb.append("亲，您可以换种方式试试，输入以下关键词：\r\n");
			for (WxAutoReplay vo : replyList) {
				sb.append(" [" + vo.getCkey() + "] " + vo.getCkeyName() + "\r");
				if (vo.getCkey().equals(key.toLowerCase())) {
					isEquels = true;
					reply = vo;
				}
			}
			//不能识别单一回复
			if (!isEquels) {
				responseMessage = new WechatResponse(requestMessage);
				responseMessage.setContent(sb.toString());
				return responseMessage;
			}
		}

		if (isEquels) {
			responseMessage = new WechatResponse(requestMessage);
			if(null ==reply.getCreplay() || "".equals(reply.getCreplay())){
				return null;
			}
			String content = reply.getCreplay();
			if (WxConstants.weixin_replay_type_news.equals(reply.getReplayType())) {
				content = WxConstants.weixin_replay_type_news + ":" + reply.getCreplay();
				responseMessage = NewsHelper.Handle(requestMessage, content);
			} else if (WxConstants.weixin_replay_type_module.equals(reply.getReplayType())) {
				responseMessage = moduleProcess(requestMessage, content);
			} else {
				responseMessage.setContent(content);
			}
			return responseMessage;
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
