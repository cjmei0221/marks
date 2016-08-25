package com.grgbanking.inner.helper;

import org.apache.log4j.Logger;

import com.grgbanking.inner.listener.DatabaseHelper;
import com.grgbanking.inner.service.LoadDataService;

/**
 * 将基础数据加载到缓存中
 * 
 * @author cjmei
 *
 */
public class LoadDataHelper {
	private static Logger logger = Logger.getLogger(LoadDataHelper.class);

	public void doJob() {
		logger.info("开始加载缓存数据");
		LoadDataService loadDataService = (LoadDataService) DatabaseHelper.getBean(LoadDataService.class);
		/**
		 * 加载系统参数到缓存
		 */
		loadDataService.loadSysConf();
		/**
		 * 加载数据字典
		 */
		loadDataService.loadDataDir();
		/**
		 * 加载微信公众号信息
		 */
		loadDataService.loadWxAccount();

		logger.info("结束加载缓存数据");

	}
}
