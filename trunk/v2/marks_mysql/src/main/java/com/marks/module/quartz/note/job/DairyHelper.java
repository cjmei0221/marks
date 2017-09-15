package com.marks.module.quartz.note.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.module.inner.wx.wxuser.dao.WxUserDao;
import com.marks.module.quartz.note.thread.pool.NoteThreadPool;
import com.marks.module.sys.common.SpringContextHolder;
import com.marks.module.wxapi.wxfwhao.common.entity.WxUser;

public class DairyHelper extends QuartzJobBean {

	public void doJob() {
		WxUserDao wxUserDao = (WxUserDao) SpringContextHolder.getBean(WxUserDao.class);
		List<WxUser> list = wxUserDao.findWxUserListForDairy();
		if (null != list && list.size() > 0) {
			for (WxUser wxUser : list) {
				NoteThreadPool.pushDairyWxMsg(wxUser);
			}
		}

	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		doJob();
	}

}
