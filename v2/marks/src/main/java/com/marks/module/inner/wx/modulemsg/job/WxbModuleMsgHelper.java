package com.marks.module.inner.wx.modulemsg.job;

import org.apache.log4j.Logger;

import com.marks.module.inner.wx.modulemsg.thread.pool.WxModuleMsgThreadPool;

public class WxbModuleMsgHelper {
	private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);

	public void doJob() {
		WxModuleMsgThreadPool.scanModuleMsgThread();
	}
}
