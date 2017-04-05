package com.marks.module.center.wxfwhao.redPack.pojo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.marks.module.inner.system.sys.controller.SupportContorller;

public class RedPackReq {

	private String id;
	private String nonce_str;// 随机字符串
	private String sign;// 签名
	private String mch_billno;// 商户订单号
	private String mch_id;// 商户号
	private String wxappid;// 公众账号appid
	private String send_name;// 商户名称
	private String re_openid;// 用户openid
	private String total_amount;// 付款金额
	private String total_num;// 红包发放总人数
	private String wishing;// 红包祝福语
	private String client_ip;// IP地址
	private String act_name;// 活动名称
	private String remark;// 备注
	/**
	 * 发放红包使用场景，红包金额大于200时必传 PRODUCT_1:商品促销 PRODUCT_2:抽奖 PRODUCT_3:虚拟物品兑奖
	 * PRODUCT_4:企业内部福利 PRODUCT_5:渠道分润 PRODUCT_6:保险回馈 PRODUCT_7:彩票派奖
	 * PRODUCT_8:税务刮奖
	 */
	private String scene_id;// 可为空
	private String risk_info;// 可为空
	private String consume_mch_id;// 可为空
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMch_billno() {
		return mch_billno;
	}
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getWxappid() {
		return wxappid;
	}
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getRe_openid() {
		return re_openid;
	}
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getTotal_num() {
		return total_num;
	}
	public void setTotal_num(String total_num) {
		this.total_num = total_num;
	}
	public String getWishing() {
		return wishing;
	}
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getScene_id() {
		return scene_id;
	}
	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}
	public String getRisk_info() {
		return risk_info;
	}
	public void setRisk_info(String risk_info) {
		this.risk_info = risk_info;
	}
	public String getConsume_mch_id() {
		return consume_mch_id;
	}
	public void setConsume_mch_id(String consume_mch_id) {
		this.consume_mch_id = consume_mch_id;
	}
	
	public Map<String, String> toReqParam(RedPackReq vo) throws Exception{
		Map<String, String> map=new HashMap<String,String>();
		Field[] field=vo.getClass().getDeclaredFields();
		String name="";
		Method getMethod;
		for(int i=0;i<field.length;i++){
			name=field[i].getName();
			getMethod = vo.getClass().getMethod("get" + SupportContorller.toUpperFirst(field[i].getName()));
			map.put(name, String.valueOf(getMethod.invoke(vo)));
		}
		return map;
	}
	public static void main(String[] args) throws Exception {
		RedPackReq vo=new RedPackReq();
		vo.setAct_name("234");
		vo.setClient_ip("125.230.2");
		Map<String, String> map=vo.toReqParam(vo);
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}

}
