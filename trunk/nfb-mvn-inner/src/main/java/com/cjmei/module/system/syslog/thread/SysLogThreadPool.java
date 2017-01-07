package com.cjmei.module.system.syslog.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.sys.dao.SysLogDao;
import com.cjmei.module.system.sys.pojo.SysLog;

/**
 * 系统日志记录线程池
 * File Name: com.grgbanking.inner.thread.SysLogThreadPool.java
 * 
 * @author:cjmei0221@163.com
 * @Date:2016年7月26日上午11:51:06
 * @see (optional) 
 * @Copyright (c) 2016, cjmei  All Rights Reserved.
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

class SysLogThread implements Runnable{

	private SysLog log;
	private SysLogDao sysLogDao=null;
	public SysLogThread(SysLog log){
		this.log=log;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			if(sysLogDao==null){
				sysLogDao=(SysLogDao) DatabaseHelper.getBean(SysLogDao.class);
			}
			if(log !=null){
				List<SysLog> logc=sysLogDao.getSysLogParam(log.getUrl());
				if(null != logc && logc.size()>0){
					log.setMenuname(logc.get(0).getMenuname());
					log.setOpername(logc.get(0).getOpername());
					sysLogDao.saveSysLog(log);
				}else if("/sys/login".equals(log.getUrl())){
					log.setMenuname("登录管理");
					log.setOpername("登录");
					sysLogDao.saveSysLog(log);
				}
			}
		} catch (InterruptedException e) {
		
		}
	}
	
}