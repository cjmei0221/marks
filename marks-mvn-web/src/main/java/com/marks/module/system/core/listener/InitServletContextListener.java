package com.cjmei.module.system.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cjmei.module.system.core.helper.LoadDataHelper;
import com.cjmei.module.system.syslog.thread.SysLogThreadPool;

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
		SysLogThreadPool.destroy();
	}

	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sce.getServletContext());
		DatabaseHelper.init(context);
		
		/*首次加载基础数据*/
		new LoadDataHelper().doJob();
		/**
		 * 保存访问日志
		 */
		SysLogThreadPool.init();
	}
}
