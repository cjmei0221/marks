package com.marks.module.system.core.helper;

import org.apache.log4j.Logger;

import com.marks.module.system.core.listener.DatabaseHelper;
import com.marks.module.wxfwhao.common.service.WxAccountService;

/**
 * 定时加载数据助手类
 * @author cypei
 *
 */
public class TimingLoadingHelper {

private static final Logger log = Logger.getLogger(TimingLoadingHelper.class);
	
	public void doJob(){
		
		WxAccountService wxAccountService=(WxAccountService) DatabaseHelper.getBean(WxAccountService.class);
		log.info("开始加载微信服务号信息");
		wxAccountService.loadData();
	}
}
