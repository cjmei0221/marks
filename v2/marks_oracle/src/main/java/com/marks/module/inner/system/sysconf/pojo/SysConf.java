package com.marks.module.inner.system.sysconf.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysConf implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private String ckey;
    /**
    *主键值
    */
    private String cvalue;
    /**
    *主键描述
    */
    private String ckeyName;
    /**
    *公司ID
    */
    private String companyId;
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



    public String getCkey(){
        return ckey;
    }
    public void setCkey(String ckey){
        this.ckey = ckey;
    }

    public String getCvalue(){
        return cvalue;
    }
    public void setCvalue(String cvalue){
        this.cvalue = cvalue;
    }

    public String getCkeyName(){
        return ckeyName;
    }
    public void setCkeyName(String ckeyName){
        this.ckeyName = ckeyName;
    }

   

    public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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


}