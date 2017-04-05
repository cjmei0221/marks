package com.marks.module.sys.system.core.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.marks.common.domain.Result;
import com.marks.common.util.JsonUtil;
import com.marks.common.util.RequestUtil;
import com.marks.module.inner.system.syslog.pojo.SysLog;
import com.marks.module.inner.system.syslog.thread.SysLogThreadPool;
import com.marks.module.inner.system.sysuser.pojo.SysUser;
import com.marks.module.sys.system.core.helper.SysUserHelper;

public class SysLogFilter implements Filter {
	private final static Logger LOG = Logger.getLogger(SysLogFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		LOG.info("accessURI=" + request.getRequestURI());
		// 渗透处理
		String contentType = request.getContentType() == null ? null
				: request.getContentType().toLowerCase(Locale.ENGLISH);
		if (null != contentType && contentType.contains("multipart/form-data")
				&& !contentType.startsWith("multipart/form-data")) {
			LOG.info("此url的contentType异常");
			HttpServletResponse response = (HttpServletResponse) arg1;
			response.getWriter().write("Illegal Request,Reject!!!");
			response.getWriter().close();
			return;
		}

		// 获取访问url
		String url = request.getRequestURI();
		String ip = RequestUtil.getIpAddr(request);
		SysUser user = SysUserHelper.getCurrentUserInfo(request);
		int success = 0;
		try {
			arg2.doFilter(arg0, arg1);
			boolean isLog=true;
			if (url.indexOf(".css") > 0 || url.indexOf(".js") >= 0 || url.indexOf(".png") >= 0
					|| url.indexOf(".jpg") >= 0 || url.indexOf(".json") >= 0 || url.indexOf(".ico") >= 0) {
				isLog=false;
			}
			if(isLog){
				SysLog log = new SysLog();
				if (user != null) {
					log.setUserid(user.getUserid());
					log.setUsername(user.getUsername());
					log.setRetain3(user.getCompanyId());
				}
				log.setIp(ip);
				log.setRetain1(success + "");
				log.setRetain2(url);

				log.setUrl(url);
				log.setSource(0);
				SysLogThreadPool.saveSysLog(false, log);
			}
		} catch (Exception e) {
			LOG.error("Exception:", e);
			Result result = new Result();
			result.setCode("4000");
			result.setMessage("系统异常");
			HttpServletResponse response = (HttpServletResponse) arg1;
			JsonUtil.output(response, result);
			return;
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
