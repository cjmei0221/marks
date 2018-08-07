package com.marks.module.mall.order.service;


import java.util.List;
import java.util.Map;

import com.marks.common.domain.PojoDomain;
import com.marks.module.mall.order.pojo.OrderGood;
import com.marks.module.mall.order.pojo.OrderInfo;

public interface OrderInfoService{

	public OrderInfo findById(String orderId);
	public void delete(String id);
	public List<OrderInfo> findAll();
	public void deleteBatch(List<String> ids);
	public PojoDomain<OrderInfo> list(int page_number, int page_size,Map<String,Object> param);

	/**
	 * 获取订单编号
	 * 
	 * @return
	 */
	public String getOrderId();

	/**
	 * 保存订单
	 * 
	 * @param info
	 * @param goodList
	 */
	public void saveOrder(OrderInfo info, List<OrderGood> goodList, List<String> barCodeList);

	/**
	 * 充值
	 * 
	 * @param info
	 */
	public void saveRecharge(OrderInfo info);

	/**
	 * 退货
	 * 
	 * @param info
	 * @param goodList
	 * @param barCodeList
	 */
	public void saveRefund(OrderInfo info, List<OrderGood> goodList, List<String> barCodeList);
}