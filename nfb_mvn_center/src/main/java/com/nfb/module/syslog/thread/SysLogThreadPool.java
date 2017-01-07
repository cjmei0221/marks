package com.nfb.module.syslog.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nfb.module.syslog.dao.SysLogDao;
import com.nfb.module.syslog.entity.SysLog;
import com.nfb.module.syslog.entity.SysLogParam;
import com.nfb.module.system.listener.DatabaseHelper;

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
		if (sysLogDao == null) {
			sysLogDao = (SysLogDao) DatabaseHelper.getBean(SysLogDao.class);
		}
		if (log != null) {
			SysLogParam param=sysLogDao.getSysLogParam(log.getUrl(),1);
			if(null !=param){
				log.setMenuname(param.getMenuName());
				log.setOpername(param.getOperName());
			}
			sysLogDao.saveSysLog(log);
		}
	}

}