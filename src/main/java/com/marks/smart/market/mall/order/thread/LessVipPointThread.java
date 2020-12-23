package com.marks.smart.market.mall.order.thread;

import com.marks.smart.count.acct.ext.pojo.PointLog;
import com.marks.smart.count.acct.ext.service.AcctService;
import com.marks.smart.system.core.common.SpringContextHolder;

public class LessVipPointThread implements Runnable{

	private PointLog log;
	private AcctService acctService;
	public LessVipPointThread(PointLog log) {
		this.log=log;
	}
	@Override
	public void run() {
		try {
			if(acctService==null) {
				acctService=SpringContextHolder.getBean(AcctService.class);
			}
			Thread.sleep(3000);
			acctService.savePoint(log);
		} catch (InterruptedException e) {
			
		}
		
	}

}
