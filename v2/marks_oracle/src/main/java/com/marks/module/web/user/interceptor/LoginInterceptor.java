package com.marks.module.web.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.module.inner.user.sysuser.pojo.SysUser;
import com.marks.module.web.user.login.util.LoginUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static Logger log= Logger.getLogger(LoginInterceptor.class);

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Result result = new Result();
		SysUser loginUser = LoginUtil.getInstance().getCurrentUser(request);
		if (null != loginUser) {
			log.info("loginUser > userid: "+loginUser.getUserid()+" - mobile:"+loginUser.getBind_mobile());
			return true;
		} else {
			result.setCode("-100");
			JsonUtil.output(response, result);
			return false;
		}
	}
}
