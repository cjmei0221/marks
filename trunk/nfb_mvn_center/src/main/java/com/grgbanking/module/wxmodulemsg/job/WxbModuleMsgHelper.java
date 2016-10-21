package com.grgbanking.module.wxmodulemsg.job;

import org.apache.log4j.Logger;

import com.grgbanking.module.system.listener.DatabaseHelper;
import com.grgbanking.module.wxmodulemsg.service.WxbModuleMsgService;

public class WxbModuleMsgHelper {
private static final Logger log = Logger.getLogger(WxbModuleMsgHelper.class);
	
	public void doJob(){
		log.info("开始推送模板消息");
		WxbModuleMsgService wxbModuleMsgService=(WxbModuleMsgService) DatabaseHelper.getBean(WxbModuleMsgService.class);
		wxbModuleMsgService.pustWxbModuleMsg();
	}
}
