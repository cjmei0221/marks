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

import com.marks.common.util.RequestUtil;
import com.marks.module.runModel.RunModel;
import com.marks.module.system.login.pojo.SysUser;
import com.marks.module.system.login.util.LoginUtil;
import com.marks.module.system.syslog.pojo.SysLog;
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

		arg2.doFilter(arg0, arg1);
		SysUser loginUser=LoginUtil.getInstance().getCurrentUser(request);
		
		SysLog log = new SysLog();
		if(null !=loginUser){
			log.setUserid(loginUser.getUserid());
			log.setUsername(loginUser.getUsername());
		}else{
			log.setRetain3(RunModel.getInstance().getCompanyId());
		}
		log.setIp(ip);
		log.setRetain1(success + "");
		log.setRetain2(url);
		log.setUrl(url);
		log.setSource(2);
		SysLogThreadPool.saveSysLog(log);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
