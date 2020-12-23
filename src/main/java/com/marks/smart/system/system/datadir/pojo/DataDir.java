package com.marks.smart.system.system.datadir.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private String companyId;
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

    private String idKey;

    private List<DataDir> children=new ArrayList<DataDir>();

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

   
    public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	public List<DataDir> getChildren() {
		return children;
	}
	public void setChildren(List<DataDir> children) {
		this.children = children;
	}
	
	public void addChildren(DataDir dd) {
		this.children.add(dd);
	}
	public String getIdKey() {
		return this.parentkey+"_"+this.ckey;
	}
	
	
}