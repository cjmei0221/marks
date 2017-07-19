package com.marks.module.web.wx.wfhao.service.impl.event;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.module.inner.wx.modulemsg.service.ModuleMsgService;
import com.marks.module.sys.system.core.common.SpringContextHolder;
import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;
import com.marks.module.web.wx.wfhao.service.impl.normal.AbstractRequestService;
import com.marks.module.web.wx.wfhao.threadPool.WxhreadPool;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
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
		String createtimeStr=requestMessage.getCreateTime();
		Timestamp time=new Timestamp(Long.parseLong(createtimeStr)*1000);
		moduleMsgService.updateResultForModuleMsg(requestMessage.getAccountId(),requestMessage.getMsgID(),time,requestMessage.getStatus());
		WxhreadPool.updateWxUser(requestMessage.getAccountId(), requestMessage.getFromUserName());
		return null;
	}
	
}
