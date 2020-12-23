package com.marks.smart.wx.manage.web.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.marks.common.util.date.DateUtil;
import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.wx.manage.mp.service.ModuleMsgService;
import com.marks.smart.wx.manage.web.message.request.WechatRequest;
import com.marks.smart.wx.manage.web.message.response.WechatResponse;
import com.marks.smart.wx.manage.web.service.impl.normal.AbstractRequestService;
import com.marks.smart.wx.manage.web.threadPool.WxhreadPool;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@Service("templatesendjobfinishEventRequestService")
public class TemplatesendjobfinishEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(TemplatesendjobfinishEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public WechatResponse handle(HttpServletRequest request,WechatRequest requestMessage) throws Exception {
		logger.info("TemplatesendjobfinishEventRequestServiceImpl deal start  > msgId: "+requestMessage.getMsgID()+" - result: "+requestMessage.getStatus());
		ModuleMsgService moduleMsgService=(ModuleMsgService) SpringContextHolder.getBean(ModuleMsgService.class);
		moduleMsgService.updateResultForModuleMsg(requestMessage.getAccountId(), requestMessage.getMsgID(),
				DateUtil.getCurrDateStr(), requestMessage.getStatus());
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		return null;
	}
	
}
