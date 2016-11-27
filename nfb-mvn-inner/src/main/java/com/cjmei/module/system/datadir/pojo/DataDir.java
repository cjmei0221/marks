package com.cjmei.module.system.datadir.pojo;

import java.io.Serializable;
import java.util.Date;

public class DataDir implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
    *主键
    */
    private String ckey;
    /**
    *父主键
    */
    private String parentkey;
    /**
    *主键值
    */
    private String cvalue;
    /**
    *公司ID
    */
    private String typename;
    /**
    *排序
    */
    private int sort;
    /**
    *创建时间
    */
    private String createtime;
    /**
    *更新时间
    */
    private String updatetime;
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

    public String getParentkey(){
        return parentkey;
    }
    public void setParentkey(String parentkey){
        this.parentkey = parentkey;
    }

    public String getCvalue(){
        return cvalue;
    }
    public void setCvalue(String cvalue){
        this.cvalue = cvalue;
    }

    public String getTypename(){
        return typename;
    }
    public void setTypename(String typename){
        this.typename = typename;
    }

    public int getSort(){
        return sort;
    }
    public void setSort(int sort){
        this.sort = sort;
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

    public String getCreator(){
        return creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }


}