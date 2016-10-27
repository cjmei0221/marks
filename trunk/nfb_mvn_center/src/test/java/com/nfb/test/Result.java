package com.nfb.test;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.nfb.common.annotation.JsonObject;
import com.nfb.common.annotation.JsonObjectProperty;
import com.nfb.common.annotation.JsonProperty;

/**
 * 调用接口响应结果类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
@JsonObject
public class Result implements Serializable {

	private static final long serialVersionUID = -6963503022738848863L;

	private int code=0;
	private String message="success";
	
	//其它数据项
	private Map<String,Object> data = new LinkedHashMap<String,Object>();
	
	/**
	 * 获取属性：返回码
	 * 
	 * @return
	 */
	@JsonProperty(name="retcode")
	public int getCode() {
		return code;
	}
	
	/**
	 * 设置属性： 返回码
	 * 
	 * @param
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * 获取属性：返回信息
	 * 
	 * @return
	 */
	@JsonProperty(name="retmsg")
	public String getMessage() {
		return message;
	}
	
	/**
	 * 设置属性：返回信息
	 * 
	 * @param
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 获取属性：其它数据项
	 * 
	 * @return
	 */
	@JsonObjectProperty
	public Map<String, Object> getData() {
		return data;
	}
	
	@Override
	public String toString() {
		String result = "[code:"+this.code+"]"
				+ "[message:" + this.message+"]"
				+ "[data:" + this.data.toString()+"]";
		return result;
	}
}
