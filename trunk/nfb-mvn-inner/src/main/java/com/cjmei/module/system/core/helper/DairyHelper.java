package com.cjmei.module.system.core.helper;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cjmei.module.note.diary.threadPool.DairyThreadPool;
import com.cjmei.module.system.core.listener.DatabaseHelper;
import com.cjmei.module.wx.wxuser.dao.WxUserDao;
import com.cjmei.module.wx.wxuser.pojo.WxUser;

public class DairyHelper extends QuartzJobBean {

	public void doJob() {
		WxUserDao wxUserDao = (WxUserDao) DatabaseHelper.getBean(WxUserDao.class);
		List<WxUser> list = wxUserDao.findWxUserListForDairy();
		if (null != list && list.size() > 0) {
			for (WxUser wxUser : list) {
				DairyThreadPool.pushDairyWxMsg(wxUser);
			}
		}

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}

}
