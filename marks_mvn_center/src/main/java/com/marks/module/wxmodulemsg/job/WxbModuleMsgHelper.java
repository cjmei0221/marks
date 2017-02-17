package com.nfb.module.wxmodulemsg.job;

import org.apache.log4j.Logger;

import com.nfb.module.system.listener.DatabaseHelper;
import com.nfb.module.wxmodulemsg.service.WxbModuleMsgService;

public class WxbModuleMsgHelper {
	private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);

	public void doJob() {
		/* log.info("开始推送模板消息"); */
		WxbModuleMsgService wxbModuleMsgService = (WxbModuleMsgService) DatabaseHelper
				.getBean(WxbModuleMsgService.class);
		wxbModuleMsgService.pustWxbModuleMsg();
	}
}
