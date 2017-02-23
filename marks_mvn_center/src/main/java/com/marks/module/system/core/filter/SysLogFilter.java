package com.marks.module.system.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.marks.common.util.Constants;
import com.marks.common.util.RequestUtil;
import com.marks.module.system.syslog.entity.SysLog;
import com.marks.module.system.syslog.thread.SysLogThreadPool;

public class SysLogFilter implements Filter {
	private final static Logger LOG = Logger.getLogger(SysLogFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		LOG.info("accessURI=" + request.getRequestURI());
		// 获取访问url
		String url = request.getRequestURI().replace(request.getContextPath(), "").replace(".do", "");
		String ip = RequestUtil.getIpAddr(request);
		int success = 0;
		LOG.info("recordLogURI=" + url);

		arg2.doFilter(arg0, arg1);

		SysLog log = new SysLog();
		log.setRetain3(null);
		log.setIp(ip);
		log.setRetain1(success + "");
		log.setRetain2(url);

		log.setUrl(url);
		log.setSource(1);
		SysLogThreadPool.saveSysLog(log);

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
