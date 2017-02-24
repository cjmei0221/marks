package com.marks.module.system.syslog.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.system.syslog.dao.SysLogDao;
import com.marks.module.system.syslog.pojo.SysLog;
import com.marks.module.system.syslog.pojo.SysLogParam;

/**
 * 系统日志记录线程池 File Name: com.grgbanking.inner.thread.SysLogThreadPool.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月26日上午11:51:06
 * @see (optional)
 * @Copyright (c) 2016, marks All Rights Reserved.
 */
public class SysLogThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(10);// 开5个线程处理消息推送
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
				log.setSource(2);
				SysLogParam param=sysLogDao.getSysLogParam(log.getUrl(),2);
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