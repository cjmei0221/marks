package com.cjmei.module.weixin.wfhao.service;

import javax.servlet.http.HttpServletRequest;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;

/**
 * 请求消息对象分发接口
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public interface RequestDispatchService {

	/**
	 * 请求消息分发处理
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	public ResponseMessage dispatch(HttpServletRequest request,RequestMessage requestMessage)throws Exception;
}
