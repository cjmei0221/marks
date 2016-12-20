package com.cjmei.module.system.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.login.util.LoginUtil;
import com.cjmei.module.weixin.wfhao.pojo.WxUser;

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
		WxUser wxUser=LoginUtil.getInstance().getCurrentWxbUser(request);
		if (null != wxUser) {
			return true;
		} else {
			result.setCode(-101);
			JsonUtil.output(response, result);
			return false;
		}
	}
}
