package com.cjmei.common.domain;

import java.util.List;

/**
 * 通用模型对象
 * 
 * @author 
 * @createTime
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class PojoDomain<T> {
	private List<T> pojolist;
	private int page_number;
	private int page_size;
	private int total_count;
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public List<T> getPojolist() {
		return pojolist;
	}
	public void setPojolist(List<T> pojolist) {
		this.pojolist = pojolist;
	}
	public int getPage_total() {
		return (this.total_count + page_size -1) / page_size;
	}
	
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	
}
