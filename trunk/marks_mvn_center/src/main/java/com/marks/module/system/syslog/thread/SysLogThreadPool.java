package com.marks.module.system.syslog.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.system.syslog.dao.SysLogDao;
import com.marks.module.system.syslog.entity.SysLog;
import com.marks.module.system.syslog.entity.SysLogParam;

/**
 * 系统日志记录线程池 File Name: com.grgbanking.inner.thread.SysLogThreadPool.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月26日上午11:51:06
 * @see (optional)
 * @Copyright (c) 2016, cjmei All Rights Reserved.
 */
public class SysLogThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(5);// 开5个线程处理消息推送
	}

	public static void destroy() {
		pool.shutdown();
	}

	public static void saveSysLog(SysLog log) {
		pool.execute(new SysLogThread(log));
	}
}

class SysLogThread implements Runnable {

	private SysLog log;
	private SysLogDao sysLogDao = null;

	public SysLogThread(SysLog log) {
		this.log = log;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			if (sysLogDao == null) {
				sysLogDao = (SysLogDao) DatabaseHelper.getBean(SysLogDao.class);
			}
			if (log != null) {
				log.setSource(1);
				SysLogParam param=sysLogDao.getSysLogParam(log.getUrl(),1);
				if(null !=param){
					log.setMenuname(param.getMenuName());
					log.setOpername(param.getOperName());
				}
				sysLogDao.saveSysLog(log);
			}
		} catch (InterruptedException e) {
		
		}
	}

}