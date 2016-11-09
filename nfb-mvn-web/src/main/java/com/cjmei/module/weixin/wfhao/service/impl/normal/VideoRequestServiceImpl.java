package com.cjmei.module.weixin.wfhao.service.impl.normal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.weixin.wfhao.message.request.RequestMessage;
import com.cjmei.module.weixin.wfhao.message.response.ResponseMessage;
import com.cjmei.module.weixin.wfhao.message.response.impl.TextResponseMessage;

/**
 * 视频消息对象服务
 * 
 * @author
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class VideoRequestServiceImpl extends AbstractRequestService {
	private static Logger logger = Logger.getLogger(VideoRequestServiceImpl.class);
	/**
	 * 请求消息处理
	 * 
	 * @param requestMessage
	 *            请求消息对象
	 * @return 响应消息对象
	 * @throws Exception
	 */
	@Override
	public ResponseMessage handle(HttpServletRequest request, RequestMessage requestMessage) throws JSONException {
		logger.info("TextRequestServiceImpl deal start  ");
		return null;
	}

}
