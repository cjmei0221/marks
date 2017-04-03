package com.marks.module.inner.wx.qrcode.pojo;

import java.io.Serializable;
import java.util.Date;

public class Qrcode implements Serializable{

    private static final long serialVersionUID = 1L;
    private String id;
    /**
    *标识
    */
    private String qrNo;
    /**
    *名称
    */
    private String qrName;
    /**
    *类型
    */
    private String qrType;
    /**
    *链接
    */
    private String qrUrl;
    /**
    *公众号ID
    */
    private String accountid;
    /**
    *图片路径
    */
    private String qrPath;
    /**
    *场景类型
    */
    private int sceneType;
    /**
    *创建时间
    */
    private Date createtime;
    /**
    *更新时间
    */
    private Date updatetime;
    /**
    *创建者
    */
    private String creator;

    private String companyId;


    public String getQrNo(){
        return qrNo;
    }
    public void setQrNo(String qrNo){
        this.qrNo = qrNo;
    }

    public String getQrName(){
        return qrName;
    }
    public void setQrName(String qrName){
        this.qrName = qrName;
    }

    public String getQrType(){
        return qrType;
    }
    public void setQrType(String qrType){
        this.qrType = qrType;
    }

    public String getQrUrl(){
        return qrUrl;
    }
    public void setQrUrl(String qrUrl){
        this.qrUrl = qrUrl;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public String getQrPath(){
        return qrPath;
    }
    public void setQrPath(String qrPath){
        this.qrPath = qrPath;
    }

    public int getSceneType(){
        return sceneType;
    }
    public void setSceneType(int sceneType){
        this.sceneType = sceneType;
    }

    public Date getCreatetime(){
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    public Date getUpdatetime(){
        return updatetime;
    }
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}