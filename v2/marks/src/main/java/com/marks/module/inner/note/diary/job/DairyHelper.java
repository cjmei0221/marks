package com.marks.module.inner.note.diary.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.module.inner.note.diary.threadPool.DairyThreadPool;
import com.marks.module.inner.wx.wxuser.dao.WxUserDao;
import com.marks.module.inner.wx.wxuser.pojo.WxUser;
import com.marks.module.sys.system.core.listener.DatabaseHelper;

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
