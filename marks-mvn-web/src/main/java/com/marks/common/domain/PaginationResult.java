package com.cjmei.common.domain;

import com.cjmei.common.annotation.JsonObject;
import com.cjmei.common.annotation.JsonProperty;

/**
 * 分页结果输出类
 * 
 * @author cypei
 * @createTime 
 * @history  1.修改时间,修改;修改内容：
 * 
 */
@JsonObject
public class PaginationResult extends Result {

	private static final long serialVersionUID = -5135438820938730507L;

	//页大小
	private int pageSize = 10;
	
	//总记录数
	private int totalCount = 0;
	
	//当前页号
	private int pageNumber = 1;
	
	//总页数
	private int pageTotal = 0;

	@JsonProperty(name="page_number")
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty(name="page_size")
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@JsonProperty(name="total_count")
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@JsonProperty(name="page_total")
	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	
}
