package com.cjmei.module.weixin.wfhao.service.impl.event;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.weixin.wfhao.dao.WxMenuDao;
import com.cjmei.module.weixin.wfhao.message.request.EventRequestMessage;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.pojo.WxMenu;
import com.cjmei.module.weixin.wfhao.service.impl.normal.AbstractRequestService;



/**
 * 上报菜单事件请求服务
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class ClickEventRequestServiceImpl extends AbstractRequestService {	

	private static Logger logger = Logger.getLogger(ClickEventRequestServiceImpl.class);

	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
		EventRequestMessage eventRequestMessage=(EventRequestMessage)requestMessage;
		logger.info("ClickEventRequestServiceImpl deal start eventkey > "+eventRequestMessage.getEventKey());
		WxMenuDao wxMenuDao=(WxMenuDao) DatabaseHelper.getBean(WxMenuDao.class);
		WxMenu weixinMenu=wxMenuDao.queryMenuById(eventRequestMessage.getEventKey());
		String module = "";
		if(weixinMenu!=null){
			module=weixinMenu.getContent();
		}else{
			logger.info("---------------------weixinMenu is null,please check wxb_menu table data");
		}
		return handle(requestMessage,module);
	}
	
}
