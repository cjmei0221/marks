package com.marks.module.wx.manage.template.pojo;

import net.sf.json.JSONObject;

public class Msg {

	private String color="#000000";
	private String value;
	private String key;
	public Msg(){
		
	}
	
	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Msg(String value){
		this.value=value;
	}
	public Msg(String value,String color){
		this.value=value;
		this.color=color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toJsonString(){
		JSONObject obj=new JSONObject();
		obj.put("value", value);
		obj.put("color", color);
		return obj.toString();
	}
}
