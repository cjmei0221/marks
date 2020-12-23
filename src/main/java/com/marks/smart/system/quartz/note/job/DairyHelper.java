package com.marks.smart.system.quartz.note.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.marks.smart.system.core.common.SpringContextHolder;
import com.marks.smart.system.quartz.note.thread.pool.NoteThreadPool;
import com.marks.smart.wx.api.mp.wxInteface.user.entity.WxUser;
import com.marks.smart.wx.manage.mp.dao.WxUserDao;

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
