package com.marks.module.wxfwhao.wxmodulemsg.job;

import org.apache.log4j.Logger;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wxfwhao.wxmodulemsg.service.WxbModuleMsgService;

public class WxbModuleMsgHelper {
	private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);

	public void doJob() {
		/* log.info("开始推送模板消息"); */
		WxbModuleMsgService wxbModuleMsgService = (WxbModuleMsgService) DatabaseHelper
				.getBean(WxbModuleMsgService.class);
		wxbModuleMsgService.pustWxbModuleMsg();
	}
}
