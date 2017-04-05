package com.marks.module.inner.system.syslog.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.marks.module.inner.system.syslog.dao.SysLogDao;
import com.marks.module.inner.system.syslog.pojo.SysLog;
import com.marks.module.inner.system.syslogparam.pojo.SysLogParam;
import com.marks.module.sys.system.core.listener.DatabaseHelper;

/**
 * 系统日志记录线程池
 * File Name: com.grgbanking.inner.thread.SysLogThreadPool.java
 * 
 * @author:marks0221@163.com
 * @Date:2016年7月26日上午11:51:06
 * @see (optional) 
 * @Copyright (c) 2016, marks  All Rights Reserved.
 */
public class SysLogThreadPool {

	private static ExecutorService pool;

	public static void init() {
		pool = Executors.newFixedThreadPool(10);// 开5个线程处理消息推送
	}

	public static void destroy() {
		pool.shutdown();
	}
	public static void saveSysLog(boolean isAlone,SysLog log) {
		pool.execute(new SysLogThread(isAlone,log));
	}
}

class SysLogThread implements Runnable{

	private SysLog log;
	private boolean isAlone;
	private SysLogDao sysLogDao=null;
	public SysLogThread(boolean isAlone,SysLog log){
		this.isAlone=isAlone;
		this.log=log;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			if(sysLogDao==null){
				sysLogDao=(SysLogDao) DatabaseHelper.getBean(SysLogDao.class);
			}
			if(log==null){
				return;
			}
			if(log.getSource()==0 && isAlone){
				sysLogDao.saveSysLog(log);
				return;
			}
			if(log.getSource()==0 && !isAlone){
				List<SysLog> logc=sysLogDao.getSysLogParam(log.getUrl());
				if(null != logc && logc.size()>0){
					log.setMenuname(logc.get(0).getMenuname());
					log.setOpername(logc.get(0).getOpername());
					sysLogDao.saveSysLog(log);
				}
				return;
			}
			SysLogParam param=sysLogDao.getSysLogParamNoForInner(log.getUrl(),log.getSource());
			if(null !=param){
				log.setMenuname(param.getMenuName());
				log.setOpername(param.getOperName());
			}
			sysLogDao.saveSysLog(log);
			
		} catch (InterruptedException e) {
		
		}
	}
	
}