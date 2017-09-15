package com.marks.module.sys.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.module.inner.org.orginfo.pojo.OrgInfo;
import com.marks.module.inner.org.orginfo.service.OrgInfoService;
import com.marks.module.inner.system.sys.service.LoadDataService;
import com.marks.module.sys.common.SpringContextHolder;
import com.marks.module.sys.data.StaticData;

/**
 * 将基础数据加载到缓存中
 * 
 * @author marks
 *
 */
public class LoadDataHelper  extends QuartzJobBean{
	private static Logger logger = Logger.getLogger(LoadDataHelper.class);

	public void doJob() {
		logger.info("开始加载缓存数据");
		LoadDataService loadDataService = (LoadDataService) SpringContextHolder.getBean(LoadDataService.class);
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

		OrgInfoService orgInfoService = (OrgInfoService) SpringContextHolder.getBean(OrgInfoService.class);
		List<OrgInfo> orgInfoList=orgInfoService.findAll();
		StaticData.putOrgInfoList(orgInfoList);
		logger.info("结束加载缓存数据");

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}
}
