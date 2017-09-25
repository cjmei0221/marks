package com.marks.module.wx.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.module.core.common.SpringContextHolder;
import com.marks.module.wx.api.wxfwhao.common.entity.WxUser;
import com.marks.module.wx.manage.wxuser.service.WxUserService;
import com.marks.module.wx.web.message.request.WechatRequest;
import com.marks.module.wx.web.message.response.WechatResponse;
import com.marks.module.wx.web.service.impl.normal.AbstractRequestService;

/**
 * 取消关注事件请求服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("unsubscribeEventRequestService")
public class UnsubscribeEventRequestServiceImpl extends AbstractRequestService {

	private static Logger logger = Logger.getLogger(UnsubscribeEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse handle(HttpServletRequest request, WechatRequest requestMessage) {

		WxUser user = null;
		try {
			logger.info("-----------------UnsubscribeEventRequestServiceImpl:accountid:" + requestMessage.getAccountId()
					+ "-------openid:" + requestMessage.getFromUserName());
			WxUserService wxUserService = (WxUserService) SpringContextHolder
					.getBean(WxUserService.class);
			user = wxUserService.findById(requestMessage.getAccountId(),
					requestMessage.getFromUserName());
			if (user != null) {
				user.setIssubscribe(0);
				wxUserService.update(user);
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		return null;
	}

}
