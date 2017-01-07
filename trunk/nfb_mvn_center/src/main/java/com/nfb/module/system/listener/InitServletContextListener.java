package com.nfb.module.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nfb.module.syslog.thread.SysLogThreadPool;
import com.nfb.module.system.helper.TimingLoadingHelper;
import com.nfb.module.wxmodulemsg.thread.pool.WxModuleMsgThreadPool;

/**
 * 初始化上下文监听类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class InitServletContextListener implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent arg0) {
		WxModuleMsgThreadPool.destroy();
	}

	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
		DatabaseHelper.init(context);
		//首次加载参数
		new TimingLoadingHelper().doJob();
		/**
		 * 初始化微信模板消息推送线程池
		 */
		WxModuleMsgThreadPool.init();
		/**
		 * 记录访问日志
		 */
		SysLogThreadPool.init();
	}

}

