package com.cjmei.module.system.core.filter;

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

import com.cjmei.common.domain.Result;
import com.cjmei.common.util.Constants;
import com.cjmei.common.util.JsonUtil;
import com.cjmei.common.util.RequestUtil;
import com.cjmei.module.system.core.helper.SysUserHelper;
import com.cjmei.module.system.core.thread.SysLogThreadPool;
import com.cjmei.module.system.sys.pojo.SysLog;
import com.cjmei.module.system.sysuser.pojo.SysUser;

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
		SysLog log=new SysLog();
		if(user!=null){
			log.setUserid(user.getUserid());
			log.setUsername(user.getUsername());
			log.setRetain3(user.getCompanyId()==null?"0":user.getCompanyId());
		}else{
			log.setRetain3(Constants.default_companyId);
		}
		log.setIp(ip);
		log.setRetain1(success+"");
		log.setRetain2(url);
		
		log.setUrl(url);
		log.setSource(0);
		SysLogThreadPool.saveSysLog(log);
		
	}


	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
