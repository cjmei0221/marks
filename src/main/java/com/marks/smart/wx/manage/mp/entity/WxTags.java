package com.marks.smart.wx.manage.mp.entity;

import java.io.Serializable;
import java.util.Date;

public class WxTags implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *标签编号
    *
    */
    private String id;
    /**
    *标签名称
    *
    */
    private String name;
    /**
    *粉丝数量
    *
    */
    private int fans_count;
    /**
    *创建时间
    *
    */
    private Date createtime;
    /**
    *更新时间
    *
    */
    private Date updatetime;
    /**
    *更新者
    *
    */
    private String updater;
    /**
    *公众号ID
    *
    */
    private String accountid;
    /**
    *标签ID
    *
    */
    private int tagid;

	private String companyId;



	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getFans_count(){
        return fans_count;
    }
    public void setFans_count(int fans_count){
        this.fans_count = fans_count;
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

    public String getUpdater(){
        return updater;
    }
    public void setUpdater(String updater){
        this.updater = updater;
    }

    public String getAccountid(){
        return accountid;
    }
    public void setAccountid(String accountid){
        this.accountid = accountid;
    }

    public int getTagid(){
        return tagid;
    }
    public void setTagid(int tagid){
        this.tagid = tagid;
    }


	public String toLog(){
		return " - id:" +String.valueOf(id)+" - name:" +String.valueOf(name)+" - fans_count:" +String.valueOf(fans_count)+" - createtime:" +String.valueOf(createtime)+" - updatetime:" +String.valueOf(updatetime)+" - updater:" +String.valueOf(updater)+" - accountid:" +String.valueOf(accountid)+" - tagid:" +String.valueOf(tagid);
	}
}