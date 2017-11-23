package com.marks.module.wx.web.service.impl.normal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.wx.manage.dao.msg.WxAutoReplayDao;
import com.marks.module.wx.manage.entity.msg.WxAutoReplay;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.service.RequestService;
import com.marks.module.wx.web.service.impl.ReplyHelper;

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
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage, String key)
			throws Exception {
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
				sb.append(" [" + vo.getCkeyCode() + "] " + vo.getCkeyName() + "\r");
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
			return ReplyHelper.getInstance().replay(request, requestMessage, reply, null);
		}

		return responseMessage;
	}
}
