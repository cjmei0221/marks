package com.marks.module.sys.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class SafeFilter implements Filter {
	private final static Logger LOG = Logger.getLogger(SafeFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		// 渗透处理
		String contentType = request.getContentType() == null ? null
				: request.getContentType().toLowerCase(Locale.ENGLISH);
		if (null != contentType && contentType.contains("multipart/form-data")
				&& !contentType.startsWith("multipart/form-data")) {
			LOG.info("此url的contentType异常");
			response.getWriter().write("Illegal Request,Reject!!!");
			response.getWriter().close();
			return;
		}
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
