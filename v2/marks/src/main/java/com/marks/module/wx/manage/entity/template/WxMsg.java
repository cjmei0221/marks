package com.marks.module.wx.manage.entity.template;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class WxMsg {

	private String first;

	private List<String> keywordList = new ArrayList<String>();

	private String remark;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public List<String> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}

	public void addKeyword(String keyword) {
		this.keywordList.add(keyword);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toJsonString() {
		JSONObject obj = new JSONObject();
		obj.put("first", new Msg(first).toJsonString());
		if (keywordList.size() > 0) {
			for (int i = 0; i < keywordList.size(); i++) {
				obj.put("keyword" + (i + 1), new Msg(keywordList.get(i)).toJsonString());
			}
		}
		obj.put("remark", new Msg(remark).toJsonString());
		return obj.toString();
	}

}
