package com.cjmei.module.wx.modulemsg.pojo;

import net.sf.json.JSONObject;

public class Msg {

	private String color="#000000";
	private String value;
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
