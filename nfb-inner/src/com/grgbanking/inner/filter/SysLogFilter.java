package com.grgbanking.inner.filter;

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

import com.grgbanking.inner.helper.SysUserHelper;
import com.grgbanking.inner.po.domain.Result;
import com.grgbanking.inner.po.sys.SysLog;
import com.grgbanking.inner.po.sys.SysUser;
import com.grgbanking.inner.thread.SysLogThreadPool;
import com.grgbanking.inner.util.JsonUtil;
import com.grgbanking.inner.util.RequestUtil;

public class SysLogFilter implements Filter {
	private final static Logger LOG=Logger.getLogger(SysLogFilter.class);
	public void destroy() {
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		LOG.info("accessURI="+request.getRequestURI());
		//获取访问url
		String url=request.getRequestURI().replace(request.getContextPath(),"").replace(".do","");
		String ip=RequestUtil.getIpAddr(request);
		int success=0;
		String msg="";
		LOG.info("recordLogURI="+url);
		try {
			arg2.doFilter(arg0, arg1);
		} catch (Exception e) {
			success=1;
			Result result=new Result();
			result.setCode(4000);
			result.setMessage("系统异常");
			HttpServletResponse response=(HttpServletResponse)arg1;
			JsonUtil.output(response, result);
			LOG.error("Exception:",e);
			msg=e.getMessage();
		}
		SysUser user=SysUserHelper.getCurrentUserInfo(request);
		String userid="";
		String username="";
		if(user!=null){
			userid=user.getUserid();
			username=user.getUsername();
		}
		SysLog log=new SysLog();
		log.setIp(ip);
		log.setRetain1(success+"");
		log.setRetain2(msg);
		log.setUserid(userid);
		log.setUsername(username);
		log.setUrl(url);
		SysLogThreadPool.saveSysLog(log);
		
	}


	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
