package com.marks.smart.market.pay.alipay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marks.smart.market.pay.alipay.dao.AlipayDao;
import com.marks.smart.market.pay.alipay.pojo.AlipayLog;
import com.marks.smart.market.pay.alipay.service.AlipayService;

@Service
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
