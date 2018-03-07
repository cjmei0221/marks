package com.marks.module.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.module.user.login.helper.LoginUtil;

public class WxUserInterceptor extends HandlerInterceptorAdapter {
	private static Logger log= Logger.getLogger(WxUserInterceptor.class);

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Result result = new Result();
		String device=request.getParameter("device");
		log.info("wxUser > device:"+device);
		if(null !=device && "PC".equals(device)){
			return true;
		}
		String openid = LoginUtil.getInstance().getCurrentOpenid(request);
		if (null != openid && openid.length()>5) {
			log.info("wxUser > openid:"+openid);
			return true;
		} else {
			result.setCode("-101");
			result.setMessage("微信会话失效，请关闭重新访问。");
			JsonUtil.output(response, result);
			return false;
		}
	}
}
