package com.marks.module.wx.api.wxInterface.pay.mmpay.pojo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.marks.module.core.controller.SupportContorller;

public class CompanyQueryRedPackReq {

	private String nonce_str;
	private String partner_trade_no;
	private String mch_id;
	private String appid;
	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	
	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getBill_type() {
		return "MCHT";
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

}
