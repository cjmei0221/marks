package com.marks.module.wx.api.wxpay.mmpay.pojo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.marks.common.util.IDUtil;
import com.marks.common.util.date.DateUtil;
import com.marks.module.core.controller.SupportContorller;

public class CompanyRedPackReq {
	private String mch_appid;// 公众账号appid
	private String mchid;// 商户号
	private String nonce_str;// 随机字符串
	private String partner_trade_no;// 商户订单号
	private String openid;// 用户openid
	private String check_name;// 校验用户姓名选项NO_CHECK：不校验真实姓名  FORCE_CHECK：强校验真实姓名
	private String re_user_name;// 收款用户姓名
	private int amount;// 付款金额
	private String desc;//企业付款描述信息
	private String spbill_create_ip;// IP地址
	
	public CompanyRedPackReq(){
		nonce_str=IDUtil.getUUID();
		String dateStr = DateUtil.parseDate(new Date(), "yyyyMMddHHmmssS");
		int num = dateStr.length();
		String minu=System.currentTimeMillis()+"";
		String mch_billno = minu.substring(minu.length()-10, minu.length()) + dateStr.substring(0, 8) + "00" + dateStr.substring(num - 10, num);
		partner_trade_no=mch_billno;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	

	public String getSpbill_create_ip() {
		String ip="";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			
		}
		return ip;
	}

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map<String, String> toReqParam() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Field[] field = this.getClass().getDeclaredFields();
		String name = "";
		Method getMethod;
		for (int i = 0; i < field.length; i++) {
			name = field[i].getName();
			getMethod = this.getClass().getMethod("get" + SupportContorller.toUpperFirst(field[i].getName()));
			map.put(name, String.valueOf(getMethod.invoke(this)));
		}
		return map;
	}
	
	public SortedMap<String, String> getSortedMap() throws Exception {
		SortedMap<String, String> map = new TreeMap<String, String>();
		Field[] field = this.getClass().getDeclaredFields();
		String name = "";
		Method getMethod;
		for (int i = 0; i < field.length; i++) {
			name = field[i].getName();
			getMethod = this.getClass().getMethod("get" + SupportContorller.toUpperFirst(field[i].getName()));
			map.put(name, String.valueOf(getMethod.invoke(this)));
		}
		return map;
	}

	public static void main(String[] args) throws Exception {
		CompanyRedPackReq vo = new CompanyRedPackReq();
		
		
		SortedMap<String, String> map = vo.getSortedMap();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}
