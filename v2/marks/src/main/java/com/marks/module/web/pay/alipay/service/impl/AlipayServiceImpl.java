package com.marks.module.web.pay.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.marks.module.web.pay.alipay.dao.AlipayDao;
import com.marks.module.web.pay.alipay.pojo.AlipayLog;
import com.marks.module.web.pay.alipay.service.AlipayService;

public class AlipayServiceImpl implements AlipayService {
	@Autowired
	private AlipayDao alipayDao;
	
	

	public AlipayDao getAlipayDao() {
		return alipayDao;
	}



	public void setAlipayDao(AlipayDao alipayDao) {
		this.alipayDao = alipayDao;
	}



	@Override
	public void saveAlipayLog(AlipayLog log) {
		alipayDao.saveAlipayLog(log);
	}

}
