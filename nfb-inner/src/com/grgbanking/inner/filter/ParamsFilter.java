package com.grgbanking.inner.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ParamsFilter implements Filter{

	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse response,
			   FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)req;
			TsRequest wrapRequest= new TsRequest(request,request.getParameterMap());
        
			  //过滤服务器端的特殊字符（服务器端response输出到客户端的特殊汉字（色情、情色、赌博等））
			  response.setCharacterEncoding("utf-8"); 
			 // HttpCharacterResponseWrapper rs = new HttpCharacterResponseWrapper((HttpServletResponse)response);
			  chain.doFilter(wrapRequest, response);
			  //得到response输出内容
			 // String output = rs.getCw().toString();
			  //遍历所有敏感词
			   //替换敏感词
			 // TsRequest.filerParams(new String[]{output});
			  //通过原来的response输出内容
			 // response.getWriter().print(output);
			 }
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
