package com.marks.module.web.pay.wxpay.service;

import com.marks.module.web.pay.wxpay.pojo.PayNotice;
import com.marks.module.web.pay.wxpay.pojo.WXPayRecord;

public interface WXPayService {

	/**
	 * 
	 * lhyan3
	 * 2015年3月14日下午3:59:25
	 * TODO
	 * @param notice
	 */
	void savePayNotice(PayNotice notice);
	
	/**
	 * 保存支付记录
	 * lhyan3
	 * 2015年4月16日下午3:43:25
	 * TODO
	 * @param record
	 */
	public void savePayRecord(WXPayRecord record);
	

}
