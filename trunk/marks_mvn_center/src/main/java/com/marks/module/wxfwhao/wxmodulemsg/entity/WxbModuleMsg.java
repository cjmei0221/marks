package com.marks.module.wxfwhao.wxmodulemsg.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class WxbModuleMsg implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *id
    */
    private String id;
    /**
    *公众号ID
    */
    private String accountid;
    /**
    *微信模板ID
    */
    private String template_id;
    /**
    *接受人openid
    */
    private String touser;
    /**
    *模板链接
    */
    private String url;
    /**
    *模板内容
    */
    private String data;
    /**
    *是否需要发送标识
    */
    private Integer needflag;
    /**
    *发送标识
    */
    private Integer sendflag;
    /**
    *发送次数
    */
    private Integer sendtimes;
    /**
    *创建时间
    */
    private Timestamp createtime;
    /**
    *发送时间
    */
    private Timestamp sendtime;
    /**
    *微信msgid
    */
    private String msgid;
    /**
    *推送返回码
    */
    private String push_code;
    /**
    *推送返回信息
    */
    private String push_msg;
    /**
    *推送结果码
    */
    private String resultcode;
    /**
    *推送结果信息
    */
    private String resultMsg;

    private String note;
    
    private long create_stamp;
    
    public long getCreate_stamp() {
  		return create_stamp;
  	}
  	public void setCreate_stamp(long create_stamp) {
  		this.create_stamp = create_stamp;
  	}

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public String getTemplate_id(){
        return template_id;
    }
    public void setTemplate_id(String template_id){
        this.template_id = template_id;
    }

    public String getTouser(){
        return touser;
    }
    public void setTouser(String touser){
        this.touser = touser;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public Integer getNeedflag(){
        return needflag;
    }
    public void setNeedflag(Integer needflag){
        this.needflag = needflag;
    }

    public Integer getSendflag(){
        return sendflag;
    }
    public void setSendflag(Integer sendflag){
        this.sendflag = sendflag;
    }

    public Integer getSendtimes(){
        return sendtimes;
    }
    public void setSendtimes(Integer sendtimes){
        this.sendtimes = sendtimes;
    }

    public Timestamp getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Timestamp createtime){
        this.createtime = createtime;
    }

    public Timestamp getSendtime(){
        return sendtime;
    }
    public void setSendtime(Timestamp sendtime){
        this.sendtime = sendtime;
    }

    public String getMsgid(){
        return msgid;
    }
    public void setMsgid(String msgid){
        this.msgid = msgid;
    }

    public String getPush_code(){
        return push_code;
    }
    public void setPush_code(String push_code){
        this.push_code = push_code;
    }

    public String getPush_msg(){
        return push_msg;
    }
    public void setPush_msg(String push_msg){
        this.push_msg = push_msg;
    }

    public String getResultcode(){
        return resultcode;
    }
    public void setResultcode(String resultcode){
        this.resultcode = resultcode;
    }

    public String getResultMsg(){
        return resultMsg;
    }
    public void setResultMsg(String resultMsg){
        this.resultMsg = resultMsg;
    }
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}


}