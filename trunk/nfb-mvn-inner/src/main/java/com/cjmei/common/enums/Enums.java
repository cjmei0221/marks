package com.cjmei.common.enums;

/**
 * 枚举
 * @author lhyan3
 * 2015年2月5日上午10:46:04
 */
public class Enums {
	/**
	 * 机构类型
	 * @author cjmei
	 *
	 */
	public enum Shop{
		shop(0),//商铺
		company(1);//公司

		private int status;
		
		private Shop(int status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public int getValue(){
			return status;
		}
	}
	/**
	 * 领券渠道
	 * File Name: com.grgbanking.gbot.enums.Enums.java
	 * 
	 * @author:cjmei@grgbanking.com
	 * @Date:2016年8月25日下午4:42:38
	 * @see (optional) 
	 * @Copyright (c) 2016, 广电运通信息科技有限公司  All Rights Reserved.
	 */
	public enum CouponChannel{
		qrcode("qrcode"),//扫描二维码
		normal("normal");//店铺领取

		private String status;
		
		private CouponChannel(String status){
			this.status = status;
		}
		
		public String toString(){
			return status;
		}
		public String getValue(){
			return status;
		}
	}
	
	public enum OrderStatus{
		buy(11),//购买
		commit(0),//提交订单
		check_fail(2),//审核不通过
		nopay(3), //审核通过即未支付
		pregoods(5),//支付成功即备货中
		sendgoods(6),//送货中
		success(7),//订单成功
		cancel(8),//取消订单
		backing(9),//退货中
		backok(10);//退货完成
		
		
		private int status;
		
		private OrderStatus(int status){
			this.status = status;
		}
		
		public String toString(){
			return String.valueOf(status);
		}
		public int getValue(){
			return status;
		}
	}
}
