package com.marks.smart.system.autocode.core.produced.pojo;

import java.io.Serializable;

/**
 * 文件信息记录
 * @author ykai5
 *
 */
public class OutFileContent implements Serializable{

	private static final long serialVersionUID = 6574450417840856627L;

	//文件名字
	private String fileName;
	
	//文件路径
	private String fileSrc;
	
	//文件内容
	private StringBuffer fileContext;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public StringBuffer getFileContext() {
		return fileContext;
	}

	public void setFileContext(StringBuffer fileContext) {
		this.fileContext = fileContext;
	}
	
}
