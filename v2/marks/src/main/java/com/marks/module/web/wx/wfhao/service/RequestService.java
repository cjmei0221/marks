package com.marks.module.web.wx.wfhao.service;

import javax.servlet.http.HttpServletRequest;

import com.marks.module.web.wx.wfhao.message.request.WechatRequest;
import com.marks.module.web.wx.wfhao.message.response.WechatResponse;

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
	public WechatResponse handle(HttpServletRequest request,WechatRequest requestMessage)throws Exception;
	
}
