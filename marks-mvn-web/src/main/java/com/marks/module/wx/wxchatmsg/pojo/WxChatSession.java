package com.marks.module.wx.wxchatmsg.pojo;

import java.io.Serializable;
import java.util.Date;

import com.marks.module.wx.enums.WXEnums;

public class WxChatSession implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *回话ID
    */
    private String session_id;
    /**
    *公众号ID
    */
    private String accountid;
    /**
    *OPENID
    */
    private String openid;
    /**
    *创建时间
    */
    private Date createtime;
    /**
    *创建时间戳
    */
    private long createLong;
    /**
    *更新时间
    */
    private Date updatetime;
    /**
    *内容
    */
    private String c_content;
    /**
    *结束时间
    */
    private Date endtime;
    /**
    *粉丝ID
    */
    private String fanId;

    private int flag = WXEnums.SessionType.AUTO.getValue();//0：非人工客服 1：人工客服

    private int sessionFlag=WXEnums.SessionType.AUTO.getValue();

    public int getSessionFlag() {
		return sessionFlag;
	}
	public void setSessionFlag(int sessionFlag) {
		this.sessionFlag = sessionFlag;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

    public String getSession_id(){
        return session_id;
    }
    public void setSession_id(String session_id){
        this.session_id = session_id;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public String getOpenid(){
        return openid;
    }
    public void setOpenid(String openid){
        this.openid = openid;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public long getCreateLong(){
        return createLong;
    }
    public void setCreateLong(long createLong){
        this.createLong = createLong;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getC_content(){
        return c_content;
    }
    public void setC_content(String c_content){
        this.c_content = c_content;
    }

    public Date getEndtime(){
        return endtime;
    }
    public void setEndtime(Date endtime){
        this.endtime = endtime;
    }

    public String getFanId(){
        return fanId;
    }
    public void setFanId(String fanId){
        this.fanId = fanId;
    }


	public String toLog(){
		return " - session_id:" +String.valueOf(session_id)+" - accountid:" +String.valueOf(accountid)+" - openid:" +String.valueOf(openid)+" - createtime:" +String.valueOf(createtime)+" - createLong:" +String.valueOf(createLong)+" - updatetime:" +String.valueOf(updatetime)+" - c_content:" +String.valueOf(c_content)+" - endtime:" +String.valueOf(endtime)+" - fanId:" +String.valueOf(fanId);
	}
}