package com.marks.module.inner.wx.modulemsg.pojo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class ModuleContentMsg {

	private Msg firstmsg;

	private List<Msg> keywordList=new ArrayList<Msg>();
	
	private Msg remarkmsg;
	
	public String toJsonStringByKey(){
		JSONObject obj=new JSONObject();
		obj.put("first", firstmsg.toJsonString());
		if(keywordList.size()>0){
			for(int i=0;i<keywordList.size();i++){
				obj.put(keywordList.get(i).getKey(), keywordList.get(i).toJsonString());
			}
		}
		obj.put("remark", remarkmsg.toJsonString());
		return obj.toString();
	}
	
	public Msg getFirstmsg() {
		return firstmsg;
	}

	public void setFirstmsg(Msg firstmsg) {
		this.firstmsg = firstmsg;
	}

	public List<Msg> getKeywordList() {
		return keywordList;
	}

	public void addKeyword(Msg keyword) {
		this.keywordList.add(keyword);
	}

	public Msg getRemarkmsg() {
		return remarkmsg;
	}

	public void setRemarkmsg(Msg remarkmsg) {
		this.remarkmsg = remarkmsg;
	}
}
