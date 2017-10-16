package com.marks.module.core.filter;

import java.io.IOException;

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
import com.marks.module.system.syslog.pojo.SysLog;
import com.marks.module.system.syslog.thread.SysLogThreadPool;
import com.marks.module.user.login.helper.ManageUtil;
import com.marks.module.user.login.helper.WebUtil;
import com.marks.module.user.sysuser.pojo.SysUser;

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
		SysUser user = null;
		int source=1;
		if(url.indexOf("/inner")>=0){
			user = ManageUtil.getCurrentUserInfo(request);
			source=0;
		}else if(url.indexOf("/web")>=0){
			user = WebUtil.getInstance().getCurrentUser(request);
			source=2;
		}
		String ip = RequestUtil.getIpAddr(request);
		
		int success = 0;
		try {
			arg2.doFilter(arg0, arg1);
			boolean isLog=true;
			/*if (url.indexOf(".css") > 0 || url.indexOf(".js") >= 0 || url.indexOf(".png") >= 0
					|| url.indexOf(".jpg") >= 0 || url.indexOf(".json") >= 0 || url.indexOf(".ico") >= 0) {
				isLog=false;
			}*/
			if(isLog){
				SysLog log = new SysLog();
				if (user != null) {
					log.setUserid(user.getUserid());
					log.setUsername(user.getUsername());
					log.setRetain3(user.getCompanyNo());
				}
				log.setIp(ip);
				log.setRetain1(success + "");
				log.setRetain2(url);
				log.setUrl(url);
				
				log.setSource(source);
				SysLogThreadPool.saveSysLog(false,log);
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
