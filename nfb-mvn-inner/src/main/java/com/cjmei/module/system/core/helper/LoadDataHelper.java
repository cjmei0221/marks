package com.cjmei.module.system.core.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cjmei.module.system.core.data.StaticData;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.system.orginfo.pojo.OrgInfo;
import com.cjmei.module.system.orginfo.service.OrgInfoService;
import com.cjmei.module.system.sys.service.LoadDataService;

/**
 * 将基础数据加载到缓存中
 * 
 * @author cjmei
 *
 */
public class LoadDataHelper  extends QuartzJobBean{
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
		/**
		 * 加载权限控制的url
		 */
		loadDataService.loadUrlList();

		OrgInfoService orgInfoService = (OrgInfoService) DatabaseHelper.getBean(OrgInfoService.class);
		List<OrgInfo> orgInfoList=orgInfoService.findAll();
		StaticData.putOrgInfoList(orgInfoList);
		logger.info("结束加载缓存数据");

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}
}
