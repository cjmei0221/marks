package com.marks.module.web.pay.unionpay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.marks.module.web.pay.unionpay.pojo.UnionPayLog;
@MapperScan
public interface UnionPayDao{

	UnionPayLog getUnionPayLogByOrderId(@Param("orderId")String orderId);

	void saveUnionPayLog(@Param("msg")UnionPayLog unionPayMsg);

	void updateUnionPayLog(@Param("msg")UnionPayLog unionPayMsg);

	List<UnionPayLog> queryErrorMsg();

}
