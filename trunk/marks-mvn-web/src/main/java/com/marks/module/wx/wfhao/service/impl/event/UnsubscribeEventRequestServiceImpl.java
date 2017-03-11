package com.marks.module.wx.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;
import com.marks.module.wx.wfhao.pojo.WxUser;
import com.marks.module.wx.wfhao.service.WeixinAccountService;
import com.marks.module.wx.wfhao.service.impl.normal.AbstractRequestService;

/**
 * 取消关注事件请求服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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
			WeixinAccountService weixinAccountService = (WeixinAccountService) DatabaseHelper
					.getBean(WeixinAccountService.class);
			user = weixinAccountService.queryWxUserByOpenID(requestMessage.getAccountId(),
					requestMessage.getFromUserName());
			if (user != null) {
				user.setIssubscribe(0);
				weixinAccountService.updateWxUser(user);
			}
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		return null;
	}

}
