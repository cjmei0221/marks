package com.cjmei.module.system.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.filter.RequestRegex;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

public class PopedomInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = Logger.getLogger(PopedomInterceptor.class);

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Result result = new Result();
		SysUser loginUser = SysUserHelper.getCurrentUserInfo(request);
		if (null != loginUser) {
			String url = RequestRegex.repace("/", request.getRequestURI());
			int idx = url.indexOf(".");
			url = url.substring(request.getContextPath().length(), idx);
			log.info("----url: " + url);
			List<String> list = StaticData.getUrlList();
			if (list.contains(url) && loginUser.getUserUrlList().contains(url)) {
				return true;
			} else {
				result.setCode(-1000);
				result.setMessage("未登录用户不可以访问此地址[" + request.getRequestURI() + "]");
				JsonUtil.output(response, result);
				return false;
			}
		} else {
			result.setCode(-1000);
			result.setMessage("未登录用户不可以访问此地址[" + request.getRequestURI() + "]");
			JsonUtil.output(response, result);
			return false;
		}
	}
}
