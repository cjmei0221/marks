package com.marks.smart.market.mall.pay.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class PayAcct implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *主键
    *
    */
    private String id;
    /**
    *公司ID
    *
    */
    private String companyId;
    /**
    *支付方式编号
    *OrderUtil中PayType枚举
    */
    private String payTypeCode;
    /**
    *支付方式
    *
    */
    private String payType;
    /**
    *商户号
    *
    */
    private String mch_id;
    /**
    *密钥1
    *微信支付中的密钥
    */
    private String key1;
    /**
    *密钥2
    *微信支付中的密码
    */
    private String key2;
    /**
    *商户名
    *
    */
    private String mch_name;
    /**
    *证书文件路径
    *
    */
    private String keyStorePath;
    /**
    *公众号ID
    *
    */
    private String accountId;
    /**
    *创建时间
    *
    */
    private String createtime;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *支付方式主键
    *支付方式表主键
    */
    private String payTypeId;


 public PayAcct(){
    this.createtime=DateUtil.getCurrDateStr();
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getPayTypeCode(){
        return payTypeCode;
    }
    public void setPayTypeCode(String payTypeCode){
        this.payTypeCode = payTypeCode;
    }

    public String getPayType(){
        return payType;
    }
    public void setPayType(String payType){
        this.payType = payType;
    }

    public String getMch_id(){
        return mch_id;
    }
    public void setMch_id(String mch_id){
        this.mch_id = mch_id;
    }

    public String getKey1(){
        return key1;
    }
    public void setKey1(String key1){
        this.key1 = key1;
    }

    public String getKey2(){
        return key2;
    }
    public void setKey2(String key2){
        this.key2 = key2;
    }

    public String getMch_name(){
        return mch_name;
    }
    public void setMch_name(String mch_name){
        this.mch_name = mch_name;
    }

    public String getKeyStorePath(){
        return keyStorePath;
    }
    public void setKeyStorePath(String keyStorePath){
        this.keyStorePath = keyStorePath;
    }

    public String getAccountId(){
        return accountId;
    }
    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    public String getCreatetime(){
        return createtime;
    }
    public void setCreatetime(String createtime){
        this.createtime = createtime;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getPayTypeId(){
        return payTypeId;
    }
    public void setPayTypeId(String payTypeId){
        this.payTypeId = payTypeId;
    }


	public String toLog(){
		return " - id:" +String.valueOf(id)+" - companyId:" +String.valueOf(companyId)+" - payTypeCode:" +String.valueOf(payTypeCode)+" - payType:" +String.valueOf(payType)+" - mch_id:" +String.valueOf(mch_id)+" - key1:" +String.valueOf(key1)+" - key2:" +String.valueOf(key2)+" - mch_name:" +String.valueOf(mch_name)+" - keyStorePath:" +String.valueOf(keyStorePath)+" - accountId:" +String.valueOf(accountId)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - payTypeId:" +String.valueOf(payTypeId);
	}
}