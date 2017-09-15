package com.marks.module.sys.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.marks.module.inner.system.syslog.thread.SysLogThreadPool;
import com.marks.module.quartz.data.job.LoadDataHelper;
import com.marks.module.quartz.note.thread.pool.NoteThreadPool;
import com.marks.module.quartz.wx.thread.pool.WxModuleMsgThreadPool;
import com.marks.module.web.wx.wfhao.threadPool.WxhreadPool;

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
		NoteThreadPool.destroy();
	}

	public void contextInitialized(ServletContextEvent sce) {
//		WebApplicationContext context = WebApplicationContextUtils
//				.getRequiredWebApplicationContext(sce.getServletContext());
//		DatabaseHelper.init(context);
		
		/*记录系统操作日志*/
		SysLogThreadPool.init();
		/*首次加载基础数据*/
		new LoadDataHelper().doJob();
		
		NoteThreadPool.init();
		/**
		 * 更新粉丝信息
		 */
		WxhreadPool.init();
		/**
		 * 模板消息推送
		 */
		WxModuleMsgThreadPool.init();
	}
}
