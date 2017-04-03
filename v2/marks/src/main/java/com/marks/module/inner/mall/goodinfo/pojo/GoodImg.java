package com.marks.module.inner.mall.goodinfo.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class GoodImg implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String id;
	/**
	 * 商品ID
	 */
	private String goodId;
	/**
	 * 图片类型 1：主图 2：详图
	 */
	private int imgType;
	/**
	 * 图片路径
	 */
	private String imgUrl;
	/**
	 * 排序
	 */
	private int sort;
	
	private String imgName;
	
	

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public int getImgType() {
		return imgType;
	}

	public void setImgType(int imgType) {
		this.imgType = imgType;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}