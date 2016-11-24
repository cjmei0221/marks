package com.nfb.module.wxfwhao.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信菜单对象类
 * @author ldyong
 *
 */
public class WxMenu{

	private String id;
	private String name;
	private String parent_id;
	private String type;
	private String content;
	private List<WxMenu> sub_button=new ArrayList<WxMenu>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<WxMenu> getSub_button() {
		return sub_button;
	}
	public void addSub_button(WxMenu sub_button) {
		this.sub_button.add(sub_button);
	}

}
