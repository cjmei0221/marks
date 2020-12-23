package com.marks.smart.system.quartz.clear.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.system.system.syslog.service.SysLogService;
import com.marks.smart.wx.manage.mp.service.ModuleMsgService;

/**
 * 将基础数据加载到缓存中
 * 
 * @author marks
 *
 */
public class ClearHelper  extends QuartzJobBean{
	private static Logger logger = Logger.getLogger(ClearHelper.class);

	public void doJob() {
		logger.info("开始清除数据");
		SysLogService sysLogService = (SysLogService) SpringContextHolder.getBean(SysLogService.class);
		sysLogService.clearData();
		ModuleMsgService moduleMsgService = (ModuleMsgService) SpringContextHolder.getBean(ModuleMsgService.class);
		moduleMsgService.clearData();
		logger.info("结束清除数据");

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}
}
