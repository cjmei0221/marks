package com.cjmei.module.weixin.wfhao.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.service.RequestDispatchService;
import com.cjmei.module.weixin.wfhao.service.RequestService;

/**
 * 请求消息对象分发接口实现
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class RequestDispatchServiceImpl implements RequestDispatchService {
	private static Logger logger = Logger.getLogger(RequestDispatchServiceImpl.class);
	private Map<String, RequestService> componentMap;
	
	/**
	 * 设置请求消息对象处理服务的组件Map
	 * 具体参见：applicationContext.xml中<bean id="requestDispatchService">一节
	 * @param componentMap
	 */
	public void setComponentMap(Map<String, RequestService> componentMap) {
		this.componentMap = componentMap;
	}
	
	/**
	 * 请求消息分发处理
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage dispatch(HttpServletRequest request,RequestMessage requestMessage) throws Exception {
	
		RequestService requestService=componentMap.get(requestMessage.getMsgType().toLowerCase());
		if(requestService!=null){
			ResponseMessage responseMessage=requestService.handle(request,requestMessage);
			return responseMessage;
		}
		return null;
	}

}
