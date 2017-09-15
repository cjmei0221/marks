package com.marks.module.wxapi.wxfwhao.common.entity;

import java.util.List;

public class BatchgetMaterial {
	private String media_id;
	private String update_time;
	private List<UploadNews> UploadNews;
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public List<UploadNews> getUploadNews() {
		return UploadNews;
	}
	public void setUploadNews(List<UploadNews> uploadNews) {
		UploadNews = uploadNews;
	}
	
}
