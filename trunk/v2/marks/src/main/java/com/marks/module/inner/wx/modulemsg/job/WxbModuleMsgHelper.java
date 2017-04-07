package com.marks.module.inner.wx.modulemsg.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.module.inner.wx.modulemsg.thread.pool.WxModuleMsgThreadPool;

public class WxbModuleMsgHelper extends QuartzJobBean{
	private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);

	public void doJob() {
		WxModuleMsgThreadPool.scanModuleMsgThread();
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}
}
