package com.marks.smart.market.pay.alipay.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.smart.market.pay.alipay.pojo.AlipayLog;
@MapperScan
public interface AlipayDao{

	public void saveAlipayLog(@Param("log")AlipayLog log);

}
