package com.marks.module.pay.alipay.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.pay.alipay.pojo.AlipayLog;
@MapperScan
public interface AlipayDao{

	public void saveAlipayLog(@Param("log")AlipayLog log);

}
