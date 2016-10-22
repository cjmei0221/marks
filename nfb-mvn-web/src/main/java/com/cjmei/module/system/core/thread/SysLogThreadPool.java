package com.cjmei.module.system.core.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.sys.pojo.FrontLog;

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
		pool = Executors.newFixedThreadPool(5);// 开5个线程处理消息推送
	}

	public static void destroy() {
		pool.shutdown();
	}
	public static void saveSysLog(FrontLog log) {
		pool.execute(new SysLogThread(log));
	}
}

class SysLogThread implements Runnable{

	private FrontLog log;

	public SysLogThread(FrontLog log){
		this.log=log;
	}
	@Override
	public void run() {
		
	}
	
}