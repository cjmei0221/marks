package com.marks.smart.count.acct.info.pojo;

import java.io.Serializable;
import com.marks.common.util.date.DateUtil;

public class AcctInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    
   

    /**
    *系统编号
    *
    */
    private String userid;
    /**
    *用户编号
    *
    */
    private String userCode;
    /**
    *用户名称
    *
    */
    private String userName;
    /**
    *公司编号
    *
    */
    private String companyId;
    /**
    *可用余额
    *
    */
    private String balAmt;
    /**
    *冻结金额
    *
    */
    private String lockAmt;
    /**
    *总额
    *
    */
    private String totalAmt;
    /**
    *首次充值时间
    *
    */
    private String first_recharge_time;
    /**
    *最后充值时间
    *
    */
    private String last_recharge_time;
    /**
    *实充金额
    *
    */
    private String cashAmt;
    /**
    *赠送金额
    *
    */
    private String sendAmt;
    /**
    *更新时间
    *
    */
    private String updatetime;
    /**
    *累计实充金额
    *
    */
    private String grand_recharge_cashAmt;
    /**
    *累计赠送金额
    *
    */
    private String grand_recharge_sendAmt;


 public AcctInfo(){
    this.updatetime=DateUtil.getCurrDateStr();

    }


    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid){
        this.userid = userid;
    }

    public String getUserCode(){
        return userCode;
    }
    public void setUserCode(String userCode){
        this.userCode = userCode;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getCompanyId(){
        return companyId;
    }
    public void setCompanyId(String companyId){
        this.companyId = companyId;
    }

    public String getBalAmt(){
        return balAmt;
    }
    public void setBalAmt(String balAmt){
        this.balAmt = balAmt;
    }

    public String getLockAmt(){
        return lockAmt;
    }
    public void setLockAmt(String lockAmt){
        this.lockAmt = lockAmt;
    }

    public String getTotalAmt(){
        return totalAmt;
    }
    public void setTotalAmt(String totalAmt){
        this.totalAmt = totalAmt;
    }

    public String getFirst_recharge_time(){
        return first_recharge_time;
    }
    public void setFirst_recharge_time(String first_recharge_time){
        this.first_recharge_time = first_recharge_time;
    }

    public String getLast_recharge_time(){
        return last_recharge_time;
    }
    public void setLast_recharge_time(String last_recharge_time){
        this.last_recharge_time = last_recharge_time;
    }

    public String getCashAmt(){
        return cashAmt;
    }
    public void setCashAmt(String cashAmt){
        this.cashAmt = cashAmt;
    }

    public String getSendAmt(){
        return sendAmt;
    }
    public void setSendAmt(String sendAmt){
        this.sendAmt = sendAmt;
    }

    public String getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }

    public String getGrand_recharge_cashAmt(){
        return grand_recharge_cashAmt;
    }
    public void setGrand_recharge_cashAmt(String grand_recharge_cashAmt){
        this.grand_recharge_cashAmt = grand_recharge_cashAmt;
    }

    public String getGrand_recharge_sendAmt(){
        return grand_recharge_sendAmt;
    }
    public void setGrand_recharge_sendAmt(String grand_recharge_sendAmt){
        this.grand_recharge_sendAmt = grand_recharge_sendAmt;
    }


	public String toLog(){
		return " - userid:" +String.valueOf(userid)+" - userCode:" +String.valueOf(userCode)+" - userName:" +String.valueOf(userName)+" - companyId:" +String.valueOf(companyId)+" - balAmt:" +String.valueOf(balAmt)+" - lockAmt:" +String.valueOf(lockAmt)+" - totalAmt:" +String.valueOf(totalAmt)+" - first_recharge_time:" +String.valueOf(first_recharge_time)+" - last_recharge_time:" +String.valueOf(last_recharge_time)+" - cashAmt:" +String.valueOf(cashAmt)+" - sendAmt:" +String.valueOf(sendAmt)+" - updatetime:" +String.valueOf(updatetime)+" - grand_recharge_cashAmt:" +String.valueOf(grand_recharge_cashAmt)+" - grand_recharge_sendAmt:" +String.valueOf(grand_recharge_sendAmt);
	}
}