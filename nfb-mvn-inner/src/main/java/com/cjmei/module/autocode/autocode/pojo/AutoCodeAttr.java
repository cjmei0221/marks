package com.cjmei.module.autocode.autocode.pojo;

import java.io.Serializable;

public class AutoCodeAttr implements Serializable{

    private static final long serialVersionUID = 1L;
	private String attrName;
	private String attrType="String";
	private int isPK=0;
	private String seq;
	private int attrSize = 50;
	private String attrDesc;
	private String tableName;
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	public int getIsPK() {
		return isPK;
	}
	public void setIsPK(int isPK) {
		this.isPK = isPK;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getAttrSize() {
		return attrSize;
	}
	public void setAttrSize(int attrSize) {
		this.attrSize = attrSize;
	}
	public String getAttrDesc() {
		return attrDesc;
	}
	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
