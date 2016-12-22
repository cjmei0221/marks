package com.cjmei.module.system.core.filter;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.sysuser.pojo.SysUser;

/**
 * 权限过滤器，针对URL地址进行过滤，对未授权的URL进行过滤掉
 * 
 * @author cypei
 *
 */
public class PopedomFilter implements Filter {

	private final static Logger Log = Logger.getLogger(PopedomFilter.class);

	private String regexUnLoginPattern;

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Log.info("PopedomFilter");
		HttpServletRequest request = (HttpServletRequest) arg0;
		SysUser sysUser = SysUserHelper.getCurrentUserInfo(request);
		String url = RequestRegex.repace("/", request.getRequestURI());
		int idx = url.indexOf(".");
		url = url.substring(request.getContextPath().length(), idx);
		Log.info("----url: " + url);
		List<String> list = StaticData.getUrlList();
		boolean flag = false;
		if (list.contains(url)) {

			if (sysUser != null && sysUser.getUserUrlList().contains(url)) {

				flag = true;
			}

		} else {
			if ("/sys/menu".equals(url) && sysUser == null) {

				flag = false;
			} else {

				flag = true;
			}
		}
		if (flag) {
			arg2.doFilter(arg0, arg1);
		} else {
			// 表示登录
			Result result = new Result();
			result.setCode(-1000);
			result.setMessage("未登录用户不可以访问此地址[" + request.getRequestURI() + "]");
			JsonUtil.output((HttpServletResponse) arg1, result);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String skip = filterConfig.getInitParameter("skipUnLoginRequestPattern");
		if (skip == null) {
			skip = "";
		}
		regexUnLoginPattern = regex(skip);
	}

	private String regex(String skipRequestPattern) {
		StringTokenizer st = new StringTokenizer(skipRequestPattern, ",");
		StringBuffer buf = new StringBuffer();
		while (st.hasMoreTokens()) {
			try {
				String ss = st.nextToken().trim();
				ss = ss.replaceAll("\\x2A", ".*");
				String s = ("(" + ss).concat(")|");
				buf.append(s);
			} catch (NoSuchElementException ignore) {
				log.error(ExceptionUtils.getStackTrace(ignore));
			}
		}
		String foo = buf.toString();
		skipRequestPattern = foo.substring(0, foo.length() - 1);
		return skipRequestPattern;
	}

	private static Logger log = Logger.getLogger(PopedomFilter.class);
}
