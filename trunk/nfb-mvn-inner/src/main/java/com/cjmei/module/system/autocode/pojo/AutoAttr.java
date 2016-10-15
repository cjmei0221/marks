package com.cjmei.module.system.autocode.pojo;

import java.io.Serializable;

/**
 * 属性集合
 * @author ykai5
 *
 */
public class AutoAttr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -432319913996043164L;

	/**
	 * 字段名
	 */
	private String attrName;
	
	/**
	 * 字段type类型
	 */
	private AttrType attrType;
	
	/**
	 * 是否主键
	 */
	
	private boolean isPK;
	
	/**
	 * 序列
	 */
	private String seq;
	
	/**
     * 字段长度
     */
    private int  attrSize;
    
    /**
     * 字段描述
     */
    private String attrDesc;
    
    public void initAttrDefault(){
    	this.setAttrDesc("");
    	this.setAttrName("");
    	this.setAttrSize(10);
    	this.setAttrType(AttrType.String);
    	this.setPK(false);
    	this.setSeq("");
    }
    
	
	public int getAttrSize() {
        return attrSize;
    }

    public void setAttrSize(int attrSize) {
        this.attrSize = attrSize;
    }

    public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	
	
	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public AttrType getAttrType() {
		return attrType;
	}

	public void setAttrType(AttrType attrType) {
		this.attrType = attrType;
	}

	public boolean isPK() {
		return isPK;
	}

	public void setPK(boolean isPK) {
		this.isPK = isPK;
	}

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }
	
    

}
