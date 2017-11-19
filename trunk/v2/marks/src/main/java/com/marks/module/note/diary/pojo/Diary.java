package com.marks.module.note.diary.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Diary implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 更新时间
	 */
	private String updatetime;
	/**
	 * 正文
	 */
	private String content;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 创建时间
	 */
	private String createtime;

	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(createtime);
	}
	public String getShortContent(){
        return content==null?"":content.split("<br/>")[0];
    }
}