package com.marks.module.wx.wfhao.module;

import java.io.Serializable;

import com.marks.module.wx.wfhao.message.request.WechatRequest;
import com.marks.module.wx.wfhao.message.response.WechatResponse;

/**
 * 业务逻辑模块抽象类，所有功能模块必须实现
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public abstract class Module implements Serializable{

	private static final long serialVersionUID = -8722390275945202027L;

	/**
	 * 同步请求消息处理
	 * @param requestMessage
	 * @return
	 */
	public abstract WechatResponse syncRequest(WechatRequest requestMessage) throws Exception;
	
	protected String exception;	

	/**
	 * 获取属性：异常信息 
	 * @return
	 */
	public String getException() {
		return exception;
	}	

	/**
	 * 获取操作名称
	 * @return
	 */
	public abstract String getOperate();
}
