package com.marks.module.web.pay.wxpay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.marks.common.util.IDUtil;
import com.marks.module.web.pay.wxpay.dao.WXPayDao;
import com.marks.module.web.pay.wxpay.pojo.PayNotice;
import com.marks.module.web.pay.wxpay.pojo.WXPayRecord;
import com.marks.module.web.pay.wxpay.service.WXPayService;
public class WXPayServiceImpl implements WXPayService{
	@Autowired
	private WXPayDao wxPayDao;


	public WXPayDao getWxPayDao() {
		return wxPayDao;
	}

	public void setWxPayDao(WXPayDao wxPayDao) {
		this.wxPayDao = wxPayDao;
	}

	@Override
	public void savePayNotice(PayNotice notice) {
		wxPayDao.savePayNotice(notice);
	}

	@Override
	public void savePayRecord(WXPayRecord record) {
		record.setId(IDUtil.getUUID());
		wxPayDao.savePayRecord(record);
	}

}
