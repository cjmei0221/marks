package com.marks.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.marks.common.annotation.JsonObject;
import com.marks.common.annotation.JsonObjectProperty;
import com.marks.common.annotation.JsonProperty;

@JsonObject
public class Result implements Serializable {

	private static final long serialVersionUID = -6963503022738848863L;

	private int code=0;
	private String message;
	
	//其它数据项
	private Map<String,Object> data = new HashMap<String,Object>();
	
	public Result(){
		
	}
	
	public Result(int code){
		this.code=code;
	}
	
	@JsonProperty(name="retcode")
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@JsonProperty(name="retmsg")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonObjectProperty
	public Map<String, Object> getData() {
		return data;
	}
	
	
}
