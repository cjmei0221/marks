package com.marks.module.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.module.core.data.StaticData;
import com.marks.module.core.filter.RequestRegex;
import com.marks.module.user.login.helper.LoginInnerUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

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
		log.info("sessionId:"+request.getSession().getId());
		SysUser loginUser = LoginInnerUtil.getCurrentUserInfo(request);
		if (null == loginUser) {
			result.setCode("-1000");
			result.setMessage("未登录用户不可以访问此地址[" + request.getRequestURI() + "]");
			JsonUtil.output(response, result);
			return false;
		}
		log.info("loginUser > userid:"+loginUser.getUserid()+" - mobile:"+loginUser.getBind_mobile());
		String url = RequestRegex.repace("/", request.getRequestURI());
		int idx = url.indexOf(".");
		url = url.substring(request.getContextPath().length(), idx);
		List<String> list = StaticData.getUrlList();
		if (list.contains(url) && !loginUser.getUserUrlList().contains(url)) {
			result.setCode("-1001");
			result.setMessage("您无此权限访问此地址[" + request.getRequestURI() + "]");
			JsonUtil.output(response, result);
			return false;
		}
		return true;
	}

}
