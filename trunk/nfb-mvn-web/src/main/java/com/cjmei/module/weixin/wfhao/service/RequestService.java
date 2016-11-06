package com.cjmei.module.weixin.wfhao.service;

import javax.servlet.http.HttpServletRequest;

import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;

/**
 * 请求消息对象服务接口
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public interface RequestService {

	/**
	 * 请求消息处理
	 * @param requestMessage 请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	public ResponseMessage handle(HttpServletRequest request,RequestMessage requestMessage)throws Exception;
}
