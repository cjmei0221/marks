package com.marks.module.autocode.core.produced.pojo;

import java.io.Serializable;

/**
 * 输出结果
 * @author ykai5
 *
 */
public class OutPutFileResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5544510452569715631L;

	/**
	 * 输出结果
	 */
	private boolean susscess;
	

	/**
	 * 结果信息
	 */
	private String resultInfo;

	public boolean isSusscess() {
		return susscess;
	}

	public void setSusscess(boolean susscess) {
		this.susscess = susscess;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
	
}
