package com.marks.module.web.pay.alipay.dao;

import org.apache.ibatis.annotations.Param;

import com.marks.module.web.pay.alipay.pojo.AlipayLog;

public interface AlipayDao{

	public void saveAlipayLog(@Param("log")AlipayLog log);

}
