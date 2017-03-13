package com.marks.module.wxfwhao.wxmodulemsg.job;

import org.apache.log4j.Logger;

import com.marks.module.wxfwhao.wxmodulemsg.thread.pool.WxModuleMsgThreadPool;

public class WxbModuleMsgHelper {
	private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);

	public void doJob() {
		/* log.info("开始推送模板消息"); */
		/*WxbModuleMsgService wxbModuleMsgService = (WxbModuleMsgService) DatabaseHelper
				.getBean(WxbModuleMsgService.class);
		wxbModuleMsgService.pustWxbModuleMsg();*/
		WxModuleMsgThreadPool.scanModuleMsgThread();
	}
}
