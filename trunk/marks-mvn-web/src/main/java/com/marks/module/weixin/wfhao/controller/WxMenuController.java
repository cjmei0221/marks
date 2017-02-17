package com.cjmei.module.weixin.wfhao.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjmei.module.weixin.wfhao.config.PageConfigUtil;

@Controller
public class WxMenuController {
	private static Logger logger = Logger.getLogger(WxMenuController.class);
	private String toAuth="/wxauth/toWxAuth";
	/**
	 * 
	 * lhyan3 2015年6月1日下午4:43:10 TODO
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/wxMenu/{accountId}/{pageUrl}")
	public void getJsConfig(@PathVariable String accountId,@PathVariable String pageUrl,HttpServletRequest request, HttpServletResponse response) {
		String url = request.getContextPath()+PageConfigUtil.getProperty("unsubscribeurl");
		try {
			String to_url=request.getContextPath()+PageConfigUtil.getProperty(pageUrl);	
			url=request.getContextPath()+toAuth+"?accountid="+accountId+"&to_url="+URLEncoder.encode(to_url, "UTF-8");
			logger.info("URL>>"+url);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			logger.info("Exception", e);
			try {
				request.getRequestDispatcher(request.getContextPath()+PageConfigUtil.getProperty("errorUrl")).forward(request, response);;
			} catch (Exception e1) {
	
			}
		}
	}

	
}
