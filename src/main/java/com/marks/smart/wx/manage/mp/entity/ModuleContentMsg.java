package com.marks.smart.wx.manage.mp.entity;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class ModuleContentMsg {

	private String first;

	private List<Msg> keywordList=new ArrayList<Msg>();
	
	private String remark;
	
	public String toJsonStringByKey(){
		JSONObject obj=new JSONObject();
		obj.put("first",new Msg(first).toJsonString());
		if(keywordList.size()>0){
			for(int i=0;i<keywordList.size();i++){
				obj.put(keywordList.get(i).getKey(), keywordList.get(i).toJsonString());
			}
		}
		obj.put("remark", new Msg(remark).toJsonString());
		return obj.toString();
	}
	


	public List<Msg> getKeywordList() {
		return keywordList;
	}

	public void addKeyword(Msg keyword) {
		this.keywordList.add(keyword);
	}



	public String getFirst() {
		return first;
	}



	public void setFirst(String first) {
		this.first = first;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public void setKeywordList(List<Msg> keywordList) {
		this.keywordList = keywordList;
	}
	
}
