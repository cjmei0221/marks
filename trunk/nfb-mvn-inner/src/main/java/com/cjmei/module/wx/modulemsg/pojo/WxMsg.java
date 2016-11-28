package com.cjmei.module.wx.modulemsg.pojo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class WxMsg {

	private String first;

	private List<Msg> keywordList = new ArrayList<Msg>();

	private String remark;

	public Msg getFirst() {
		Msg	msg = new Msg();
		msg.setValue(first);
		return msg;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public List<Msg> getKeywordList() {
		return keywordList;
	}

	public void addKeyword(String keyword) {
		Msg msg = new Msg();
		msg.setValue(keyword);
		this.keywordList.add(msg);
	}

	public Msg getRemark() {
		Msg msg = new Msg();
		msg.setValue(remark);
		return msg;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toJsonString() {
		JSONObject obj = new JSONObject();
		obj.put("first", this.getFirst().toJsonString());
		if (keywordList.size() > 0) {
			for (int i = 0; i < keywordList.size(); i++) {
				obj.put("keyword" + (i + 1), keywordList.get(i).toJsonString());
			}
		}
		obj.put("remark", this.getRemark().toJsonString());
		return obj.toString();
	}

}
